package com.keeper.managers;

import com.keeper.entity.Route;
import com.keeper.entity.dto.RouteDTO;
import com.keeper.service.IRouteService;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public interface IRouteDtoManager extends IModelDtoManager<Route, RouteDTO> {
    List<RouteDTO> addRoutes(Long ownerId, List<RouteDTO> routes);

    List<RouteDTO> getRoutes(Long ownerId, List<Long> routeIds);

    List<RouteDTO> getAllRoutes();

    List<RouteDTO> updateRoute(Long ownerId, List<Long> routeIds);

    void removeRoutes(Long ownerId, List<Long> routeIds);
}
