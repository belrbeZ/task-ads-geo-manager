package com.keeper.service;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;

import java.util.List;

/**
 * Default Comment
 */
public interface IRouteService {
    List<Route> getAllByUserId(Long userId);
}
