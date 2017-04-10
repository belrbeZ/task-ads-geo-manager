package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@Controller
public class CommonWebController {

    @RequestMapping(value = WebmapResolver.WEB_PROFILE, method = RequestMethod.GET)
    public ModelAndView errorGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.WEB_ERROR);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_PROFILE, method = RequestMethod.GET)
    public ModelAndView deniedGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.WEB_DENIED);

        return modelAndView;
    }
}
