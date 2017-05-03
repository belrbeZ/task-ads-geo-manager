package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.GeoUser;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoUserDTO;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.IFeedService;
import com.keeper.service.IFeedSubmiter;
import com.keeper.util.Computer;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class FeedService implements IFeedService, IFeedSubmiter {

    private final UserService userService;
    private final TaskService taskService;
    private final RouteService routeService;
    private final GeoUserService pointService;


    private final Map<Long, List<GeoUserDTO>> points = new ConcurrentHashMap<>(); // All user geopoints
    private final Map<Long, List<RouteDTO>> routes = new ConcurrentHashMap<>(); // All user routes

    private final int HOT_FEED_SIZE = 20;
    private final int RECENT_FEED_SIZE = 20;

    private final Map<Long, TaskDTO> tasks = new ConcurrentHashMap<>(); // All tasks
    private final List<Long> hotTasks = new ArrayList<>(HOT_FEED_SIZE); // Rang of hot tasks ids
    private final Map<Long, HashSet<Long>> userLocalTasks = new ConcurrentHashMap<>(); // Users locations tasks


    private final List<RouteDTO>    routesToProceed = new ArrayList<>();
    private final List<GeoUserDTO>  pointsToProceed = new ArrayList<>();
    private final List<TaskDTO>     tasksToProceed   = new ArrayList<>();

    // Geo ID | User Id
    private final Map<Long, Long> removedRoutes = new ConcurrentHashMap<>();
    private final Map<Long, Long> removedPoints = new ConcurrentHashMap<>();
    private final Map<Long, Long> removedTask   = new ConcurrentHashMap<>();


    // Filters for
    private final Predicate<TaskDTO> filterNew   = (task) -> true;
    private final Predicate<TaskDTO> filterHot   = (task) -> true;
    private final Predicate<TaskDTO> filterLocal = (task) -> true;
    private final Predicate<TaskDTO> filterMy    = (task) -> true;

    @Autowired
    public FeedService(UserService userService,
                       TaskService taskService,
                       GeoUserService pointService,
                       RouteService routeService) {

        this.userService = userService;
        this.taskService = taskService;
        this.pointService = pointService;
        this.routeService = routeService;
    }

    @PostConstruct
    private void setup() {
        taskService.getAll().ifPresent(repoTasks -> tasksToProceed.addAll(Translator.tasksToDTO(repoTasks)));
        routeService.getAll().ifPresent(repoRoutes -> routesToProceed.addAll(Translator.routesToDTO(repoRoutes)));
        pointService.getAll().ifPresent(repoPoints -> pointsToProceed.addAll(Translator.geoUsersToDTO(repoPoints)));
    }

    //<editor-fold desc="Submiter">

    @Override
    public void submit(Task task) {
        tasks.put(task.getId(), Translator.toDTO(task));
    }

    @Override
    public void submit(GeoUser point) {
        GeoUserDTO tempPoint = Translator.toDTO(point);

        List<GeoUserDTO> tempPoints = points.get(point.getUserId());
        if(tempPoints == null)
            points.put(point.getUserId(), new ArrayList<GeoUserDTO>() {{ add(tempPoint); }});
        else {
            tempPoints.add(tempPoint);
            points.replace(point.getUserId(), tempPoints);
        }
        pointsToProceed.add(tempPoint);
    }

    @Override
    public void submit(Route route) {
        RouteDTO tempRoute = Translator.toDTO(route);

        List<RouteDTO> tempRoutes = routes.get(route.getUserId());
        if(tempRoutes == null)
            routes.put(route.getUserId(), new ArrayList<RouteDTO>() {{ add(tempRoute); }});
        else {
            tempRoutes.add(tempRoute);
            routes.replace(route.getUserId(), tempRoutes);
        }
        routesToProceed.add(tempRoute);
    }

    @Override
    public void remove(Task task) {
        tasks.remove(task.getId());
    }

    private void deletePoint(Long userId, Long pointId) {
        List<GeoUserDTO> tempPoints = points.get(userId);
        if(tempPoints != null) {
            tempPoints = tempPoints.stream().filter(route -> route.getId().equals(pointId)).collect(Collectors.toList());
            points.replace(userId, tempPoints);
        }
    }

    @Override
    public void remove(GeoUser point) {
        removedPoints.put(point.getId(), point.getUserId());
    }

    private void deleteRoute(Long userId, Long routeId) {
        List<RouteDTO> tempRoutes = routes.get(userId);
        if(tempRoutes != null) {
            tempRoutes = tempRoutes.stream().filter(route -> route.getId().equals(routeId)).collect(Collectors.toList());
            routes.replace(userId, tempRoutes);
        }
    }

    @Override
    public void remove(Route route) {
        removedPoints.put(route.getId(), route.getUserId());
    }
    //</editor-fold>

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    private void update() {
        tasks.putAll(tasksToProceed.stream().parallel().collect(Collectors.toConcurrentMap(TaskDTO::getId, Function.identity())));
        Map<Long, List<GeoUserDTO>> geoPointsProceed = pointsToProceed.stream().parallel().collect(Collectors.groupingBy(GeoUserDTO::getUserId));
        Map<Long, List<RouteDTO>> routesProceed = routesToProceed.stream().parallel().collect(Collectors.groupingBy(RouteDTO::getUserId));

//        Map<Long, List<Long>> succedTasks = tasks
//                .stream().map(task -> new Map.Entry(task.getId(), geoPointsProceed.entrySet()
//                        .stream().map(geopoints -> geopoints.getValue()
//                                .stream().filter(geo ->
//                                        Computer.geoInRadius(task.getOriginGeoPoint().getLatitude(),
//                                                            task.getOriginGeoPoint().getLongitude(),
//                                                            geo.getLatitude(),
//                                                            geo.getLongitude(),
//                                                            task.getOriginGeoPoint().getRadius()))
//                                                                .collect(Collectors.toList())))).collect(Collectors.mapping(value -> ));

        //<editor-fold desc="Proceed">

        for(final Map.Entry<Long, TaskDTO> entryTask : tasks.entrySet()) {

            for (final Map.Entry<Long, List<GeoUserDTO>> geos : geoPointsProceed.entrySet()) {
                for (GeoUserDTO geo : geos.getValue()) {
                    if (Computer.geoInRadius(entryTask.getValue().getOriginGeoPoint(), geo.getLatitude(), geo.getLongitude())
                            || Computer.geoInRadius(geo.getLatitude(), geo.getLongitude(), entryTask.getValue().getOriginGeoPoint(), geo.getRadius())) {

                        HashSet<Long> tasksIds = userLocalTasks.get(geo.getUserId());
                        if (tasksIds == null) {
                            userLocalTasks.put(geo.getUserId(), new HashSet<Long>() {{ add(entryTask.getValue().getId()); }});
                        } else {
                            tasksIds.add(entryTask.getValue().getId());
                            userLocalTasks.put(geo.getUserId(), tasksIds);
                        }
                    }
                }
            }


            for (final Map.Entry<Long, List<RouteDTO>> routes : routesProceed.entrySet()) {
                for (RouteDTO route : routes.getValue()) {
                    for (SimpleGeoPoint geo : route.getPoints())
                        if (Computer.geoInRadius(entryTask.getValue().getOriginGeoPoint(), geo.getLatitude(), geo.getLongitude())
                                || Computer.geoInRadius(geo.getLatitude(), geo.getLongitude(), entryTask.getValue().getOriginGeoPoint(), geo.getRadius())) {
                            HashSet<Long> tasksIds = userLocalTasks.get(route.getUserId());
                            if (tasksIds == null) {
                                userLocalTasks.put(route.getUserId(), new HashSet<Long>() {{ add(entryTask.getValue().getId()); }});
                            } else {
                                tasksIds.add(entryTask.getValue().getId());
                                userLocalTasks.put(route.getUserId(), tasksIds);
                            }
                        }
                }
            }
        }


        pointsToProceed.clear();
        routesToProceed.clear();

        //</editor-fold>


        //<editor-fold desc="Removed">

        for(final Map.Entry<Long, TaskDTO> entryTask : tasks.entrySet()) {

            for (final Map.Entry<Long, List<GeoUserDTO>> geos : geoPointsProceed.entrySet()) {
                for (GeoUserDTO geo : geos.getValue()) {
                    if (Computer.geoInRadius(entryTask.getValue().getOriginGeoPoint(), geo.getLatitude(), geo.getLongitude())
                            || Computer.geoInRadius(geo.getLatitude(), geo.getLongitude(), entryTask.getValue().getOriginGeoPoint(), geo.getRadius())) {

                        HashSet<Long> tasksIds = userLocalTasks.get(geo.getUserId());
                        if (tasksIds == null) {
                            userLocalTasks.put(geo.getUserId(), new HashSet<Long>() {{ add(entryTask.getValue().getId()); }});
                        } else {
                            tasksIds.add(entryTask.getValue().getId());
                            userLocalTasks.put(geo.getUserId(), tasksIds);
                        }
                    }
                }
            }


            for (final Map.Entry<Long, List<RouteDTO>> routes : routesProceed.entrySet()) {
                for (RouteDTO route : routes.getValue()) {
                    for (SimpleGeoPoint geo : route.getPoints())
                        if (Computer.geoInRadius(entryTask.getValue().getOriginGeoPoint(), geo.getLatitude(), geo.getLongitude())
                                || Computer.geoInRadius(geo.getLatitude(), geo.getLongitude(), entryTask.getValue().getOriginGeoPoint(), geo.getRadius())) {
                            HashSet<Long> tasksIds = userLocalTasks.get(route.getUserId());
                            if (tasksIds == null) {
                                userLocalTasks.put(route.getUserId(), new HashSet<Long>() {{ add(entryTask.getValue().getId()); }});
                            } else {
                                tasksIds.add(entryTask.getValue().getId());
                                userLocalTasks.put(route.getUserId(), tasksIds);
                            }
                        }
                }
            }
        }


        removedPoints.clear();
        removedRoutes.clear();

        //</editor-fold>
    }

    @Override
    public Optional<List<TaskDTO>> getHot(Long userId) {
        return Optional.of(tasks.entrySet().stream().filter(task -> hotTasks.contains(task.getKey())).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getRecent(Long userId) {
        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).limit(RECENT_FEED_SIZE).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getLocal(Long userId) {
        return Optional.of(tasks.entrySet().stream().filter(task -> userLocalTasks.get(userId).contains(task.getKey())).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getOwned(Long userId) {
        return Optional.of(tasks.entrySet().stream().filter(task -> task.getKey().equals(userId)).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getAll(Long userId) {
        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
    }
}
