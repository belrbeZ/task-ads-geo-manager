package com.keeper.dao.hibernate.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.hibernate.TaskDao;
import com.keeper.entity.Task;

import java.util.List;

/**
 * Default Comment
 */
public class TaskDaoHibernate extends GenericDaoHibernate<Task, Long> implements TaskDao {


    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        // Note, this query is also possible with Spring Data JPAs "Derived Query" technique, which magically implements
        // interface methods based on the name.
        return getSession().createQuery("select t from Tasks t").list();
    }

    //<editor-fold desc="TaskCRUD">

    public List<Task> createTask(List<Task> tasks) {

        return null;
    }

    public List<Task> readTask(List<Long> ids) {

        return null;
    }


    public List<Task> updateTask(List<Task> tasks) {

        return null;
    }

    public List<Task> deleteTask(List<Long> ids) {

        return null;
    }
    //</editor-fold>

}
