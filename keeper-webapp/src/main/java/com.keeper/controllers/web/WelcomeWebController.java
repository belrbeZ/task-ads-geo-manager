package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.resolvers.WebMappingResolver;
import com.keeper.util.resolvers.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class WelcomeWebController {

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_WELCOME,
                    method = RequestMethod.GET)
    public String welcomePage(Model model) {


        return ViewResolver.WEB_WELCOME;
    }
}
