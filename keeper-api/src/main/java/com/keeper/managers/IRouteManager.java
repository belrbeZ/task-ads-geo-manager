package com.keeper.managers;

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public interface IRouteManager extends IModelManager<Route, RouteDTO> {
    List<RouteDTO> addRoutes(Long ownerId, List<RouteDTO> routes);

    List<RouteDTO> getRoutes(Long ownerId, List<Long> routeIds);

    List<RouteDTO> getAllRoutes();

    List<RouteDTO> updateRoute(Long ownerId, List<Long> routeIds);

    void removeRoutes(Long ownerId, List<Long> routeIds);
}
