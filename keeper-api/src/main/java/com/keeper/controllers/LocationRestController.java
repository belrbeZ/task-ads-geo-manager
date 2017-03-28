package com.keeper.controllers;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.PathNameResolver;
import org.springframework.stereotype.Controller;

/**
 * Control Location Rest End points
 */
@Controller
public class LocationRestController {

    private final String restPath = PathNameResolver.API + PathNameResolver.REST_LOCATION;

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
