package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.util.resolvers.WebMappingResolver;
import com.keeper.util.resolvers.ViewResolver;
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

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_PROFILE,
                    method = RequestMethod.GET)
    public String profilePage(Model model) {


        return ViewResolver.WEB_PROFILE;
    }

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_PROFILE,
                    method = RequestMethod.POST)
    public String profilePageUpdate(@PathVariable String name,
                                    @PathVariable String email,
                                    @PathVariable String phone,
                                    @PathVariable String password,
                                    @PathVariable String repassword,
                                    Model model) {

        return ViewResolver.WEB_PROFILE;
    }
}
