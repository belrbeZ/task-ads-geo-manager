package com.keeper.managers.impl;

import com.keeper.entity.dto.RouteDTO;
import com.keeper.entity.Route;
import com.keeper.managers.IRouteManager;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

//@Service
public class RouteManager implements IRouteManager<Route> {

//    @Autowired
//    private RouteRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public Route parseDtoToDao(RouteDTO dtoMode) {
                                               return null;
                                                           }

    @Override
    public RouteDTO parseDaoToDto(Route daoModel) {
                                                return null;
                                                            }

    @Override
    public List<RouteDTO> parseDaoToDto(List<Route> daoModelList) {
        return null;
    }

    @Override
    public List<Route> parseDtoToDao(List<RouteDTO> dtoModelList) {
                                                                return null;
                                                                                            }
    //</editor-fold>

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
