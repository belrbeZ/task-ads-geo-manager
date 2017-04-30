package com.keeper.controllers.web;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by AlexVasil on 28.04.2017.
 *
 * @author AlexVasil
 */
@Controller
public class CssController {

    @RequestMapping(value = "main.css", method = RequestMethod.GET)
    public String main(Model model, HttpServletResponse response) {
        model.addAttribute("backgroundColor", "lightblue");
        return "main.css";
    }
}