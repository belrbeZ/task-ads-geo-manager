package com.keeper.managers.impl;

import com.keeper.dto.RouteDto;
import com.keeper.entity.Route;
import com.keeper.managers.contracts.IRouteDtoManager;
import org.springframework.stereotype.Service;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class RouteDtoDaoManager implements IRouteDtoManager<Route> {

    @Override
    public Route parseDtoToDao(RouteDto geoPointDto) {
        return null;
    }

    @Override
    public RouteDto parseDaoToDto(Route geoPoint) {
        return null;
    }
}
