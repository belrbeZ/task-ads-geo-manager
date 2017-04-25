package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
public class MapsWebController {

    @RequestMapping(value = WebResolver.MAPS, method = RequestMethod.GET)
    public ModelAndView mapGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAPS);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.MAPS, method = RequestMethod.POST)
    public ModelAndView mapUpdate(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAPS);

        return modelAndView;
    }
}
