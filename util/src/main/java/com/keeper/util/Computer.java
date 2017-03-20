package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.entity.Coordinate;
import com.keeper.entity.Route;

import java.util.List;

/**
 * Computes Marks for Hot Coords and Routes
 */
public class Computer {

    public static final Double emptyMark = -1.;

    public static Double computeRouteMark(List<Route> routes) {

        return emptyMark;
    }

    public static Double computeCoordinateMark(List<Coordinate> coords) {

        return emptyMark;
    }

}
