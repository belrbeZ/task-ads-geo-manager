package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.entity.dto.GeoPointDTO;
import com.keeper.entity.dto.MarkDTO;
import com.keeper.entity.dto.RouteDTO;

import java.util.List;

/**
 * Computes Marks for Hot Coords and Routes
 */
public class Computer {

    //<editor-fold desc="HotMark">

    public static final MarkDTO emptyMark = MarkDTO.empty;

    public static MarkDTO computeRouteMark(List<RouteDTO> routes) {

        return emptyMark;
    }

    public static MarkDTO computeCoordinateMark(List<GeoPointDTO> coords) {

        return emptyMark;
    }
    //</editor-fold>
}
