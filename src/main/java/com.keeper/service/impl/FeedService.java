package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.GeoUser;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoUserDTO;
import com.keeper.model.dto.GeoLocations;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.IFeedService;
import com.keeper.service.IFeedSubmiter;
import com.keeper.util.Computer;
import com.keeper.util.Translator;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
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

    private final Map<Long, GeoUserDTO> points = new ConcurrentHashMap<>(); // All user geopoints
    private final Map<Long, RouteDTO>   routes = new ConcurrentHashMap<>(); // All user routes
    private final Map<Long, TaskDTO> tasks = new ConcurrentHashMap<>(); // All tasks

    private final int HOT_FEED_SIZE = 20;
    private final int RECENT_FEED_SIZE = 20;

    private final List<Long> hotTasks = new ArrayList<>(HOT_FEED_SIZE); // Rang of hot tasks ids

    // Map < User Id | Map<Task id, locations> >
    private final Map<Long, Map<Long, GeoLocations>> userLocalTasks = new ConcurrentHashMap<>();


    private final List<Long>  routesToProceed = new ArrayList<>();
    private final List<Long>  pointsToProceed = new ArrayList<>();
    private final List<Long>  tasksToProceed   = new ArrayList<>();

    // Geo ID | User Id
    private final Map<Long, Long> removedRoutes = new ConcurrentHashMap<>();
    private final Map<Long, Long> removedPoints = new ConcurrentHashMap<>();
    private final Map<Long, Long> removedTask   = new ConcurrentHashMap<>();


    // Filters for
    private final Predicate<TaskDTO> filterNew   = (task) -> true;
    private final Predicate<TaskDTO> filterHot   = (task) -> true;
    private final Predicate<TaskDTO> filterLocal = (task) -> true;
    private final Predicate<TaskDTO> filterMy    = (task) -> true;

    public void loadTasks(List<Task> repoTasks) {
        tasks.putAll(Translator.tasksToDTO(repoTasks).stream().collect(Collectors.toMap(TaskDTO::getId, Function.identity())));
        tasksToProceed.addAll(tasks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    public void loadRoutes(List<Route> repoRoutes) {
        routes.putAll(Translator.routesToDTO(repoRoutes).stream().collect(Collectors.toMap(RouteDTO::getId, Function.identity())));
        routesToProceed.addAll(routes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    public void loadPoints(List<GeoUser> repoPoints) {
        points.putAll(Translator.geoUsersToDTO(repoPoints).stream().collect(Collectors.toMap(GeoUserDTO::getId, Function.identity())));
        pointsToProceed.addAll(points.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    @PostConstruct
    private void setup() {
//        taskService.getAll().ifPresent(repoTasks -> tasks.putAll(Translator.tasksToDTO(repoTasks).stream().collect(Collectors.toMap(TaskDTO::getId, Function.identity()))));
//        routeService.getAll().ifPresent(repoRoutes -> routes.putAll(Translator.routesToDTO(repoRoutes).stream().collect(Collectors.toMap(RouteDTO::getId, Function.identity()))));
//        pointService.getAll().ifPresent(repoPoints -> points.putAll(Translator.geoUsersToDTO(repoPoints).stream().collect(Collectors.toMap(GeoUserDTO::getId, Function.identity()))));
//
//        tasksToProceed.addAll(tasks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
//        routesToProceed.addAll(routes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
//        pointsToProceed.addAll(points.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));

    }

    //<editor-fold desc="Submiter">

    @Override
    public void submit(Task task) {
        tasksToProceed.add(tasks.putIfAbsent(task.getId(), Translator.toDTO(task)).getId());
    }

    @Override
    public void submit(GeoUser point) {
        pointsToProceed.add(points.putIfAbsent(point.getId(), Translator.toDTO(point)).getId());
    }

    @Override
    public void submit(Route route) {
        routesToProceed.add(routes.putIfAbsent(route.getId(), Translator.toDTO(route)).getId());
    }

    @Override
    public void remove(Task task) {
        removedTask.put(task.getId(), task.getTopicStarterId());
//        tasks.remove(task.getId());
    }

//    private void deletePoint(Long userId, Long pointId) {
//        List<GeoUserDTO> tempPoints = points.get(userId);
//        if(tempPoints != null) {
//            tempPoints = tempPoints.stream().filter(route -> route.getId().equals(pointId)).collect(Collectors.toList());
//            points.replace(userId, tempPoints);
//        }
//    }

    @Override
    public void remove(GeoUser point) {
        removedPoints.put(point.getId(), point.getUserId());
    }

//    private void deleteRoute(Long userId, Long routeId) {
//        List<RouteDTO> tempRoutes = routes.get(userId);
//        if(tempRoutes != null) {
//            tempRoutes = tempRoutes.stream().filter(route -> route.getId().equals(routeId)).collect(Collectors.toList());
//            routes.replace(userId, tempRoutes);
//        }
//    }

    @Override
    public void remove(Route route) {
        removedPoints.put(route.getId(), route.getUserId());
    }
    //</editor-fold>

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    private void update() {

        List<Long> succededPoints   = new ArrayList<>();
        List<Long> succededRoutes   = new ArrayList<>();
        List<Long> succededTasks    = new ArrayList<>();

        // POINTS & ROUTES
        for (Long geoId : pointsToProceed) {
            for (Map.Entry<Long, TaskDTO> task : tasks.entrySet()) {
                GeoUserDTO geo = points.get(geoId);
                if (Computer.geoInRadius(geo.getLatitude(), geo.getLongitude(), task.getValue().getOriginGeoPoint(), geo.getRadius())) {
                    Map<Long, GeoLocations> taskLocations = userLocalTasks.get(geo.getUserId());
                    if(taskLocations == null)
                            taskLocations = userLocalTasks.put(task.getKey(),
                                    new HashMap<Long, GeoLocations>() {{ put(task.getKey(), new GeoLocations()); }});

                    taskLocations.get(task.getKey()).addPoint(geo);
                    succededPoints.add(geo.getId());
                }
            }

            // ROUTES
        }

        // TASKS
        for(TaskDTO task : tasks.entrySet().stream().map(Map.Entry::getValue).filter(entryTask -> tasksToProceed.contains(entryTask.getId())).collect(Collectors.toList())) {
            for(GeoUserDTO geo : points.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList())) {
                if (Computer.geoInRadius(geo.getLatitude(), geo.getLongitude(), task.getOriginGeoPoint(), geo.getRadius())) {
                    Map<Long, GeoLocations> taskLocations = userLocalTasks.putIfAbsent(geo.getUserId(),
                            new HashMap<Long, GeoLocations>() {{ put(task.getId(), new GeoLocations()); }});

                    taskLocations.get(task.getId()).addPoint(geo);
                    succededTasks.add(task.getId());
                }
            }
        }

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


        pointsToProceed.removeAll(succededPoints);
        routesToProceed.removeAll(succededRoutes);
        tasksToProceed.removeAll(succededTasks);


        //<editor-fold desc="Removed">

       for(Map.Entry<Long,Long> removedPoint : removedPoints.entrySet()) {
           for(Map.Entry<Long, GeoLocations> geoLocationsEntry : userLocalTasks.get(removedPoint.getValue()).entrySet()) {
               geoLocationsEntry.getValue().removePoint(removedPoint.getKey());
           }
       }

        for(Map.Entry<Long,Long> removedRoute : removedRoutes.entrySet()) {
            for(Map.Entry<Long, GeoLocations> geoLocationsEntry : userLocalTasks.get(removedRoute.getValue()).entrySet()) {
                geoLocationsEntry.getValue().removeRoute(removedRoute.getKey());
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
        return Optional.of(tasks.entrySet().stream().filter(task -> userLocalTasks.get(userId) != null).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getOwned(Long userId) {
        return Optional.of(tasks.entrySet().stream().filter(task -> task.getKey().equals(userId)).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getAll(Long userId) {
        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getByTheme(String theme) {
        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).filter(task -> task.getTheme().equals(theme)).collect(Collectors.toList()));
    }
}
