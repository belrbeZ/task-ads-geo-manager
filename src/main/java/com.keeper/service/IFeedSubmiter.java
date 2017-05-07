package com.keeper.service;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;

import java.util.List;

/**
 * Default Comment
 */
public interface IFeedSubmiter {
    void submit(Task task);
    void submit(GeoPoint point);
    void submit(Route route);

    void loadTasks(List<Task> task);
    void loadPoints(List<GeoPoint> point);
    void loadRoutes(List<Route> route);

    void remove(Task task);
    void remove(GeoPoint point);
    void remove(Route route);
}
