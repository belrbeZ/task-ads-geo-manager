package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 19.04.2017.
 */

import com.keeper.util.web.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
//@ControllerAdvice
public class ErrorWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorWebController.class);

//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView errorGet(final Throwable throwable, final Model model) {
        ModelAndView modelAndView = new ModelAndView(ViewResolver.PAGE_ERROR);

        LOGGER.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null) ? throwable.getMessage() : "Unknown error";
        modelAndView.addObject("err", errorMessage);

        return modelAndView;
    }
}
