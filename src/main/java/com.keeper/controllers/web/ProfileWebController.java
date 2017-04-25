package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.UserDTO;
import com.keeper.service.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Default Comment
 */
@Controller
public class ProfileWebController {

    private final UserService userService;

    @Autowired
    public ProfileWebController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.GET)
    public ModelAndView profileGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.PROFILE);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        modelAndView.addObject("user", Translator.convertToDTO(userService.getByEmail(auth.getName()).get()));

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.POST)
    public ModelAndView profileUpdate(@Valid @RequestBody UserDTO userForm, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.PROFILE);

        User user = userService.get(userForm.getId()).get();

        user.setEmail((userForm.getEmail() != null && !userForm.getEmail().isEmpty()) ? userForm.getEmail() : user.getEmail());
        user.setEmail((userForm.getPassword() != null && !userForm.getPassword().isEmpty()) ? userForm.getPassword() : user.getPassword());
        user.setEmail((userForm.getPhone() != null && !userForm.getPhone().isEmpty()) ? userForm.getPhone() : user.getPhone());
        user.setEmail((userForm.getAbout() != null && !userForm.getAbout().isEmpty()) ? userForm.getAbout() : user.getAbout());
        user.setEmail((userForm.getName() != null && !userForm.getName().isEmpty()) ? userForm.getName() : user.getName());
        user.setNotified((userForm.getNotified() == null) ? false : userForm.getNotified());

        userService.add(user);

        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
