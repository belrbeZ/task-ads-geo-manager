package com.keeper.controllers.secure;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.service.impl.UserRepoService;
import com.keeper.util.PathNameResolver;
import com.keeper.util.ViewNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Control Web & Api OAUTH and Registration forms
 */
@Controller
public class OAuthWebController {

    private final UserRepoService userRepoService;

    @Autowired
    public OAuthWebController(UserRepoService userRepoService) {
        this.userRepoService = userRepoService;
    }

    @RequestMapping(value = PathNameResolver.WEB_REGISTER, method = RequestMethod.GET)
    public String registerPage(Model model) {


        return ViewNameResolver.WEB_REGISTER;
    }

}
