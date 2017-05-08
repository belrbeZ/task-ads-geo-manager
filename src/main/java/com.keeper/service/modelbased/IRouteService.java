package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IRouteService extends IModelDTOService<Route, RouteDTO> {
    Optional<List<Route>> getByUserId(Long userId);
}
