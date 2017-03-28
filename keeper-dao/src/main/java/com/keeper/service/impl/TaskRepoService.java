package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.jpahibernate.TaskDao;
import com.keeper.dao.jpahibernate.impl.TaskDaoImpl_JpaHibernate;
import com.keeper.dao.repo.TaskRepository;
import com.keeper.entity.Task;
import com.keeper.entity.User;
import com.keeper.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository Service to work with Tasks
 */
@Service("taskService")
public class TaskRepoService implements ITaskService {

    private final TaskDaoImpl_JpaHibernate taskDao;

    private final TaskRepository taskRepository;

    @Autowired
    public TaskRepoService(TaskDao taskDao, TaskRepository taskRepository) {
        this.taskDao = (TaskDaoImpl_JpaHibernate) taskDao;
        this.taskRepository = taskRepository;
    }

    //<editor-fold desc="TaskCRUD">

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }


    public Task getTask(Long id) {
        return taskRepository.findOne(id);
    }

    public List<Task> getTasks(Long ownerId) {
        return taskRepository.findByOwnerId(ownerId);
    }

    public Task getTask(Task task) {
        return taskRepository.findOne(task.getId());
    }

    public List<Task> getTask(String theme) {
        return taskRepository.findAllByTheme(theme);
    }

    public List<Task> getTask(User user){
        return taskRepository.findAllByUser(user);
    }

    public List<Task> getTask(List<String> tags) {
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
