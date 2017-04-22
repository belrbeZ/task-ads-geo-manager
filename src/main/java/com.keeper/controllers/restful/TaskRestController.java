package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dto.*;
import com.keeper.service.impl.TaskRepoService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(value = PATH + "/participants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getParticipants(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.convertToDTO(repoService.get(id)).getParticipants(), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> getComments(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.convertToDTO(repoService.get(id)).getComments(), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/tags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getTasksByTags(@PathVariable("tags") List<String> tags) {
        return new ResponseEntity<>(Translator.convertTasksToDTO(repoService.getByTags(tags)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH+"/byUserId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getByUserId(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(Translator.convertTasksToDTO(repoService.getByUserId(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> get(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.convertToDTO(repoService.get(id)), HttpStatus.OK);
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

    @RequestMapping(value = PATH+"/byUserId", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteByUserId(@RequestParam("userId") Long userId) {
        repoService.removeByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        repoService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
