package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 */

import com.keeper.entity.Task;

/**
 * Default Comment
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */
public interface ITaskService {
    Task addTask(Task task);

    Task getTask(Long id);

    Task updateTask(Task task);

    Task removeTask(Long id);
}
