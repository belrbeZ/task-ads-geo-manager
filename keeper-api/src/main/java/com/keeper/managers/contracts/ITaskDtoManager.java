package com.keeper.managers.contracts;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.dto.TaskDto;
import com.keeper.dto.UserDto;

import java.util.List;

public interface ITaskDtoManager<T> extends ModelDtoManager<T, TaskDto> {

    TaskDto addTask(TaskDto taskDto);

//    TaskDto getTask(Long id);
//    TaskDto getTask(TaskDto taskDto);
    List<TaskDto> getTask(UserDto userDto);
    List<TaskDto> getTask(String theme);
    List<TaskDto> getTask(List<String> tags);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(TaskDto taskDto);

    void removeTask(Long id);
    TaskDto removeTask(TaskDto taskDto);
}
