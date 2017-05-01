package com.keeper.service;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.SimpleRoute;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.dto.UserDTO;
import com.keeper.model.types.TaskFeedType;
import com.keeper.service.impl.GeoPointService;
import com.keeper.service.impl.RouteService;
import com.keeper.service.impl.TaskService;
import com.keeper.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

/**
 * Default Comment
 */
@Service
public class TaskFeedService implements ITaskFeedService {

    private final UserService userService;
    private final TaskService taskService;
    private final RouteService routeService;
    private final GeoPointService pointService;


    private final Map<Long, List<SimpleGeoPoint>> points = new ConcurrentHashMap<>();
    private final Map<Long, List<SimpleRoute>> routes = new ConcurrentHashMap<>();

    private final Set<TaskDTO> tasks = new ConcurrentSkipListSet<>();
    private final List<Long> hotTasks = new ArrayList<>();
    private final Map<Long, List<Long>> localTasks = new ConcurrentHashMap<>();


    private final Queue<TaskDTO>    tasksToProceed = new LinkedBlockingQueue<>();
    private final Queue<UserDTO>    usersToProceed = new LinkedBlockingQueue<>();
    private final Queue<RouteDTO>   routesToProceed = new LinkedBlockingQueue<>();
    private final Queue<GeoPointDTO> pointsToProceed = new LinkedBlockingQueue<>();


    private final Predicate<TaskDTO> filterNew   = (task) -> true;
    private final Predicate<TaskDTO> filterHot   = (task) -> true;
    private final Predicate<TaskDTO> filterLocal = (task) -> true;
    private final Predicate<TaskDTO> FilterMy    = (task) -> true;

    @Autowired
    public TaskFeedService(UserService userService,
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

    }

    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    private void update() {

    }

    @Override
    public List<TaskDTO> getFeed(Long userId, TaskFeedType type) {
        return null;
    }
}
