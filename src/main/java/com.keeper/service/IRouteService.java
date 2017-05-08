package com.keeper.service;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;

import java.util.List;

/**
 * Default Comment
 */
public interface IRouteService extends IModelDTOService<Route, RouteDTO> {
    List<Route> getByUserId(Long userId);
}
