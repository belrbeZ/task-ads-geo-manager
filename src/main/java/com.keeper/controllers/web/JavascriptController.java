package com.keeper.controllers.web;

import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by AlexVasil on 28.04.2017.
 *
 * @author AlexVasil
 */

@Controller
public class JavascriptController {

    @RequestMapping(value = WebResolver.SECURED+"/js/ymaps.js", method = RequestMethod.GET)
    public String common(Model model, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAP);

        model.addAttribute("code", "Thymeleaf rules!".hashCode());
        return "ymaps.js";
    }
}