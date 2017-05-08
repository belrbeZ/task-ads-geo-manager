package com.keeper.service.modelbased;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface ITaskService extends IModelDTOService<Task, TaskDTO> {
    Optional<List<Task>> getByTheme(String theme);
    Optional<List<Task>> getByTags(List<String> tags);
    Optional<List<Task>> getByUserId(Long userId);
}
