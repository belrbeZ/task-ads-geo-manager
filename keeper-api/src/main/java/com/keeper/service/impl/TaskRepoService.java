package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import com.keeper.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Repository Service to work with Tasks
 */
//@Service(value = "taskService")
public class TaskRepoService implements ITaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

//    @Autowired
//    private TaskRepository repository;

    @Override
    public Task add(Task task) {
        return null;
    }

    @Override
    public Task get(Long id) {
        return null;
    }

    @Override
    public List<Task> get(String theme) {
        return null;
    }

    @Override
    public List<Task> get(Set<String> tags) {
        return null;
    }

    @Override
    public List<Task> getUserTask(Long userId) {
        return null;
    }

    @Override
    public List<Task> getUserTask(String email, String phone) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
