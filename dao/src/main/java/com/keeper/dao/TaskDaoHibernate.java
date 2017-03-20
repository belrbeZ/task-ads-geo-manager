package com.keeper.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Comment
 */
public class TaskDaoHibernate {

    public static final List<Task> emptyTaskList = new ArrayList<Task>();

    //<editor-fold desc="TaskCRUD">

    public List<Task> createTask(Task task) {

        return emptyTaskList;
    }

    public List<Task> getTask(List<Integer> id) {

        return emptyTaskList;
    }

    public List<Task> removeTask(Integer id) {

        return emptyTaskList;
    }

    public List<Task> updateTask(Task task) {

        return emptyTaskList;
    }
    //</editor-fold>

}
