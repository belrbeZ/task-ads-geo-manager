package com.keeper.service.core;

import com.keeper.model.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 13.05.2017
 */
public interface ISubscriptionModify {

    /** TRANSACTIONAL */
    Optional<Long> viewTask(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> modifyTask(Long taskId);

    List<TaskDTO> modifyTasksCounter(List<TaskDTO> tasks);
}
