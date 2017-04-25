package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.UserDTO;
import com.keeper.service.impl.TaskService;
import com.keeper.service.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * Default Comment
 */
@Controller
public class FeedWebController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public FeedWebController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.GET)
    public ModelAndView feedGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Long userId = Translator.convertToDTO(userService.getByEmail(auth.getName()).orElse(User.EMPTY)).getId();

        List<Task> tasks = taskService.getByUserId(userId);

        System.out.println("User ID : " + userId);
        if(tasks != null && !tasks.isEmpty()) {
            System.out.println("Tasks : " + tasks.size());
            modelAndView.addObject("emptyMessage", "There no tasks for you.. Sorry..");
        }

        modelAndView.addObject("tasks", Translator.convertTasksToDTO(tasks));

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.POST)
    public ModelAndView feedSearch(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        return modelAndView;
    }
}
