package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.model.dto.UserFormDTO;
import com.keeper.service.impl.UserRepoService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Control Web & Api OAUTH and Registration forms
 */
@Controller
public class SecureWebController {

    private final UserRepoService userService;

    @Autowired
    public SecureWebController(UserRepoService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.LOGIN, method = RequestMethod.GET)
    public ModelAndView loginGet(){
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.LOGIN);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.REGISTER, method = RequestMethod.GET)
    public ModelAndView registrationGet(){
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.REGISTER);

        modelAndView.addObject("user", new UserFormDTO());
        return modelAndView;
    }

    @RequestMapping(value = WebResolver.REGISTER, method = RequestMethod.POST)
    public ModelAndView registrationPost(@Valid UserFormDTO user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.REGISTER);

        if(userService.isExistsByEmail(user.getEmail()))
            bindingResult.rejectValue("email",
                    "error.user",
                    "There is already a user registered with the email provided");

        if (!bindingResult.hasErrors()) {
            userService.add(Translator.convertToDAO(user));
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserFormDTO());
        }

        return modelAndView;
    }
}
