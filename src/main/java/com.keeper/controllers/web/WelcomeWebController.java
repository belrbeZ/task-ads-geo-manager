package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
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
public class WelcomeWebController {

    @RequestMapping(value = { "/", WebResolver.WELCOME}, method = RequestMethod.GET)
    public ModelAndView welcomeGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.WELCOME);

        return modelAndView;
    }
}
