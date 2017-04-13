package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@Controller
public class WelcomeWebController {

//    @RequestMapping("/index")
//    public String home(Model model) {
//        model.addAttribute("message", "HowToDoInJava Reader !!");
//        return "index";
//    }

    @RequestMapping(value = WebmapResolver.WEB_WELCOME,
                    method = RequestMethod.GET,
                    produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView welcomeGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_WELCOME);
        modelAndView.addObject("msg", "Message from Welcome Controller");
        return modelAndView;
    }
}
