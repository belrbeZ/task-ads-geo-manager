package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.web.ApiResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Control Profile Rest End points
 */
//@Controller
public class ProfileRestController {

    private final String restEndpoint = ApiResolver.API + ApiResolver.REST_PROFILE;
    private final String restProduces = ApiResolver.PRODUCES_APP_JSON + ApiResolver.PRODUCES_CHARSET;

    @RequestMapping(value = restEndpoint,
                    method = RequestMethod.GET,
                    produces = restProduces)
    public String get(Model model) {

        return null;
    }

    @RequestMapping(value = restEndpoint,
                    method = RequestMethod.PATCH,
                    produces = restProduces)
    public String patch(Model model) {

        return null;
    }

}
