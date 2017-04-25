package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@Controller
public class TaskWebController {

    @RequestMapping(value = WebResolver.TASK, method = RequestMethod.GET)
    public ModelAndView taskGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK, method = RequestMethod.POST)
    public ModelAndView taskUpdate(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        return modelAndView;
    }
}
