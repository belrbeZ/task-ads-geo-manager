package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.hibernate.TaskDao;
import com.keeper.dao.hibernate.impl.TaskDaoHibernate;
import com.keeper.dao.springrepo.TaskRepository;
import com.keeper.entity.Task;
import com.keeper.service.ITaskService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.keeper.util.CollectorResolver.*;

/**
 * Repository to work with Tasks
 */
@Repository
@Service("taskService")
@Transactional
public class TaskService implements ITaskService {

//    @Autowired
    private TaskDaoHibernate taskDao;

//    @Autowired
    private TaskRepository taskRepository;


    public TaskService(TaskDao taskDao) {
        this.taskDao = (TaskDaoHibernate) taskDao;
    }

    //<editor-fold desc="TaskCRUD">

    public Task addTask(Task task) {
        return getFirstTask(taskDao.createTask(makeTaskList(task)));
    }

    public Task getTask(Long id) {
        return getFirstTask(taskDao.readTask(makeIdList(id)));
    }

    public Task updateTask(Task task) {
        return getFirstTask(taskDao.updateTask(makeTaskList(task)));
    }

    public Task removeTask(Long id) {
        return getFirstTask(taskDao.deleteTask(makeIdList(id)));
    }
    //</editor-fold>

}
