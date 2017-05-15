package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dto.CommentDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.modelbased.impl.CommentService;
import com.keeper.service.modelbased.impl.TaskService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import com.keeper.util.resolvers.ApiResolver;
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

    private final TaskService repoService;
    private final CommentService commentService;

    @Autowired
    public TaskRestController(TaskService repoService, CommentService commentService) {
        this.repoService = repoService;
        this.commentService = commentService;
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

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody TaskDTO model, BindingResult result) {
        repoService.update(ModelTranslator.toDAO(model));

        HttpStatus code = HttpStatus.OK;
        String info = "";
        try {
            Optional<Task> task = repoService.updateDTO(model);
            if(!task.isPresent()) {
                info = "NULLABLE";
                code = HttpStatus.NOT_MODIFIED;
            }
        } catch (NullPointerException e) {
            info = e.getMessage();
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(info, code);
    }

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody TaskDTO modelTask, BindingResult result) {
        repoService.saveDTO(modelTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.TASK, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        repoService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*---COMMENTS---*/
    @RequestMapping(value = ApiResolver.COMMENTS + "/{taskId}}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable("taskId") Long taskId) {
        return new ResponseEntity<>(ModelTranslator.commentsToDTO(commentService.getByTaskId(taskId).get()), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.COMMENTS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addComment(@Valid @RequestBody  CommentDTO comment, BindingResult result) {
        commentService.saveDTO(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.COMMENTS, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeComment(@RequestParam("commentId") Long commentId) {
        commentService.remove(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
