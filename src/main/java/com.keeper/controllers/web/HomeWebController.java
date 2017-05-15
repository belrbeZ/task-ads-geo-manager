package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.resolvers.TemplateResolver;
import com.keeper.util.resolvers.WebResolver;
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

    @RequestMapping(value = WebResolver.HOME, method = RequestMethod.GET)
    public ModelAndView homeGet(Model model) {
        return new ModelAndView(TemplateResolver.HOME);
    }
}
