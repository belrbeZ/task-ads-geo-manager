package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 */

import com.keeper.entity.Task;
import com.keeper.entity.User;

import java.util.List;

/**
 * Default Comment
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */
public interface ITaskService {
    Task addTask(Task task);

    Task getTask(Long id);
    Task getTask(Task task);
    List<Task> getTask(User user);
    List<Task> getTask(String theme);
    List<Task> getTask(List<String> tags);

    List<Task> getAllTasks();

    Task updateTask(Task task);

    void removeTask(Long id);
    Task removeTask(Task task);
}
