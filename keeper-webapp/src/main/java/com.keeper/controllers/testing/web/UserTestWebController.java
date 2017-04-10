package com.keeper.controllers.testing.web;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.service.testing.UserTestRepoService;
import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Used to TEST_REST_PROFILE UserZone model
 */
@Controller
public class UserTestWebController {

    @Autowired
    private UserTestRepoService repoService;

    @RequestMapping(value = WebmapResolver.TEST_USER, method = RequestMethod.GET)
    public ModelAndView userTestGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.TEST_PAGE_USER);
        modelAndView.addObject("users", repoService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.TEST_USER, method = RequestMethod.POST)
    public ModelAndView userTestPost(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.TEST_PAGE_USER);

        return modelAndView;
    }
}
