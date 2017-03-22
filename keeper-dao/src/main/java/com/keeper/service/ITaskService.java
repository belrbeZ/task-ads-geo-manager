package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 */

import com.keeper.entity.Task;

/**
 * Default Comment
 */
public interface ITaskService {
    Task addTask(Task task);

    Task getTask(Integer id);

    Task updateTask(Task task);

    Task removeTask(Integer id);
}
