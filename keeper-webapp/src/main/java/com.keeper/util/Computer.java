package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.Mark;
import com.keeper.model.dao.Route;

import java.util.List;

/**
 * Computes Marks for Hot Coords and Routes
 */
public class Computer {

    //<editor-fold desc="HotMark">

    public static final Mark emptyMark = Mark.empty;

    public static Mark computeRouteMark(List<Route> routes) {

        return emptyMark;
    }

    public static Mark computeGeoPointMark(List<GeoPoint> points) {

        return emptyMark;
    }
    //</editor-fold>

}
