package com.keeper.DaoHibernate;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.dao.GenericHibernateDAO;
import com.keeper.dao.TaskDAO;
import com.keeper.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Comment
 */
public class TaskDaoHibernate extends GenericHibernateDAO<Task, Integer> implements TaskDAO {


    //<editor-fold desc="TaskCRUD">

    public List<Task> createTask(List<Task> tasks) {

        return null;
    }

    public List<Task> readTask(List<Integer> ids) {

        return null;
    }


    public List<Task> updateTask(List<Task> tasks) {

        return null;
    }

    public List<Task> deleteTask(List<Integer> ids) {

        return null;
    }
    //</editor-fold>

}
