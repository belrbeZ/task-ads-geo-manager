package com.keeper.controllers;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.PathResolver;
import org.springframework.stereotype.Controller;

/**
 * Control Location Rest End points
 */
@Controller
public class LocationRestController {

    private final String restPath = PathResolver.API + PathResolver.REST_LOCATION;

    public String getLocation() {

        return null;
    }

    public String postLocation() {

        return null;
    }

    public String patchLocation() {

        return null;
    }

    public String deleteLocation() {

        return null;
    }

}
