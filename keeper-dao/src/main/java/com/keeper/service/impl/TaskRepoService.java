package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Task;
import com.keeper.entity.User;
import com.keeper.repo.TaskRepository;
import com.keeper.service.contracts.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Repository Service to work with Tasks
 */
@Service(value = "taskService")
public class TaskRepoService implements ITaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @Resource
//    @Autowired
//    @Qualifier(value = "taskRepository")
    private TaskRepository taskRepository;

    //<editor-fold desc="TaskCRUD">

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }


    public Task getTask(Long id) {
        return taskRepository.findOne(id);
    }

    public List<Task> getTasks(Long ownerId) {
        return taskRepository.findByTopicStarterId(ownerId);
    }

    public Task getTask(Task task) {
        return taskRepository.findOne(task.getId());
    }

    public List<Task> getTask(String theme) {
        return taskRepository.findAllByTheme(theme);
    }

    public List<Task> getTask(User user){
        return taskRepository.findAllByTopicStarterId(user.getId());
    }

    public List<Task> getTask(Set<String> tags) {
        return taskRepository.findAllByTags(tags);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void removeTask(Long id) {
        taskRepository.delete(id);
    }

    public Task removeTask(Task task) {
        Task tmp = taskRepository.findOne(task.getId());
        taskRepository.delete(task.getId());
        return tmp;
    }

    //</editor-fold>

}
