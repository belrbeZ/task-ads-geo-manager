package com.keeper.controllers;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.Location;
import com.keeper.util.PathResolver;
import com.keeper.util.ViewResolver;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Control Location Rest End points
 */
@RestController
public class LocationRestController {

    private final String restPath = PathResolver.API + PathResolver.REST_LOCATION;

    @RequestMapping(value = PathResolver.API + PathResolver.REST_LOCATION,
                    method = RequestMethod.GET)
    public Location getLocations(Model model) {


        return null;
    }

    @RequestMapping(value = PathResolver.API + PathResolver.REST_LOCATION,
            method = RequestMethod.GET)
    public Location postLocation(Model model) {

        return null;
    }

    @RequestMapping(value = PathResolver.API + PathResolver.REST_LOCATION,
            method = RequestMethod.GET)
    public Location patchLocation(Model model) {

        return null;
    }

    @RequestMapping(value = PathResolver.API + PathResolver.REST_LOCATION,
            method = RequestMethod.GET)
    public Location deleteLocation(Model model) {

        return null;
    }

}
