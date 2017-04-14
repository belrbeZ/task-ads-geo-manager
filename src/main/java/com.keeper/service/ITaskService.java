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

    List<Task> get(String theme);
//    List<Task> get(Set<Long> tags);//???
    List<Task> getUserTask(String email, String phone);
    List<Task> getUserByIdTask(Long userId);

    Task removeByTopicStarterId(Long topicStarterId);

}
