package com.keeper.dao.hibernate.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.hibernate.LocationDao;
import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;


import java.util.List;

/**
 * Created by AlexVasil on 26.03.2017.
 *
 */

public class LocationDaoHibernate extends GenericDaoHibernate<Location, Long> implements LocationDao {


    @SuppressWarnings("unchecked")
    public List<Location> findAll() {
        // Note, this query is also possible with Spring Data JPAs "Derived Query" technique, which magically implements
        // interface methods based on the name.
        return getSession().createQuery("select l from Locations l").list();
    }

    //<editor-fold desc="LocationCRUD">

    public List<Location> createLocation(Long userId, Location location) {

        return null;
    }

    public List<Location> readLocation(List<Long> userId) {

        return null;
    }

    public List<Location> updateLocation(Long userId, Location location) {

        return null;
    }

    public List<Location> deleteLocation(List<Long> userId) {

        return null;
    }
    //</editor-fold>

    //<editor-fold desc="CoordinatesCRUD">

    public List<Coordinate> createCoordinates(Long userId, List<Coordinate> coordinates) {

        return null;
    }

    public List<Coordinate> readCoordinates(Long userId, List<Long> coordinateIds) {

        return null;
    }

    public List<Coordinate> updateCoordinates(Long userId, List<Coordinate> coordinates) {

        return null;
    }

    public List<Coordinate> deleteCoordinates(Long userId, List<Long> coordinateIds) {

        return null;
    }
    //</editor-fold>

    //<editor-fold desc="RoutesCRUD">

    public List<Route> createRoutes(Long userId, List<Route> routes) {

        return null;
    }

    public List<Route> readRoutes(Long userId, List<Long> routeIds) {

        return null;
    }

    public List<Route> updateRoute(Long userId, List<Long> routeIds) {

        return null;
    }

    public List<Route> deleteRoutes(Long userId, List<Long> routeIds) {

        return null;
    }
    //</editor-fold>

}
