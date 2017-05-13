package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.model.dto.UserFormDTO;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.TemplateResolver;
import com.keeper.util.resolvers.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Control Web & Api OAUTH and Registration forms
 */
@Controller
public class SecureWebController {

    private final UserService userService;

    @Autowired
    public SecureWebController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.LOGIN, method = RequestMethod.GET)
    public ModelAndView loginGet(){
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.LOGIN);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.LOGOUT, method = RequestMethod.GET)
    public ModelAndView logoutGet (HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.redirect(TemplateResolver.LOGIN + "?logout=true"));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null)
            new SecurityContextLogoutHandler().logout(request, response, auth);

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
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.LOGIN);

        if(userService.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email",
                    "error.user",
                    "There is already a user registered with the email provided");
            modelAndView.setViewName(TemplateResolver.REGISTER);
        }

        if (!bindingResult.hasErrors()) {
            userService.save(ModelTranslator.toDAO(user));
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserFormDTO());
        }

        return modelAndView;
    }
}
