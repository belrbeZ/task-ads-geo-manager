package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@ControllerAdvice
public class CommonWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView errorGet(final Throwable throwable, /*final*/ Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_ERROR);
modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        LOGGER.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null) ? throwable.getMessage() : "Unknown error";
        model.addAttribute("errorMessage", errorMessage);

        return modelAndView;
    }

    @RequestMapping(value = WebmapResolver.WEB_DENIED, method = RequestMethod.GET)
    public ModelAndView deniedGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_DENIED);

        return modelAndView;
    }
}
