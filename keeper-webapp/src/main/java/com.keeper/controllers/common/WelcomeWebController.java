package com.keeper.controllers.common;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.WebappResolver;
import com.keeper.util.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class WelcomeWebController {

    @RequestMapping(value = WebappResolver.WEB_PAGE_WELCOME,
                    method = RequestMethod.GET)
    public String welcomePage(Model model) {


        return ViewResolver.WEB_WELCOME;
    }
}
