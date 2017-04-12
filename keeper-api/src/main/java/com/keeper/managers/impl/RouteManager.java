package com.keeper.managers.impl;

import com.keeper.model.dto.RouteDTO;
import com.keeper.managers.IRouteManager;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

//@Service
public class RouteManager implements IRouteManager {

//    @Autowired
//    private RouteRepoService repoService;

    //<editor-fold desc="Operations">

    @Override
    public List<RouteDTO> addRoutes(Long ownerId, List<RouteDTO> routes) {
        return null;
    }

    @Override
    public List<RouteDTO> getRoutes(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public List<RouteDTO> getAllRoutes() {
        return null;
    }

    @Override
    public List<RouteDTO> updateRoute(Long ownerId, List<Long> routeIds) {
        return null;
    }

    @Override
    public void removeRoutes(Long ownerId, List<Long> routeIds) {

    }
    //</editor-fold>
}
