package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 28.03.2017.
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
public class ProfileWebController {

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.GET)
    public ModelAndView profileGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.PROFILE);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.POST)
    public ModelAndView profileUpdate(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.PROFILE);

        return modelAndView;
    }
}
