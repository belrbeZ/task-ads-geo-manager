package com.keeper.controllers.testing.web;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Used to TEST_REST_PROFILE UserZone model
 */
@Controller
public class UserTestWebController {

    @RequestMapping(value = WebmapResolver.WEB_PROFILE, method = RequestMethod.GET)
    public ModelAndView userTestGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.TEST_WEB_USER);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_PROFILE, method = RequestMethod.POST)
    public ModelAndView userTestPost(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.TEST_WEB_USER);

        return modelAndView;
    }
}
