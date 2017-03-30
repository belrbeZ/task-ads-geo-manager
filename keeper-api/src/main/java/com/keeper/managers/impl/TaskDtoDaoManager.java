package com.keeper.managers.impl;

import com.keeper.dto.TaskDto;
import com.keeper.dto.UserDto;
import com.keeper.entity.Task;
import com.keeper.managers.contracts.ITaskDtoManager;
import com.keeper.service.impl.TaskRepoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class TaskDtoDaoManager implements ITaskDtoManager<Task> {

    @Resource
    private TaskRepoService taskRepoService;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public List<TaskDto> getTask(UserDto userDto) {
        return null;
    }

    @Override
    public List<TaskDto> getTask(String theme) {
        return null;
    }

    @Override
    public List<TaskDto> getTask(List<String> tags) {
        return null;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return null;
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public void removeTask(Long id) {

    }

    @Override
    public TaskDto removeTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public Task parseDtoToDao(TaskDto geoPointDto) {
        return null;
    }

    @Override
    public TaskDto parseDaoToDto(Task geoPoint) {
        return null;
    }
}
