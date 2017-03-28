package com.keeper.dao.jpahibernate.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 * Updated by AlexVasil on 28.03.2017.
 *
 */

import com.keeper.dao.jpahibernate.TaskDao;
import com.keeper.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Default Comment
 */
@Repository
public class TaskDaoImpl_JpaHibernate extends GenericDaoImpl_JpaHibernate<Task, Long> implements TaskDao {

//    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        // Note, this query is also possible with Spring Data JPAs "Derived Query" technique, which magically implements
        // interface methods based on the name.
        return entityManager.createQuery("SELECT item FROM Tasks item",
                Task.class)
                .getResultList();
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
