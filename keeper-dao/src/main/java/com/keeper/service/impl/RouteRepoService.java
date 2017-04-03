package com.keeper.service.impl;

import com.keeper.repo.RouteRepository;
import com.keeper.service.contracts.IRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by AlexVasil on 29.03.2017.
 *
 * @author AlexVasil
 *
 */
@Service(value = "routeService")
public class RouteRepoService implements IRouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @Resource
//    @Autowired
//    @Qualifier(value = "routeRepository")
    private RouteRepository routeRepo;

}
