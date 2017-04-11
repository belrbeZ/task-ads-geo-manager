package com.keeper.controllers.testing.web;

/*
 * Created by @GoodforGod on 10.04.2017.
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Used to TEST_REST_PROFILE ZoneTest model
 */
@Controller
public class ZoneTestWebController {

    @RequestMapping(value = WebmapResolver.TEST_ZONE, method = RequestMethod.GET)
    public ModelAndView zoneTestGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.TEST_PAGE_ZONE);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.TEST_ZONE, method = RequestMethod.POST)
    public ModelAndView zoneTestPost(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.TEST_PAGE_ZONE);

        return modelAndView;
    }
}
