package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.dao.hibernate.impl.TaskDaoHibernate;
import com.keeper.dao.hibernate.TaskDao;
import com.keeper.entity.Task;
import com.keeper.service.ITaskService;
import org.springframework.stereotype.Repository;

import static com.keeper.util.CollectorResolver.makeTaskList;
import static com.keeper.util.CollectorResolver.makeIdList;

import static com.keeper.util.CollectorResolver.getFirstTask;

/**
 * Repository to work with Tasks
 */
@Repository
public class TaskService implements ITaskService {

    private TaskDaoHibernate taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = (TaskDaoHibernate) taskDao;
    }

    public TaskDaoHibernate getTaskDao() {
        return taskDao;
    }

    //<editor-fold desc="TaskCRUD">

    public Task addTask(Task task) {
        return getFirstTask(taskDao.createTask(makeTaskList(task)));
    }

    public Task getTask(Integer id) {
        return getFirstTask(taskDao.readTask(makeIdList(id)));
    }

    public Task updateTask(Task task) {
        return getFirstTask(taskDao.updateTask(makeTaskList(task)));
    }

    public Task removeTask(Integer id) {
        return getFirstTask(taskDao.deleteTask(makeIdList(id)));
    }
    //</editor-fold>

}
