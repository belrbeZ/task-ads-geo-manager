package com.keeper.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;

import java.util.List;
import java.util.Set;

public interface ITaskManager<T> extends IModelManager<T, TaskDTO> {
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
