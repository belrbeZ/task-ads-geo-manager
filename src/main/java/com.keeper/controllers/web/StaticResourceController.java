package com.keeper.controllers.web;

import com.keeper.util.resolve.WebResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by AlexVasil on 28.04.2017.
 *
 * @author AlexVasil
 */
@Controller
public class StaticResourceController {

    @RequestMapping(value = "main.css", method = RequestMethod.GET)
    public String main(Model model, HttpServletResponse response) {
        model.addAttribute("backgroundColor", "lightblue");
        return "main.css";
    }

    @RequestMapping(value = WebResolver.SECURED + "/js/ymaps.js", method = RequestMethod.GET)
    public String common(Model model, HttpServletResponse response) {
        model.addAttribute("code", "Thymeleaf rules!".hashCode());
        return "ymaps.js";
    }
}