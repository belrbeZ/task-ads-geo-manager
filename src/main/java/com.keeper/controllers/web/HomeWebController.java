package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to proceed all requests from home page
 */
@Controller
public class HomeWebController {

    private final GeoPointService geoPointService;
    private final UserService userService;

    @Autowired
    public HomeWebController(GeoPointService geoPointService, UserService userService) {
        this.geoPointService = geoPointService;
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.HOME, method = RequestMethod.GET)
    public ModelAndView homeGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.HOME);

        return modelAndView;
    }
}
