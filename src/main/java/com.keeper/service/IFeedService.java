package com.keeper.service;

/*
 * Created by @GoodforGod on 01.05.2017.
 */

import com.keeper.model.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IFeedService {
    Optional<List<TaskDTO>> getAll(Long userId);
    Optional<List<TaskDTO>> getRecent(Long userId);
    Optional<List<TaskDTO>> getHot(Long userId);
    Optional<List<TaskDTO>> getLocal(Long userId);
    Optional<List<TaskDTO>> getOwned(Long userId);

    Optional<List<TaskDTO>> getByTheme(String theme);
}
