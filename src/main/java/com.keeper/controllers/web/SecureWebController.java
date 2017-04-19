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
import com.keeper.util.validation.impl.UserCreateFormValidator;
import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Control Web & Api OAUTH and Registration forms
 */
@Controller
public class SecureWebController {

    private final UserRepoService repoService;
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public SecureWebController(UserRepoService repoService) {
        this.repoService = repoService;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = WebmapResolver.WEB_REGISTER, method = RequestMethod.GET)
    public ModelAndView registerGet(Model model) {
        ModelAndView modelAndView
                = new ModelAndView(ViewResolver.PAGE_REGISTER, "form",
                                    (model.containsAttribute("form")
                                        ? model.asMap().get("form")
                                        : new UserFormDTO()));

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_REGISTER, method = RequestMethod.POST)
    public ModelAndView registerPost(@Valid @ModelAttribute("form") UserFormDTO form, Model model, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_REGISTER);

        if (result.hasErrors()) {
            modelAndView.addObject("form", form);
            return modelAndView;
        }

        try {
            repoService.add(Translator.convertToDAO(form));
        } catch (DataIntegrityViolationException e) {
            result.reject("email.exists", "Email already exists");
            form.setEmail("");
            modelAndView.addObject("form", form);
            return modelAndView;
        }
        modelAndView.setViewName(ViewResolver.redirect(ViewResolver.PAGE_HOME));
        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_LOGIN, method = RequestMethod.GET)
    public ModelAndView loginGet(@RequestParam Optional<String> error, Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_LOGIN, "error", error);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_LOGIN, method = RequestMethod.POST)
    public ModelAndView loginPost(Model model, String error, String logout) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_LOGIN);

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_LOGOUT, method = RequestMethod.POST)
    public ModelAndView logoutGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_LOGOUT);

        return modelAndView;
    }
}
