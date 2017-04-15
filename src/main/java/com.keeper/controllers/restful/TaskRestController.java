package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dto.TaskDTO;
import com.keeper.service.impl.TaskRepoService;
import com.keeper.util.Converter;
import com.keeper.util.Translator;
import com.keeper.util.web.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Control Tasks Rest End points
 */
@RestController
public class TaskRestController {
    private final String PATH = ApiResolver.REST_TASK;

    private final TaskRepoService repoService;

    @Autowired
    public TaskRestController(TaskRepoService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> get(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(Translator.convertTasksToDTO(repoService.getByUserId(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody TaskDTO model, BindingResult result) {
        repoService.update(Translator.convertToDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody TaskDTO model, BindingResult result) {
        repoService.add(Translator.convertToDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long userId) {
        repoService.removeByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
