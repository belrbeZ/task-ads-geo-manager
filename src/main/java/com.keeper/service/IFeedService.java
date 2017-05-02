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

    List<TaskDTO> getAll(Long userId);
    List<TaskDTO> getRecent(Long userId);
    List<TaskDTO> getHot(Long userId);
    List<TaskDTO> getLocal(Long userId);
    List<TaskDTO> getOwned(Long userId);
}
