package com.keeper.service.core;

/*
 * Created by @GoodforGod on 01.05.2017.
 */

import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.FeedType;

import java.util.List;
import java.util.Optional;

/**
 * Public Contracts To Work With FeedService
 */
public interface IFeed {

    /** Get All Tasks */
    Optional<List<TaskDTO>> getAll(Long userId);

    /** Get All Newly Added Tasks Sorted By LastModifyDate */
    Optional<List<TaskDTO>> getRecent(Long userId);

    /** Get All Top Chart Tasks (Hot Rated) */
    Optional<List<TaskDTO>> getChart(Long userId);

    /** Get All Tasks which occurred in Users Locations */
    Optional<List<TaskDTO>> getLocal(Long userId);

    /** Get All User Created Tasks */
    Optional<List<TaskDTO>> getOwned(Long userId);

    /** Get All Tasks User Subscribed On */
    Optional<List<TaskDTO>> getSubscribed(Long userId);

    /**
     * Get All Tasks By Theme & Filter Them
     * @param theme to Search For
     * @param feedType FeedType to filter Tasks before Search
     */
    Optional<List<TaskDTO>> getByTheme(Long userId, String theme, FeedType feedType);
}
