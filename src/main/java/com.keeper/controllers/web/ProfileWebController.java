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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

        User user = userService.getAuthorized().get();
        UserDTO userDTO = Translator.toDTO(user);

        userDTO.setEmail(user.getEmail());

        modelAndView.addObject("user", userDTO);

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.PROFILE, method = RequestMethod.POST)
    public ModelAndView profileUpdate(@Valid UserDTO userForm, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.PROFILE);

        User user = userService.get(userForm.getId()).get();

        user.setEmail((userForm.getEmail() != null && !userForm.getEmail().isEmpty()) ? userForm.getEmail() : user.getEmail());
        user.setPassword((userForm.getPassword() != null && !userForm.getPassword().isEmpty()) ? userForm.getPassword() : user.getPassword());
        user.setPhone((userForm.getPhone() != null && !userForm.getPhone().isEmpty()) ? userForm.getPhone() : user.getPhone());
        user.setAbout((userForm.getAbout() != null && !userForm.getAbout().isEmpty()) ? userForm.getAbout() : user.getAbout());
        user.setName((userForm.getName() != null && !userForm.getName().isEmpty()) ? userForm.getName() : user.getName());
        user.setNotified((userForm.getNotified() == null) ? false : userForm.getNotified());

        userService.add(user);

        UserDTO userDTO = Translator.toDTO(user);
        userDTO.setEmail(user.getEmail());

        modelAndView.addObject("user", userDTO);

        return modelAndView;
    }
}
