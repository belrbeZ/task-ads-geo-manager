package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.FeedType;
import com.keeper.service.impl.FeedService;
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
import java.util.Optional;

/**
 * Default Comment
 */
@Controller
public class FeedWebController {

    private final FeedService feedService;
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public FeedWebController(TaskService taskService, UserService userService, FeedService feedService) {
        this.taskService = taskService;
        this.userService = userService;
        this.feedService = feedService;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.GET)
    public ModelAndView feedGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Long userId = userService.getByEmail(auth.getName()).get().getId();
        Optional<List<TaskDTO>> tasks = Optional.of(Collections.emptyList());

        if (userId != null && !(tasks = feedService.getAll(userId)).isPresent())
            modelAndView.addObject("emptyMessage", "There no tasks for you.. Sorry..");

        modelAndView.addObject("tasks", tasks.get());

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.POST)
    public ModelAndView feedSearch(@RequestParam(value = "search", required = false) String theme,
                                   @RequestParam(value = "type", required = false) Integer type, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Translator.toDTO(userService.getByEmail(auth.getName()).orElse(User.EMPTY)).getId();

        Optional<List<TaskDTO>> tasks = null;

        System.out.println(type);

        if(type == null)
            tasks = feedService.getByTheme(theme);
        else
            switch (type) {
                case 10: tasks = feedService.getOwned(userId); break;
                case 20: tasks = feedService.getRecent(userId); break;
                case 30: tasks = feedService.getOwned(userId); break;
                case 40: tasks = feedService.getHot(userId); break;
                case 0:
                    default: tasks = feedService.getAll(userId); break;
            }

        if(!tasks.isPresent())
            modelAndView.addObject("emptyMessage", "There no tasks for you.. Sorry..");

        modelAndView.addObject("tasks", tasks.get());

        return modelAndView;
    }
}
