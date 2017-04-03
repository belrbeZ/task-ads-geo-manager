package com.keeper.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.GeoPoint;
import com.keeper.entity.Location;
import com.keeper.entity.Route;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA Repository for Locations
 */

@Repository
@Qualifier(value = "locationRepository")
public interface LocationRepository extends JpaRepository<Location, Long > {//, QueryDslPredicateExecutor<Location>

    List<Location> findAllByUserId(@Param("ownerId") Long ownerId);

    Location deleteByUserId(@Param("ownerId") Long ownerId);


//<editor-fold desc="LocationCRUD">

    List<Location> createLocation(Long userId, Location location);

    List<Location> readLocation(List<Long> userId);

    List<Location> updateLocation(Long userId, Location location);

    List<Location> deleteLocation(List<Long> userId) ;


    //</editor-fold>

    //<editor-fold desc="CoordinatesCRUD">

    List<GeoPoint> createCoordinates(Long userId, List<GeoPoint> geoPoints);

    List<GeoPoint> readCoordinates(Long userId, List<Long> coordinateIds);

    List<GeoPoint> updateCoordinates(Long userId, List<GeoPoint> geoPoints);

    List<GeoPoint> deleteCoordinates(Long userId, List<Long> coordinateIds);
    //</editor-fold>

    //<editor-fold desc="RoutesCRUD">

    List<Route> createRoutes(Long userId, List<Route> routes);

    List<Route> readRoutes(Long userId, List<Long> routeIds);

    List<Route> updateRoute(Long userId, List<Long> routeIds);

    List<Route> deleteRoutes(Long userId, List<Long> routeIds);


}
