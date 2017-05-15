package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.UserDTO;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.TemplateResolver;
import com.keeper.util.resolvers.WebResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Default Comment
 */
@Controller
public class ProfileWebController {

    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(ProfileWebController.class);

    @Autowired
    public ProfileWebController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.GET)
    public ModelAndView profileGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.PROFILE);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            UserDTO userDTO = ModelTranslator.toDTO(user.get());
            userDTO.setEmail(user.get().getEmail());
            modelAndView.addObject("user", userDTO);
        }
        else
            modelAndView.setViewName(TemplateResolver.redirect(TemplateResolver.HOME));

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.POST)
    public ModelAndView profileUpdate(@Valid UserDTO model, BindingResult bindingResult) {
        userService.updateDTO(model);
        return new ModelAndView(TemplateResolver.redirect(TemplateResolver.PROFILE));
    }
}
