package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    public FeedWebController(UserService userService, FeedService feedService) {
        this.userService = userService;
        this.feedService = feedService;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.GET)
    public ModelAndView feedGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        Long userId = userService.getAuthorized().orElse(User.EMPTY).getId();
        Optional<List<TaskDTO>> tasks = Optional.of(Collections.emptyList());

        if (userId != null && !(tasks = feedService.getRecent(userId)).isPresent())
            modelAndView.addObject("emptyMessage", "There no tasks for you.. Sorry..");

        modelAndView.addObject("tasks", tasks.get());

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.POST)
    public ModelAndView feedSearch(@RequestParam(value = "search", required = false) String theme,
                                   @RequestParam(value = "type", required = false) Integer type, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        Optional<User> userId = userService.getAuthorized();
        Optional<List<TaskDTO>> tasks = Optional.empty();

        if(type == null && userId.isPresent())
            tasks = feedService.getByTheme(theme);
        else if(type != null && userId.isPresent() && userId.get().getId() != null)
            switch (type) {
                case 10: tasks = feedService.getOwned(userId.get().getId());  break;
                case 20: tasks = feedService.getRecent(userId.get().getId()); break;
                case 30: tasks = feedService.getLocal(userId.get().getId());  break;
                case 40: tasks = feedService.getHot(userId.get().getId());    break;
                case 0:
                    default: tasks = feedService.getAll(userId.get().getId()); break;
            }

        if(!tasks.isPresent() || tasks.get().isEmpty()) {
            modelAndView.addObject("emptyMessage", "There no tasks for you.. Sorry..");
            tasks = Optional.of(Collections.emptyList());
        }

        modelAndView.addObject("tasks", tasks.get());

        return modelAndView;
    }
}
