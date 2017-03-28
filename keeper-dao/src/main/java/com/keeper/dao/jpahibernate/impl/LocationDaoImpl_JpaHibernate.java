package com.keeper.dao.jpahibernate.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 * Updated by AlexVasil on 28.03.2017.
 *
 */

import com.keeper.dao.jpahibernate.LocationDao;
import com.keeper.entity.GeoPoint;
import com.keeper.entity.Location;
import com.keeper.entity.Route;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by AlexVasil on 26.03.2017.
 *
 */
@Repository
public class LocationDaoImpl_JpaHibernate extends GenericDaoImpl_JpaHibernate<Location, Long> implements LocationDao {


//    @SuppressWarnings("unchecked")
    public List<Location> findAll() {
        // Note, this query is also possible with Spring Data JPAs "Derived Query" technique, which magically implements
        // interface methods based on the name.
        return entityManager.createQuery("SELECT item FROM Locations item",
                Location.class)
                .getResultList();
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

    public List<GeoPoint> createCoordinates(Long userId, List<GeoPoint> geoPoints) {

        return null;
    }

    public List<GeoPoint> readCoordinates(Long userId, List<Long> coordinateIds) {

        return null;
    }

    public List<GeoPoint> updateCoordinates(Long userId, List<GeoPoint> geoPoints) {

        return null;
    }

    public List<GeoPoint> deleteCoordinates(Long userId, List<Long> coordinateIds) {

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
