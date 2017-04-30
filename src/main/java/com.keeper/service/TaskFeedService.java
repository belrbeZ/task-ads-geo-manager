package com.keeper.service;

/*
 * Created by @GoodforGod on 30.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.SimpleRoute;
import com.keeper.model.dao.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Default Comment
 */
@Service
public class TaskFeedService {

    private final Map<Long, List<SimpleGeoPoint>> points = new ConcurrentHashMap<>();
    private final Map<Long, List<SimpleRoute>> routes = new ConcurrentHashMap<>();
    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();

    public TaskFeedService() {

    }

    @PostConstruct
    private void setup() {

    }

    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    private void update() {

    }
}
