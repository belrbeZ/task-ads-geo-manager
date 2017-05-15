package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.resolvers.TemplateResolver;
import com.keeper.util.resolvers.WebResolver;
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

    private final String TASKS_OBJ = "tasks";
    private final String USER_ID_OBJ = "userId";
    private final String MSG = "msg";

    private final String ATTR_SEARCH = "search";
    private final String ATTR_FILTER = "filter";

    @Autowired
    public FeedWebController(UserService userService,
                             FeedService feedService) {
        this.userService = userService;
        this.feedService = feedService;
    }

    @RequestMapping(value = WebResolver.FEED, method = RequestMethod.GET)
    public ModelAndView feedGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        Optional<User> user = userService.getAuthorized();
        Optional<List<TaskDTO>> tasks = Optional.empty();

        if(!user.isPresent())
            modelAndView.addObject(MSG, "There no tasks for you.. Sorry..");
        else if(!(tasks = feedService.getRecent(user.get().getId())).isPresent())
            modelAndView.addObject(MSG, "There no tasks for you.. Sorry..");

        modelAndView.addObject(USER_ID_OBJ, (user.isPresent()) ? user.get().getId() : 0);
        modelAndView.addObject(TASKS_OBJ, (tasks.isPresent()) ? tasks.get() : Collections.emptyList());

        return modelAndView;
    }

    /**
     * Feed Search By Theme
     */
    @RequestMapping(value = WebResolver.FEED_SEARCH, method = RequestMethod.POST)
    public ModelAndView feedSearch(@RequestParam(value = ATTR_SEARCH) String theme, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        Optional<List<TaskDTO>> tasks = Optional.empty();
        Optional<User> user = userService.getAuthorized();
        if(user.isPresent())
            tasks = feedService.getByTheme(user.get().getId(), theme);
        else
            modelAndView.addObject(MSG, "ReLogin First!");

        if(!tasks.isPresent() || tasks.get().isEmpty())
            modelAndView.addObject(MSG, "There no tasks for you.. Sorry..");

        modelAndView.addObject(USER_ID_OBJ, (user.isPresent()) ? user.get().getId() : 0);
        modelAndView.addObject(TASKS_OBJ, (tasks.isPresent()) ? tasks.get() : Collections.emptyList());

        return modelAndView;
    }

    /**
     * Feed Filter
     */
    @RequestMapping(value = WebResolver.FEED_FILTER, method = RequestMethod.POST)
    public ModelAndView feedFilter(@RequestParam(value = ATTR_FILTER) Integer type, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        Optional<User> user = userService.getAuthorized();
        Optional<List<TaskDTO>> tasks = Optional.empty();

        if(user.isPresent()) {
                switch (type) {
                    case 10: tasks = feedService.getOwned(user.get().getId()); break;
                    case 20: tasks = feedService.getRecent(user.get().getId()); break;
                    case 30: tasks = feedService.getLocal(user.get().getId()); break;
                    case 40: tasks = feedService.getHot(user.get().getId()); break;
                    case 0:
                    default:
                        tasks = feedService.getAll(user.get().getId());
                        break;
                }
        }
        else modelAndView.addObject(MSG, "ReLogin First!");

        if(!tasks.isPresent() || tasks.get().isEmpty())
            modelAndView.addObject(MSG, "There no tasks for you.. Sorry..");

        modelAndView.addObject(USER_ID_OBJ, (user.isPresent()) ? user.get().getId() : 0);
        modelAndView.addObject(TASKS_OBJ, (tasks.isPresent()) ? tasks.get() : Collections.emptyList());

        return modelAndView;
    }
}
