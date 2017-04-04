package com.keeper.managers.impl;

import com.keeper.dto.TaskDto;
import com.keeper.dto.UserDto;
import com.keeper.entity.Task;
import com.keeper.entity.User;
import com.keeper.managers.ITaskDtoManager;
import com.keeper.service.impl.TaskRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class TaskDtoDaoManager implements ITaskDtoManager<Task> {

    @Autowired
    private TaskRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public Task parseDtoToDao(TaskDto dtoMode) {
        return null;
    }

    @Override
    public TaskDto parseDaoToDto(Task daoModel) {
        return null;
    }

    @Override
    public List<Task> parseDtoToDao(List<TaskDto> dtoModelList) {
        return null;
    }

    @Override
    public List<TaskDto> parseDaoToDto(List<Task> daoModelList) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Operations">

    @Override
    public Task addTask(Task task) {
        return null;
    }


    @Override
    public Task getTask(Long id) {
        return null;
    }

    @Override
    public List<Task> getTask(User user) {
        return null;
    }


    @Override
    public List<Task> getTask(String theme) {
        return null;
    }

    @Override
    public List<Task> getTask(Set<String> tags) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public void removeTask(Long id) {

    }

    @Override
    public Task removeTask(Task task) {
        return null;
    }
    //</editor-fold>
}
