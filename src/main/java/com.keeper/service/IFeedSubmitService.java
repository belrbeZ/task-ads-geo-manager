package com.keeper.service;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;

/**
 * Default Comment
 */
public interface IFeedSubmitService {
    void submit(Task task);
    void submit(GeoPoint point);
    void submit(Route route);
}
