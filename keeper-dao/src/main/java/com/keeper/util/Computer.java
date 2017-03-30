package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.entity.GeoPoint;
import com.keeper.entity.Mark;
import com.keeper.entity.Route;

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

    public static Mark computeCoordinateMark(List<GeoPoint> coords) {

        return emptyMark;
    }
    //</editor-fold>

}
