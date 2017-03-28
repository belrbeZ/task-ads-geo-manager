package com.keeper.controllers;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.ApiResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Control Tasks Rest End points
 */
@RestController
public class TaskRestController {

    private final String restEndpoint = ApiResolver.API + ApiResolver.REST_LOCATION;
    private final String restProduces = ApiResolver.PRODUCES_APP_JSON + ApiResolver.PRODUCES_CHARSET;

    @RequestMapping(value = restEndpoint,
                    method = RequestMethod.GET,
                    produces = restProduces)
    public String get(Model model) {

        return null;
    }

    @RequestMapping(value = restEndpoint,
                    method = RequestMethod.POST,
                    produces = restProduces)
    public String postTask(Model model) {

        return null;
    }

    @RequestMapping(value = restEndpoint,
                    method = RequestMethod.PATCH,
                    produces = restProduces)
    public String patch(Model model) {

        return null;
    }

    @RequestMapping(value = restEndpoint,
                    method = RequestMethod.DELETE,
                    produces = restProduces)
    public String delete(Model model) {

        return null;
    }
}
