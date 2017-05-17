package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.SimpleResponse;
import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.modelbased.impl.CommentService;
import com.keeper.service.modelbased.impl.TaskService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import com.keeper.util.resolvers.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Control Tasks Rest End points
 */
@RestController
public class TaskRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRestController.class);

    private final UserService userService;
    private final TaskService repoService;

    @Autowired
    public TaskRestController(TaskService repoService, UserService userService) {
        this.repoService = repoService;
        this.userService = userService;
    }

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> get(@RequestParam(value = "id", required = false) Long id,
                                             @RequestParam(value = "userId", required = false) Long userId,
                                             @RequestParam(value = "search", required = false) String search,
                                             @RequestParam(value = "tags", required = false) List<String> tags) {
        if(id != null && id > 0)
            return new ResponseEntity<>(new ArrayList<TaskDTO>() {{ add(ModelTranslator.toDTO(repoService.get(id).get())); }}, HttpStatus.OK);
        if(userId != null && userId > 0)
            return new ResponseEntity<>(ModelTranslator.tasksToDTO(repoService.getByUserId(id).get()), HttpStatus.OK);
        if(!Validator.isStrEmpty(search))
            return new ResponseEntity<>(ModelTranslator.tasksToDTO(repoService.getByTheme(search).get()), HttpStatus.OK);
        if(tags != null && !tags.isEmpty())
            return new ResponseEntity<>(ModelTranslator.tasksToDTO(repoService.getByTags(tags).get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> update(@Valid @RequestBody TaskDTO modelTask, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            modelTask.setTopicStarterId(user.get().getId());
            LOGGER.warn("    REST Updating " + modelTask.toString());

            repoService.update(ModelTranslator.toDAO(modelTask));
        } else {
            LOGGER.warn("    REST ERROR of updating TASK " + modelTask.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new SimpleResponse("Задание обновлено!"), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> create(@Valid @RequestBody TaskDTO modelTask, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            modelTask.setTopicStarterId(user.get().getId());
            LOGGER.warn(user.get().getEmail() + " REST Creating TASK " + modelTask.toString());

            repoService.saveDTO(modelTask);
        } else {
            LOGGER.warn("    REST ERROR of creating TASK " + modelTask.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Задание добавлено!"), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> delete(@RequestParam("id") Long taskId) {
        Optional<User> user = userService.getAuthorized();
        if(user.isPresent()) {
            LOGGER.warn("    "+user.get().getEmail()+"REST Removing TASK id:" + taskId);
            repoService.remove(taskId);
        }else {
            LOGGER.warn("    REST ERROR of deleting TASK " + taskId);
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Место удалено!"), HttpStatus.OK);
    }
}
