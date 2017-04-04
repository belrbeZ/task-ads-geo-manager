package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.util.resolvers.ViewResolver;
import com.keeper.util.resolvers.WebMappingResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Used for Testing and Debugging
 */
@Controller
public class TestingWebController {

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_PROFILE,
            method = RequestMethod.GET)
    public String testPage(Model model) {


        return ViewResolver.TEST_USERLIST;
    }

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_PROFILE,
            method = RequestMethod.POST)
    public String fillTestPage( @PathVariable String name,
                                @PathVariable String email,
                                @PathVariable String phone,
                                @PathVariable String password,
                                Model model) {


        return ViewResolver.TEST_USERLIST;
    }
}
