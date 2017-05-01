package com.keeper.service;

/*
 * Created by @GoodforGod on 01.05.2017.
 */

import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.TaskFeedType;

import java.util.List;

/**
 * Default Comment
 */
public interface ITaskFeedService {
    List<TaskDTO> getFeed(Long userId, TaskFeedType type);
}
