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
public interface IFeedService {
    List<TaskDTO> getFeed(Long userId, TaskFeedType type);

    List<TaskDTO> all(Long userId);
    List<TaskDTO> recent(Long userId);
    List<TaskDTO> hot(Long userId);
    List<TaskDTO> local(Long userId);
    List<TaskDTO> owned(Long userId);
}
