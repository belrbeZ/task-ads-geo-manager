package com.keeper.managers.impl;

import com.keeper.dto.RouteDto;
import com.keeper.entity.Route;
import com.keeper.managers.IRouteDtoManager;
import com.keeper.service.impl.RouteRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class RouteDtoDaoManager implements IRouteDtoManager<Route> {

    @Autowired
    private RouteRepoService repoService;

    //<editor-fold desc="Dao&Dto">

        @Override
        public Route parseDtoToDao(RouteDto dtoMode) {
        return null;
        }

        @Override
        public RouteDto parseDaoToDto(Route daoModel) {
        return null;
        }


        @Override
        public List<Route> parseDtoToDao(List<RouteDto> dtoModelList) {
        return null;
        }
        //</editor-fold>

    //<editor-fold desc="Operations">

        @Override
        public List<Route> addRoutes(Long ownerId, List<Route> routes) {
        return null;
        }

        @Override
        public List<Route> getRoutes(Long ownerId, List<Long> routeIds) {
        return null;
        }

        @Override
        public List<RouteDto> parseDaoToDto(List<Route> daoModelList) {
        return null;
        }

        @Override
        public List<Route> getAllRoutes() {
        return null;
        }

        @Override
        public List<Route> updateRoute(Long ownerId, List<Long> routeIds) {
        return null;
        }

        @Override
        public void removeRoutes(Long ownerId, List<Long> routeIds) {

        }
        //</editor-fold>
}
