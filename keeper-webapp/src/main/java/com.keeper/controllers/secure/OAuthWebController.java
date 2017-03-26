package com.keeper.controllers.secure;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.PathManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@Controller
public class OAuthWebController {

    // Model vs ModelAndView READ!
    @RequestMapping(value = PathManager.WEB_REGISTER, method = RequestMethod.GET)
    public ModelAndView registerPage() {

        return new ModelAndView("Hi");
    }

}
