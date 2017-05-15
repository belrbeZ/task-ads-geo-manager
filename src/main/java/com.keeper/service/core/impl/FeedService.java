package com.keeper.service.core.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.util.GeoLocations;
import com.keeper.service.core.IFeed;
import com.keeper.service.core.IFeedSubmit;
import com.keeper.util.GeoComputer;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import com.keeper.util.resolvers.ErrorMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
@Primary
public class FeedService implements IFeed, IFeedSubmit {

    private boolean taskLoader = false;
    private boolean pointLoader = false;
    private boolean routeLoader = false;

    private static final Logger logger = LoggerFactory.getLogger(FeedService.class);

    private final Map<Long, GeoPoint> points = new ConcurrentHashMap<>(); // All geopoints
    private final Map<Long, Route>   routes = new ConcurrentHashMap<>(); // All routes
    private final Map<Long, Task>    tasks  = new ConcurrentHashMap<>(); // All tasks

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

    protected final SubscriptionService subsService;

    @Autowired
    public FeedService(SubscriptionService subsService) {
        this.subsService = subsService;
    }

    //<editor-fold desc="Loads">

    public void loadTasks(List<Task> repoTasks) {
        if(taskLoader)
            return;

        tasks.putAll((repoTasks).stream().collect(Collectors.toMap(Task::getId, Function.identity())));
        tasksToProceed.addAll(tasks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        taskLoader = true;
    }

    public void loadRoutes(List<Route> repoRoutes) {
        if(routeLoader)
            return;

        routes.putAll((repoRoutes).stream().collect(Collectors.toMap(Route::getId, Function.identity())));
        routesToProceed.addAll(routes.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        routeLoader = true;
    }

    public void loadPoints(List<GeoPoint> repoPoints) {
        if(pointLoader)
            return;

        points.putAll((repoPoints).stream().collect(Collectors.toMap(GeoPoint::getId, Function.identity())));
        pointsToProceed.addAll(points.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        pointLoader = true;
    }

    //</editor-fold>

    //<editor-fold desc="Submiter">

    @Override
    public Task submit(Task task) {
        Task dto = tasks.get(task.getId());

        if(dto == null)
            tasks.put(task.getId(), task);
        else
            tasks.replace(task.getId(), task);

        tasksToProceed.add(task.getId());
        return task;
    }

    @Override
    public GeoPoint submit(GeoPoint point) {
        GeoPoint geo = points.get(point.getId());

        if(geo == null)
            points.put(point.getId(), point);
        else
            points.replace(point.getId(), point);

        pointsToProceed.add(point.getId());
        return point;
    }

    @Override
    public Route submit(Route route) {
        Route dto = routes.get(route.getId());

        if(dto == null)
            routes.put(route.getId(), route);
        else
            routes.replace(route.getId(), route);

        routesToProceed.add(route.getId());
        return route;
    }

    @Override
    public void removeTask(Long id) {
        Task modelToDelete = tasks.get(id);

        if(modelToDelete != null) {
            tasks.remove(id);
            removedTask.put(id, modelToDelete.getTopicStarterId());
        }
        else logger.warn("[FEED] " + ErrorMessageResolver.REMOVE_MODEL_NULLABLE + " [ID] : " + id);
    }

    @Override
    public void removeGeo(Long id) {
        GeoPoint modelToDelete = points.get(id);

        if(modelToDelete != null) {
            points.remove(id);
            removedPoints.put(id, modelToDelete.getUserId());
        }
        else logger.warn("[FEED] " + ErrorMessageResolver.REMOVE_MODEL_NULLABLE + " [ID] : " + id);
    }

    @Override
    public void removeRoute(Long id) {
        Route modelToDelete = routes.get(id);

        if(modelToDelete != null) {
            routes.remove(id);
            removedRoutes.put(id, modelToDelete.getUserId());
        }
        else logger.warn("[FEED] " + ErrorMessageResolver.REMOVE_MODEL_NULLABLE + " [ID] : " + id);
    }

    //</editor-fold>

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    private void update() {

        // Remove unnecessary models, where there is no need to proceed them
        pointsToProceed.removeAll(pointsToProceed.stream()
                .filter(removedPoints::containsKey)
                .collect(Collectors.toSet()));
        routesToProceed.removeAll(routesToProceed.stream()
                .filter(removedRoutes::containsKey)
                .collect(Collectors.toSet()));
        tasksToProceed.removeAll(tasksToProceed.stream()
                .filter(removedTask::containsKey)
                .collect(Collectors.toSet()));

        //<editor-fold desc="Proceed">

        //<editor-fold desc="Points">

        if(!pointsToProceed.isEmpty()) {
            for (GeoPoint geo : points.entrySet().stream()
                    .filter(entry -> pointsToProceed.contains(entry.getKey()))
                    .map(Map.Entry::getValue).collect(Collectors.toList())) {
                for (Map.Entry<Long, Task> task : tasks.entrySet()) {
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
            for (Task task : tasks.entrySet().stream().map(Map.Entry::getValue)
                    .filter(entryTask -> tasksToProceed.contains(entryTask.getId()))
                    .collect(Collectors.toList())) {
                for (Map.Entry<Long, GeoPoint> geo : points.entrySet()) {
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

        //</editor-fold>

    }

    private static Map<Long, GeoLocations> createTaskNode(Long taskId) {
        return new HashMap<Long, GeoLocations>() {{ put(taskId, new GeoLocations()); }};
    }

    @Override
    public Optional<List<TaskDTO>> getHot(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(subsService.modifyTasksCounter(userId, ModelTranslator.tasksToDTO(tasks.entrySet().stream()
                .filter(task -> hotTasks.contains(task.getKey()))
                .map(Map.Entry::getValue).collect(Collectors.toList()))));
    }

    @Override
    public Optional<List<TaskDTO>> getRecent(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(subsService.modifyTasksCounter(userId, ModelTranslator.tasksToDTO(tasks.entrySet().stream()
                .map(Map.Entry::getValue).sorted(Comparator.comparing(Task::getLastModifyDate))
                .limit(RECENT_FEED_SIZE).collect(Collectors.toList()))));
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

        return Optional.of(subsService.modifyTasksCounter(userId, ModelTranslator.tasksToDTO(tasks.entrySet()
                .stream().filter(task -> taskIds.contains(task.getKey()))
                .map(Map.Entry::getValue).collect(Collectors.toList()))));
    }

    @Override
    public Optional<List<TaskDTO>> getOwned(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(subsService.modifyTasksCounter(userId, ModelTranslator.tasksToDTO(tasks.entrySet()
                .stream().filter(task -> task.getValue().getTopicStarterId().equals(userId))
                .map(Map.Entry::getValue).collect(Collectors.toList()))));
    }

    @Override
    public Optional<List<TaskDTO>> getAll(Long userId) {
        if(userId == null)
            return Optional.empty();

        return Optional.of(subsService.modifyTasksCounter(userId, ModelTranslator.tasksToDTO(tasks.entrySet().stream()
                .map(Map.Entry::getValue).collect(Collectors.toList()))));
    }

    @Override
    public Optional<List<TaskDTO>> getByTheme(Long userId, String theme) {
        if(Validator.isStrEmpty(theme))
            return Optional.empty();

        return Optional.of(subsService.modifyTasksCounter(userId, ModelTranslator.tasksToDTO(tasks.entrySet().stream()
                .filter(task -> satisfiesSearch(task.getValue().getTheme(), theme))
                .map(Map.Entry::getValue).collect(Collectors.toList()))));
    }

    private boolean satisfiesSearch(String target, String desired) {
        return target.equals(desired);
    }
}
