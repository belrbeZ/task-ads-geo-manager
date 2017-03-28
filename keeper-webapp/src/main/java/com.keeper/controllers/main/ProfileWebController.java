package com.keeper.controllers.main;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.entity.User;
import com.keeper.util.PathResolver;
import com.keeper.util.ViewResolver;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class ProfileWebController {

    @RequestMapping(value = PathResolver.WEB_PAGE_PROFILE,
                    method = RequestMethod.GET)
    public String profilePage(Model model) {


        return ViewResolver.WEB_PROFILE;
    }

    @RequestMapping(value = PathResolver.WEB_PAGE_PROFILE,
                    method = RequestMethod.POST)
    public String profilePageUpdate(@PathVariable User user,
                                    Model model) {

        return ViewResolver.WEB_PROFILE;
    }
}
