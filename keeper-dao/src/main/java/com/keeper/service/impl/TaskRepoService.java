package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Task;
import com.keeper.entity.User;
import com.keeper.repo.TaskRepository;
import com.keeper.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Repository Service to work with Tasks
 */
@Service(value = "taskService")
public class TaskRepoService implements ITaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

//    @Autowired
//    private TaskRepository repository;

    @Override
    public Task addTask(Task task) {
        return null;
    }

    @Override
    public Task getTask(Long id) {
        return null;
    }

    @Override
    public List<Task> getTask(User user) {
        return null;
    }

    @Override
    public List<Task> getTask(String theme) {
        return null;
    }

    @Override
    public List<Task> getTask(Set<String> tags) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public void removeTask(Long id) {

    }

    @Override
    public Task removeTask(Task task) {
        return null;
    }
}
