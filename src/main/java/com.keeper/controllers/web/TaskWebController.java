package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
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

        Optional<User> user = userService.getAuthorized();
        if(user.isPresent()){
            if(Validator.isIdValid(taskId)) {
                Optional<Task> daoTask = taskService.get(taskId);
                if(daoTask.isPresent()) {
                    modelAndView.addObject("user", Translator.toDTO(user.get()));
                    modelAndView.addObject("task", Translator.toDTO(daoTask.get()));
                    return modelAndView;
                }
                else
                    modelAndView.addObject("message", "No Such Task!");
            }
            else
                modelAndView.addObject("message", "Invalid Task ID!");
        }
        else
            modelAndView.addObject("message", "ReLogin First!");

        modelAndView.setViewName(TemplateResolver.redirect(TemplateResolver.FEED));

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK, method = RequestMethod.DELETE)
    public ModelAndView taskDelete(@RequestParam(value = "id", required = false) Long taskId, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.redirect(TemplateResolver.FEED));

        Optional<User> user = userService.getAuthorized();
        if(user.isPresent()) {
            try {
                taskService.remove(taskId);
            } catch (Exception e) {
                modelAndView.addObject("message", "No Such Task!");
            }
        }
        else
            modelAndView.addObject("message", "ReLogin First");

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK_FORM, method = RequestMethod.GET)
    public ModelAndView taskCreateForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK_FORM);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            TaskDTO dto = new TaskDTO();
            if(Validator.isIdValid(id)) {
                Optional<Task> updateTask = taskService.get(id);

                if(updateTask.isPresent())
                    dto = Translator.toDTO(updateTask.get());
            }
            modelAndView.addObject("task", dto);
            return modelAndView;
        }
        else
            modelAndView.addObject("message", "ReLogin First!");

        modelAndView.setViewName(TemplateResolver.redirect(TemplateResolver.FEED));

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.TASK_FORM, method = RequestMethod.POST)
    public ModelAndView taskUpdateOrCreate(@Valid TaskDTO task, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.TASK);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            task.setTopicStarterId(user.get().getId());
            // RADIUS SHOULD BE MORE THAT 0 ALWAYS TO SAVE
            task.setGeo(new SimpleGeoPoint("0.", "0.", 15));

            try {
                if (Validator.isIdValid(task.getId()))
                    taskService.updateDTO(task);
                else
                    taskService.saveDTO(task);

                modelAndView.addObject("user", user.get());
                modelAndView.addObject("task", task);
                return modelAndView;
            }
            catch (Exception e) {
                modelAndView.addObject("message", "No Such Task!");
                modelAndView.setViewName(TemplateResolver.FEED);
            }
        }

        modelAndView.setViewName(TemplateResolver.redirect(TemplateResolver.FEED));

        return modelAndView;
    }
}
