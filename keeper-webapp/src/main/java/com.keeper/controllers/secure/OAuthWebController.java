package com.keeper.controllers.secure;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.service.impl.UserRepoService;
import com.keeper.util.resolvers.WebMappingResolver;
import com.keeper.util.resolvers.ViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Control Web & Api OAUTH and Registration forms
 */
@Controller
public class OAuthWebController {

    @Autowired
    private UserRepoService userRepoService;

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_REGISTER, method = RequestMethod.GET)
    public String registerPage(Model model) {


        return ViewResolver.WEB_REGISTER;
    }

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_REGISTER,
                    method = RequestMethod.POST)
    public String registerPost(Model model) {


        return ViewResolver.WEB_REGISTER;
    }

    @RequestMapping(value = WebMappingResolver.WEB_OAUTH,
                    method = RequestMethod.GET)
    public String oauthPage(Model model) {


        return ViewResolver.WEB_OAUTH;
    }

    @RequestMapping(value = WebMappingResolver.WEB_OAUTH,
                    method = RequestMethod.POST)
    public String oauthPost(Model model) {


        return ViewResolver.WEB_OAUTH;
    }

    @RequestMapping(value = WebMappingResolver.WEB_OAUTH + WebMappingResolver.WEB_TOKEN,
                    method = RequestMethod.GET)
    public String oauthToken(Model model) {


        return ViewResolver.WEB_OAUTH;
    }
}
