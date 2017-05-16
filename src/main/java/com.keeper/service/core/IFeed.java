package com.keeper.service.core;

/*
 * Created by @GoodforGod on 01.05.2017.
 */

import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.FeedType;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IFeed {
    Optional<List<TaskDTO>> getAll(Long userId);
    Optional<List<TaskDTO>> getRecent(Long userId);
    Optional<List<TaskDTO>> getHot(Long userId);
    Optional<List<TaskDTO>> getLocal(Long userId);
    Optional<List<TaskDTO>> getOwned(Long userId);
    Optional<List<TaskDTO>> getSubscribed(Long userId);

    Optional<List<TaskDTO>> getByTheme(Long userId, String theme, FeedType feedType);
}
