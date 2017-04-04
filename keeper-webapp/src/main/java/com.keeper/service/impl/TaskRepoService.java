package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.repo.TaskRepository;
import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository Service to work with Tasks
 */
@Service
public class TaskRepoService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

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
    public List<Task> getTask(List<String> tags) {
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
}
