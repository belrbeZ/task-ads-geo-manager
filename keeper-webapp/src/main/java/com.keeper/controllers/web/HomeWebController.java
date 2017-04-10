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
 * Controller to proceed all requests from home page
 */
@Controller
public class HomeWebController {

    @RequestMapping(value = WebmapResolver.WEB_HOME, method = RequestMethod.GET)
    public ModelAndView homeGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_HOME);

        return modelAndView;
    }
}
