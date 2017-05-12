package com.keeper.service.core.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoLocations;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.core.IFeedService;
import com.keeper.service.core.IFeedSubmitService;
import com.keeper.util.GeoComputer;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class FeedService implements IFeedService, IFeedSubmitService {

    private boolean taskLoader = false;
    private boolean pointLoader = false;
    private boolean routeLoader = false;

    private final Map<Long, GeoPointDTO> points = new ConcurrentHashMap<>(); // All user geopoints
    private final Map<Long, RouteDTO>   routes = new ConcurrentHashMap<>(); // All user routes
    private final Map<Long, TaskDTO>    tasks  = new ConcurrentHashMap<>(); // All tasks

    private final int HOT_FEED_SIZE = 20;
    private final int RECENT_FEED_SIZE = 20;

    private final List<Long> hotTasks = new ArrayList<>(HOT_FEED_SIZE); // Rang of hot tasks ids

    // Map < User Id | Map<Task id, locations> >
    private final Map<Long, Map<Long, GeoLocations>> userLocalTasks = new ConcurrentHashMap<>();

    private final Set<Long>  routesToProceed = new HashSet<>();
    private final Set<Long>  pointsToProceed = new HashSet<>();
    private final Set<Long>  tasksToProceed  = new HashSet<>();

    // Geo ID | User Id
    private final Map<Long, Long> removedRoutes = new ConcurrentHashMap<>();
    private final Map<Long, Long> removedPoints = new ConcurrentHashMap<>();
    private final Map<Long, Long> removedTask   = new ConcurrentHashMap<>();

    @PostConstruct
    private void setup() {

//        taskService.getAll().ifPresent(repoTasks -> tasks.putAll(ModelTranslator.tasksToDTO(repoTasks).stream().collect(Collectors.toMap(TaskDTO::getId, Function.identity()))));
//        routeService.getAll().ifPresent(repoRoutes -> routes.putAll(ModelTranslator.routesToDTO(repoRoutes).stream().collect(Collectors.toMap(RouteDTO::getId, Function.identity()))));
//        pointService.getAll().ifPresent(repoPoints -> points.putAll(ModelTranslator.geoUsersToDTO(repoPoints).stream().collect(Collectors.toMap(GeoPointDTO::getId, Function.identity()))));
//
//        tasksToProceed.addAll(tasks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
//        routesToProceed.addAll(routes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
//        pointsToProceed.addAll(points.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));

    }

    //<editor-fold desc="Loads">

    public void loadTasks(List<Task> repoTasks) {
        if(taskLoader)
            return;

        tasks.putAll(ModelTranslator.tasksToDTO(repoTasks).stream().collect(Collectors.toMap(TaskDTO::getId, Function.identity())));
        tasksToProceed.addAll(tasks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        taskLoader = true;
    }

    public void loadRoutes(List<Route> repoRoutes) {
        if(routeLoader)
            return;

        routes.putAll(ModelTranslator.routesToDTO(repoRoutes).stream().collect(Collectors.toMap(RouteDTO::getId, Function.identity())));
        routesToProceed.addAll(routes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        routeLoader = true;
    }

    public void loadPoints(List<GeoPoint> repoPoints) {
        if(pointLoader)
            return;

        points.putAll(ModelTranslator.geoPointsToDTO(repoPoints).stream().collect(Collectors.toMap(GeoPointDTO::getId, Function.identity())));
        pointsToProceed.addAll(points.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        pointLoader = true;
    }

    //</editor-fold>

    //<editor-fold desc="Submiter">

    @Override
    public Task submit(Task task) {
        TaskDTO dto = tasks.get(task.getId());

        if(dto == null)
            tasks.put(task.getId(), ModelTranslator.toDTO(task));
        else
            tasks.replace(task.getId(), ModelTranslator.toDTO(task));

        tasksToProceed.add(task.getId());
        return task;
    }

    @Override
    public GeoPoint submit(GeoPoint point) {
        GeoPointDTO geo = points.get(point.getId());

        if(geo == null)
            points.put(point.getId(), ModelTranslator.toDTO(point));
        else
            points.replace(point.getId(), ModelTranslator.toDTO(point));

        pointsToProceed.add(point.getId());
        return point;
    }

    @Override
    public Route submit(Route route) {
        RouteDTO dto = routes.get(route.getId());

        if(dto == null)
            routes.put(route.getId(), ModelTranslator.toDTO(route));
        else
            routes.replace(route.getId(), ModelTranslator.toDTO(route));

        routesToProceed.add(route.getId());
        return route;
    }

    @Override
    public void removeTask(Long id) {
        TaskDTO modelToDelete = tasks.get(id);

        if(modelToDelete != null) {
            tasks.remove(id);
            removedTask.put(id, modelToDelete.getTopicStarterId());
        }
    }

    @Override
    public void removeGeo(Long id) {
        GeoPointDTO modelToDelete = points.get(id);

        System.out.println("feed remove geo");


        if(modelToDelete != null) {
            points.remove(id);

            System.out.println("points.remove");
            removedPoints.put(id, modelToDelete.getUserId());

            System.out.println("removedPoints.put");
        }
    }

    @Override
    public void removeRoute(Long id) {
        RouteDTO modelToDelete = routes.get(id);

        if(modelToDelete != null) {
            routes.remove(id);
            removedRoutes.put(id, modelToDelete.getUserId());
        }
    }
    //</editor-fold>

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    private void update() {

        // Remove unnecessary models, where there is no need to proceed them
        pointsToProceed.removeAll(pointsToProceed.stream().filter(removedPoints::containsKey).collect(Collectors.toSet()));
        routesToProceed.removeAll(routesToProceed.stream().filter(removedRoutes::containsKey).collect(Collectors.toSet()));
        tasksToProceed.removeAll(tasksToProceed.stream().filter(removedTask::containsKey).collect(Collectors.toSet()));

        //<editor-fold desc="Proceed">

        //<editor-fold desc="Points">

        if(!pointsToProceed.isEmpty()) {
            for (GeoPointDTO geo : points.entrySet().stream().filter(entry -> pointsToProceed.contains(entry.getKey())).map(Map.Entry::getValue).collect(Collectors.toList())) {
                for (Map.Entry<Long, TaskDTO> task : tasks.entrySet()) {
                    if (GeoComputer.geoInRadius(geo, task.getValue())) {
                        Map<Long, GeoLocations> taskLocations = userLocalTasks.putIfAbsent(geo.getUserId(), createTaskNode(task.getKey()));

                        if(taskLocations == null)
                            taskLocations = userLocalTasks.get(geo.getUserId());

                        GeoLocations geoLocations = taskLocations.putIfAbsent(task.getKey(), new GeoLocations());

                        if(geoLocations == null)
                            geoLocations = taskLocations.get(task.getKey());

                        geoLocations.addPoint(geo);
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
                for (Map.Entry<Long, GeoPointDTO> geo : points.entrySet()) {
                    if (GeoComputer.geoInRadius(geo.getValue(), task)) {
                        Map<Long, GeoLocations> taskLocations = userLocalTasks.putIfAbsent(geo.getValue().getUserId(), createTaskNode(task.getId()));

                        if(taskLocations == null)
                            taskLocations = userLocalTasks.get(geo.getValue().getUserId());

                        GeoLocations geoLocations = taskLocations.putIfAbsent(task.getId(), new GeoLocations());

                        if(geoLocations == null)
                            geoLocations = taskLocations.get(task.getId());

                        geoLocations.addPoint(geo.getValue());
                    }
                }
            }
            tasksToProceed.clear();
        }
        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Removed">

        //<editor-fold desc="Points">

        if(!removedPoints.isEmpty()) {
//            for(Map.Entry<Long, Long> entry : removedPoints.entrySet())
//                points.remove(entry.getKey());

            for (Map<Long, GeoLocations> taskMap : userLocalTasks.entrySet()
                    .stream().parallel().filter(entry -> removedPoints.containsValue(entry.getKey()))
                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
                for (GeoLocations locations : taskMap.entrySet()
                        .stream().parallel().filter(entry -> removedTask.containsKey(entry.getKey()))
                        .map(Map.Entry::getValue).collect(Collectors.toSet())) {
                    locations.removePoint(removedPoints.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toSet()));
                }
            }
            removedPoints.clear();
        }

        //</editor-fold>

        //<editor-fold desc="Tasks">

        if(!removedTask.isEmpty()) {
//            for(Map.Entry<Long, Long> entry : removedTask.entrySet())
//                tasks.remove(entry.getKey());

            for(Map.Entry<Long, Map<Long, GeoLocations>> taskMap : userLocalTasks.entrySet()) {
                for(Map.Entry<Long, Long> taskIdToRemove : removedTask.entrySet()) {
                    if (taskMap.getValue().containsKey(taskIdToRemove.getKey())) {
                        taskMap.getValue().remove(taskIdToRemove.getKey());
                    }
                }
            }
            removedTask.clear();
        }

        //</editor-fold>

        //<editor-fold desc="Routes">

        if(!removedRoutes.isEmpty()) {
//            for(Map.Entry<Long, Long> entry : removedRoutes.entrySet())
//                routes.remove(entry.getKey());

            for (Map<Long, GeoLocations> taskMap : userLocalTasks.entrySet()
                    .stream().parallel().filter(entry -> removedRoutes.containsValue(entry.getKey()))
                    .map(Map.Entry::getValue).collect(Collectors.toSet())) {
                for (GeoLocations locations : taskMap.entrySet()
                        .stream().parallel().filter(entry -> removedTask.containsKey(entry.getKey()))
                        .map(Map.Entry::getValue).collect(Collectors.toSet())) {
                    locations.removeRoute(removedRoutes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toSet()));
                }
            }
            removedRoutes.clear();
        }

        //</editor-fold>

        //</editor-fold>

    }

    private static Map<Long, GeoLocations> createTaskNode(Long taskId) {
        return new HashMap<Long, GeoLocations>() {{ put(taskId, new GeoLocations()); }};
    }

    @Override
    public Optional<List<TaskDTO>> getHot(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(tasks.entrySet().stream().filter(task -> hotTasks.contains(task.getKey())).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getRecent(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).sorted(Comparator.comparing(TaskDTO::getLastModifyDate)).limit(RECENT_FEED_SIZE).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getLocal(Long userId) {
        if(userId == null)
            return Optional.empty();

        Map<Long, GeoLocations> userLocals = userLocalTasks.get(userId);

        if(userLocals == null)
            return Optional.empty();

        List<Long> taskIds = userLocals.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());

        if(taskIds == null || taskIds.isEmpty())
            return Optional.empty();

        return Optional.of(tasks.entrySet().stream().filter(task -> taskIds.contains(task.getKey())).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getOwned(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(tasks.entrySet().stream().filter(task -> task.getValue().getTopicStarterId().equals(userId)).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getAll(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(tasks.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskDTO>> getByTheme(String theme) {
        if(Validator.isStrEmpty(theme))
            return Optional.empty();

        return Optional.of(tasks.entrySet().stream().filter(task -> satisfiesSearch(task.getValue().getTheme(), theme)).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    // Search
    private boolean satisfiesSearch(String target, String desired) {
        return target.equals(desired);
    }
}
