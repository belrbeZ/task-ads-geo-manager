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

    /** Get all Tasks */
    Optional<List<TaskDTO>> all(Long userId);

    /** Get all Newly Added Tasks Sorted By LastModifyDate */
    Optional<List<TaskDTO>> recent(Long userId);

    /** Get all Top Chart Tasks (Hot Rated / Most Popular Feed Tasks) */
    Optional<List<TaskDTO>> chart(Long userId);

    /** Get all Tasks which occurred in Users Locations */
    Optional<List<TaskDTO>> local(Long userId);

    /** Get all User Created Tasks */
    Optional<List<TaskDTO>> mine(Long userId);

    /** Get all Tasks User Subscribed On */
    Optional<List<TaskDTO>> subscribed(Long userId);

    /**
     * Search for tasks by theme & filter them
     * @param theme to search tasks by
     * @param feedType FeedType to filter Tasks before Search
     */
    Optional<List<TaskDTO>> searchByTheme(Long userId, String theme, FeedType feedType);

    /**
     * Search for tasks via tags & filter them
     * @param tags to search tasks by
     * @param feedType FeedType to filter Tasks before Search
     */
    Optional<List<TaskDTO>> searchByTags(Long userId, List<String> tags, FeedType feedType);
}
