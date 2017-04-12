package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;

import java.util.List;
import java.util.Set;

public interface ITaskService {
    Task add(Task task);

    Task get(Long id);
    List<Task> get(String theme);
    List<Task> get(Set<String> tags);

    List<Task> getUserTask(Long userId);
    List<Task> getUserTask(String email, String phone);

    List<Task> getAll();

    Task update(Task task);

    void remove(Long id);
}
