package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Control Web & Api OAUTH and Registration forms
 */
@Controller
public class SecureWebController {

    @RequestMapping(value = WebmapResolver.WEB_REGISTER, method = RequestMethod.GET)
    public ModelAndView registerGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_REGISTER);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_REGISTER, method = RequestMethod.POST)
    public ModelAndView registerPost(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_REGISTER);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_LOGIN, method = RequestMethod.GET)
    public ModelAndView loginGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_LOGIN);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_LOGIN, method = RequestMethod.POST)
    public ModelAndView loginPost(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_LOGIN);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_LOGOUT, method = RequestMethod.POST)
    public ModelAndView logoutGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_LOGIN);

        return modelAndView;
    }
}
