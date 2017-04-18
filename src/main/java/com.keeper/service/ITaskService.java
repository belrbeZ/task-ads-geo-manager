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

    List<Task> getByTheme(String theme);
    List<Task> getByTags(List<String> tags);
    List<Task> getByEmailOrPhone(String email, String phone);
    List<Task> getByUserId(Long userId);

    Task removeByUserId(Long topicStarterId);

}
