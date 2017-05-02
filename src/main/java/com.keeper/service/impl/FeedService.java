package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.SimpleRoute;
import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.TaskFeedType;
import com.keeper.service.IFeedService;
import com.keeper.service.IFeedSubmitService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Predicate;

/**
 * Default Comment
 */
@Service
public class FeedService implements IFeedService, IFeedSubmitService {

    private final UserService userService;
    private final TaskService taskService;
    private final RouteService routeService;
    private final GeoPointService pointService;


    private final Map<Long, List<SimpleGeoPoint>> points = new ConcurrentHashMap<>(); // All user geopoints
    private final Map<Long, List<SimpleRoute>> routes = new ConcurrentHashMap<>(); // All user routes

    private final int HOT_FEED_SIZE = 20;

    private final Set<TaskDTO> tasks = new ConcurrentSkipListSet<>(); // All tasks
    private final List<Long> hotTasks = new ArrayList<>(HOT_FEED_SIZE); // Rang of hot tasks ids

    // Users local tasks, which are in their track locations
    private final Map<Long, List<Long>> userLocalTasks = new ConcurrentHashMap<>();


    // Queue models to proceed
    private int proceedListSize = 30;

    private final List<TaskDTO>    tasksToProceed = new ArrayList<>(proceedListSize);
    private final List<RouteDTO>   routesToProceed = new ArrayList<>(proceedListSize);
    private final List<GeoPointDTO> pointsToProceed = new ArrayList<>(proceedListSize);


    // Filters for
    private final Predicate<TaskDTO> filterNew   = (task) -> true;
    private final Predicate<TaskDTO> filterHot   = (task) -> true;
    private final Predicate<TaskDTO> filterLocal = (task) -> true;
    private final Predicate<TaskDTO> filterMy    = (task) -> true;

    @Autowired
    public FeedService(UserService userService,
                       TaskService taskService,
                       GeoPointService pointService,
                       RouteService routeService) {

        this.userService = userService;
        this.taskService = taskService;
        this.pointService = pointService;
        this.routeService = routeService;
    }

    @PostConstruct
    private void setup() {
        taskService.getAll().ifPresent(tasks ->  tasksToProceed.addAll(Translator.tasksToDTO(tasks)));
        routeService.getAll().ifPresent(routes -> routesToProceed.addAll(Translator.routesToDTO(routes)));
        pointService.getAll().ifPresent(points -> pointsToProceed.addAll(Translator.geoPointsToDTO(points)));
    }

    @Override
    public void submit(Task task) {
        tasksToProceed.add(Translator.toDTO(task));
    }

    @Override
    public void submit(GeoPoint point) {
        pointsToProceed.add(Translator.toDTO(point));
    }

    @Override
    public void submit(Route route) {
        routesToProceed.add(Translator.toDTO(route));
    }

    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    private void update() {

    }

    @Scheduled(initialDelay = 20000, fixedDelay = 10000)
    private void proceedQueues() {

    }

    @Override
    public List<TaskDTO> hot(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> recent(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> local(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> owned(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> all(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> getFeed(Long userId, TaskFeedType type) {

        List<TaskDTO> feed = new ArrayList<>();

        switch (type) {
            case ALL:
            case HOT:
            case LOCAL:
            case MY:
            case NEW:

            default: break;
        }

        return feed;
    }
}
