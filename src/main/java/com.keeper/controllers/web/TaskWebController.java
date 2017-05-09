package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.TaskType;
import com.keeper.service.modelbased.impl.TaskService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.Validator;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Default Comment
 */
@Controller
public class TaskWebController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskWebController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.TASK, method = RequestMethod.GET)
    public ModelAndView taskGet(@RequestParam(value = "id", required = false) Long taskId, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        userService.getAuthorized().ifPresent(usr ->  {
            if(Validator.isIdValid(taskId)) {
                modelAndView.addObject("user", Translator.toDTO(usr));
                modelAndView.addObject("task", taskService.get(taskId));
            }
            else
                modelAndView.setViewName(TemplateResolver.FEED);
        });

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK, method = RequestMethod.DELETE)
    public ModelAndView taskDelete(@RequestParam(value = "id", required = false) Long taskId, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.FEED);

        userService.getAuthorized().ifPresent(usr ->  {
            if(Validator.isIdValid(taskId)) {
                taskService.remove(taskId);
                modelAndView.setViewName(TemplateResolver.FEED);
            }
            else
                modelAndView.addObject("message", "No Such Task!");
        });

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK_FORM, method = RequestMethod.GET)
    public ModelAndView taskCreateForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK_FORM);

        userService.getAuthorized().ifPresent(usr ->  {
            if(Validator.isIdValid(id)) {
                TaskDTO dto = new TaskDTO();
                Optional<Task> updateTask = taskService.get(id);
                if(updateTask.isPresent())
                    dto = Translator.toDTO(updateTask.get());

                modelAndView.addObject("task", dto);
            }
            else
                modelAndView.addObject("message", "Login Please!");
        });

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK_FORM, method = RequestMethod.POST)
    public ModelAndView taskUpdateOrCreate(@Valid TaskDTO task, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        Optional<User> user = userService.getAuthorized();
        if(user.isPresent()) {
            task.setTopicStarterId(user.get().getId());
            task.setGeo(new SimpleGeoPoint("0.", "0.", 15));

            if(task.getId() == null || task.getId().equals(TaskType.EMPTY.getValue()))
                taskService.saveDTO(task);
            else
                taskService.updateDTO(task);

            modelAndView.addObject("user", user.get());
            modelAndView.addObject("task", task);
        }
        else
            modelAndView.setViewName(TemplateResolver.FEED);

        return modelAndView;
    }
}
