package com.keeper.repo;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.dao.TaskDaoHibernate;
import com.keeper.entity.Task;

import static com.keeper.util.CollectorResolver.makeTaskList;
import static com.keeper.util.CollectorResolver.makeIdList;

import static com.keeper.util.CollectorResolver.getFirstTask;

/**
 * Repository to work with Tasks
 */
public class TaskRepository {

    private TaskDaoHibernate taskDao;

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
