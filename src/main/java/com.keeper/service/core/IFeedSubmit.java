package com.keeper.service.core;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;

import java.util.List;

/**
 * !!! Private Contracts !!!
 * !!! Used Only In Util Purposes In Model Service Classes !!!
 */
public interface IFeedSubmit {
    Task    submit(Task task);
    Route   submit(Route route);
    GeoPoint submit(GeoPoint point);

    void loadTasks(List<Task> task);
    void loadPoints(List<GeoPoint> point);
    void loadRoutes(List<Route> route);

    void removeTask(Long taskId);
    void removeGeo(Long geoId);
    void removeRoute(Long routeId);
}
