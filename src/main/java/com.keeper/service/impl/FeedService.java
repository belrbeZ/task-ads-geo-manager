package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.dao.GeoUser;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoUserDTO;
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
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class FeedService implements IFeedService, IFeedSubmitService {

    private final UserService userService;
    private final TaskService taskService;
    private final RouteService routeService;
    private final GeoUserService pointService;


    private final Map<Long, List<GeoUserDTO>> points = new ConcurrentHashMap<>(); // All user geopoints
    private final Map<Long, List<RouteDTO>> routes = new ConcurrentHashMap<>(); // All user routes

    private final int HOT_FEED_SIZE = 20;

    private final Set<TaskDTO> tasks = new ConcurrentSkipListSet<>(); // All tasks
    private final List<Long> hotTasks = new ArrayList<>(HOT_FEED_SIZE); // Rang of hot tasks ids
    private final Map<Long, List<Long>> userLocalTasks = new ConcurrentHashMap<>(); // Users locations tasks


    // Queue models to proceed
//    private int proceedListSize = 30;
//    private final List<TaskDTO>    tasksToProceed = new ArrayList<>(proceedListSize);
//    private final List<RouteDTO>   routesToProceed = new ArrayList<>(proceedListSize);
//    private final List<GeoUserDTO> pointsToProceed = new ArrayList<>(proceedListSize);

    HashSet<GeoUserDTO> dts;

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
        taskService.getAll().ifPresent(repoTasks -> tasks.addAll(Translator.tasksToDTO(repoTasks)));
        routeService.getAll().ifPresent(repoRoutes -> routes.putAll(Translator.routesToDTO(repoRoutes).stream().parallel().collect(Collectors.groupingBy(RouteDTO::getUserId))));
        pointService.getAll().ifPresent(repoPoints -> points.putAll(Translator.geoUsersToDTO(repoPoints).stream().parallel().collect(Collectors.groupingBy(GeoUserDTO::getUserId))));
    }

    @Override
    public void submit(Task task) {
        tasks.add(Translator.toDTO(task));
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
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    private void update() {

    }

//    @Scheduled(initialDelay = 2500, fixedDelay = 10000)
//    private void proceed() {
//        points.putAll(pointsToProceed.stream().parallel().collect(Collectors.groupingBy(GeoUserDTO::getUserId)));
//        routes.putAll(routesToProceed.stream().parallel().collect(Collectors.groupingBy(RouteDTO::getUserId)));
//        tasks.addAll(tasksToProceed);
//    }

    @Override
    public List<TaskDTO> getHot(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> getRecent(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> getLocal(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> getOwned(Long userId) {
        return null;
    }

    @Override
    public List<TaskDTO> getAll(Long userId) {
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
