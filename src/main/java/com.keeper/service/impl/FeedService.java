package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.dao.GeoUser;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoLocations;
import com.keeper.model.dto.GeoUserDTO;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.IFeedService;
import com.keeper.service.IFeedSubmiter;
import com.keeper.util.Computer;
import com.keeper.util.Translator;
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
    private final Map<Long, TaskDTO>    tasks = new ConcurrentHashMap<>(); // All tasks

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

        //<editor-fold desc="Proceed">

        //<editor-fold desc="Points">
        if(!pointsToProceed.isEmpty()) {
            for (GeoUserDTO geo : points.entrySet().stream().filter(entry -> pointsToProceed.contains(entry.getKey())).map(Map.Entry::getValue).collect(Collectors.toList())) {
                for (Map.Entry<Long, TaskDTO> task : tasks.entrySet()) {
                    if (Computer.geoInRadius(geo, task.getValue())) {
                        Map<Long, GeoLocations> taskLocations = userLocalTasks.putIfAbsent(geo.getUserId(), createTaskNode(task.getKey()));
                        taskLocations.get(task.getKey()).addPoint(geo);
                    }
                }
            }
            pointsToProceed.clear();
        }
        //</editor-fold>

        //<editor-fold desc="Routes">

        if(!routesToProceed.isEmpty()) {

            routesToProceed.clear();
        }
        //</editor-fold>

        //<editor-fold desc="Tasks">

        if(!tasksToProceed.isEmpty()) {
            for (TaskDTO task : tasks.entrySet().stream().map(Map.Entry::getValue).filter(entryTask -> tasksToProceed.contains(entryTask.getId())).collect(Collectors.toList())) {
                for (Map.Entry<Long, GeoUserDTO> geo : points.entrySet()) {
                    if (Computer.geoInRadius(geo.getValue(), task)) {
                        Map<Long, GeoLocations> taskLocations = userLocalTasks.putIfAbsent(geo.getValue().getUserId(), createTaskNode(task.getId()));
                        taskLocations.get(task.getId()).addPoint(geo.getValue());
                    }
                }
            }
            tasksToProceed.clear();
        }
        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Removed">

        //<editor-fold desc="Points">

//        for(Map.Entry<Long, Long> removedPoint : removedPoints.entrySet()) {
//            for(Map.Entry<Long, GeoLocations> geoLocationsEntry : userLocalTasks.get(removedPoint.getValue()).entrySet()) {
//                geoLocationsEntry.getValue().removePoint(removedPoint.getKey());
//            }
//        }

        for(Map<Long, GeoLocations> taskMap : userLocalTasks.entrySet()
                .stream().parallel().filter(entry -> removedPoints.containsValue(entry.getKey()))
                                                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
            for(GeoLocations locations : taskMap.entrySet()
                    .stream().parallel().filter(entry -> removedTask.containsKey(entry.getKey()))
                                                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
                locations.removePoint(removedPoints.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toSet()));
            }
        }

        removedPoints.clear();

        //</editor-fold>

        //<editor-fold desc="Tasks">

        for(Map<Long, GeoLocations> taskMap : userLocalTasks.entrySet()
                .stream().parallel().filter(entry -> removedTask.containsValue(entry.getKey()))
                                                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
            for(Long tastId : taskMap.entrySet().stream().parallel().filter(entry -> removedTask.containsKey(entry.getKey()))
                                                                        .map(Map.Entry::getKey).collect(Collectors.toSet())) {
                taskMap.remove(tastId);
                tasks.remove(tastId);
            }

//            for(Long taskId : removedTask.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList())) {
//                if(taskMap.remove(taskId) != null)
//                    tasks.remove(taskId);
//            }
        }
        removedTask.clear();

        //</editor-fold>

        //<editor-fold desc="Routes">

//        for(Map.Entry<Long, Long> removedRoute : removedRoutes.entrySet()) {
//            for(Map.Entry<Long, GeoLocations> geoLocationsEntry : userLocalTasks.get(removedRoute.getValue()).entrySet()) {
//                geoLocationsEntry.getValue().removeRoute(removedRoute.getKey());
//            }
//        }

        for(Map<Long, GeoLocations> taskMap : userLocalTasks.entrySet()
                .stream().parallel().filter(entry -> removedRoutes.containsValue(entry.getKey()))
                                                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
            for(GeoLocations locations : taskMap.entrySet()
                    .stream().parallel().filter(entry -> removedTask.containsKey(entry.getKey()))
                                                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
                locations.removeRoute(removedRoutes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toSet()));
            }
        }

        removedRoutes.clear();
        //</editor-fold>

        //</editor-fold>

    }

    public static Map<Long, GeoLocations> createTaskNode(Long taskId) {
        return new HashMap<Long, GeoLocations>() {{ put(taskId, new GeoLocations()); }};
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
        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).filter(task -> satisfiesSearch(task.getTheme(), theme)).collect(Collectors.toList()));
    }


    // Search
    public boolean satisfiesSearch(String target, String desired) {
        return target.equals(desired);
    }
}
