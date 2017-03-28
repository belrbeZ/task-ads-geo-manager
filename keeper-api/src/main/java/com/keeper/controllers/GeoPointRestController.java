package com.keeper.controllers;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.entity.Location;
import com.keeper.util.ApiResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default Comment
 */
@RestController
public class GeoPointRestController {

    private final String restPath = ApiResolver.API + ApiResolver.REST_LOCATION;

    @RequestMapping(value = restPath,
                    method = RequestMethod.GET,
                    produces = ApiResolver.PRODUCER_JSON)
    public Location get(Model model) {

        return null;
    }

    @RequestMapping(value = restPath,
                    method = RequestMethod.GET,
                    produces = ApiResolver.PRODUCER_JSON)
    public Location post(Model model) {

        return null;
    }

    @RequestMapping(value = restPath,
                    method = RequestMethod.GET,
                    produces = ApiResolver.PRODUCER_JSON)
    public Location patch(Model model) {

        return null;
    }

    @RequestMapping(value = restPath,
                    method = RequestMethod.GET,
                    produces = ApiResolver.PRODUCER_JSON)
    public Location delete(Model model) {

        return null;
    }
}
