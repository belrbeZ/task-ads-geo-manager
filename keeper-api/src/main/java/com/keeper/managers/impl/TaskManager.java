package com.keeper.managers.impl;

import com.keeper.entity.dao.Task;
import com.keeper.entity.dao.User;
import com.keeper.entity.dto.TaskDTO;
import com.keeper.managers.ITaskManager;

import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

//@Service
public class TaskManager implements ITaskManager<Task> {

//    @Autowired
//    private TaskRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public TaskDTO addTask(Task TaskDTO) {
        return null;
    }

    @Override
    public TaskDTO getTask(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> getTask(User user) {
        return null;
    }

    @Override
    public List<TaskDTO> getTask(String theme) {
        return null;
    }

    @Override
    public List<TaskDTO> getTask(Set<String> tags) {
        return null;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return null;
    }

    @Override
    public TaskDTO updateTask(TaskDTO task) {
        return null;
    }

    @Override
    public void removeTask(Long id) {

    }

    @Override
    public TaskDTO removeTask(TaskDTO task) {
        return null;
    }


    //</editor-fold>
}
