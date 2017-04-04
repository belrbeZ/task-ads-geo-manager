package com.keeper.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.entity.Task;
import com.keeper.entity.User;
import com.keeper.entity.dto.TaskDTO;
import com.keeper.service.ITaskService;

import java.util.List;
import java.util.Set;

public interface ITaskDtoManager<T> extends IModelDtoManager<T, TaskDTO> {
    TaskDTO addTask(Task TaskDTO);

    TaskDTO getTask(Long id);
    List<TaskDTO> getTask(User user);
    List<TaskDTO> getTask(String theme);
    List<TaskDTO> getTask(Set<String> tags);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTask(TaskDTO task);

    void removeTask(Long id);
    TaskDTO removeTask(TaskDTO task);
}
