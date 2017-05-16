package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.SimpleResponse;
import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.CommentDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.core.IFeedService;
import com.keeper.service.modelbased.impl.CommentService;
import com.keeper.service.modelbased.impl.TaskService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.Validator;
import com.keeper.util.resolve.ApiResolver;
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

    private final String PATH = ApiResolver.TASK;

    private final String PATH_COMMENT = ApiResolver.COMMENTS;

    private final UserService userService;
    private final TaskService repoService;
    private final CommentService commentService;

    @Autowired
    public TaskRestController(TaskService repoService, CommentService commentService, UserService userService) {
        this.repoService = repoService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> get(@RequestParam(value = "id", required = false) Long id,
                                             @RequestParam(value = "userId", required = false) Long userId,
                                             @RequestParam(value = "search", required = false) String search,
                                             @RequestParam(value = "tags", required = false) List<String> tags) {
        if(id != null && id > 0)
            return new ResponseEntity<>(new ArrayList<TaskDTO>() {{ add(Translator.toDTO(repoService.get(id).get())); }}, HttpStatus.OK);
        if(userId != null && userId > 0)
            return new ResponseEntity<>(Translator.tasksToDTO(repoService.getByUserId(id).get()), HttpStatus.OK);
        if(!Validator.isStrEmpty(search))
            return new ResponseEntity<>(Translator.tasksToDTO(repoService.getByTheme(search).get()), HttpStatus.OK);
        if(tags != null && !tags.isEmpty())
            return new ResponseEntity<>(Translator.tasksToDTO(repoService.getByTags(tags).get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> update(@Valid @RequestBody TaskDTO modelTask, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            modelTask.setTopicStarterId(user.get().getId());
            LOGGER.warn("    REST Updating " + modelTask.toString());

            repoService.update(Translator.toDAO(modelTask));
        } else {
            LOGGER.warn("    REST ERROR of updating TASK " + modelTask.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new SimpleResponse("Задание обновлено!"), HttpStatus.OK);
    }


    @RequestMapping(value = PATH, method = RequestMethod.POST,
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

    @RequestMapping(value = PATH, method = RequestMethod.DELETE,
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

    /*@RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody TaskDTO model, BindingResult result) {
        repoService.update(Translator.toDAO(model));

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

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody TaskDTO modelTask, BindingResult result) {
        repoService.saveDTO(modelTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        repoService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/


    /*---COMMENTS---*//*
    @RequestMapping(value = PATH_COMMENT + "/{taskId}}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable("taskId") Long taskId) {
        return new ResponseEntity<>(Translator.commentsToDTO(commentService.getByTaskId(taskId).get()), HttpStatus.OK);
    }

    @RequestMapping(value = PATH_COMMENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addComment(@Valid @RequestBody  CommentDTO comment, BindingResult result) {
        commentService.saveDTO(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH_COMMENT, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeComment(@RequestParam("commentId") Long commentId) {
        commentService.remove(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    *//*---END COMMENTS---*/

//    /*---TAGS---*/
//    @RequestMapping(value = PATH + "/tags/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<TagDTO>> getTags(@PathVariable("taskId") Long taskId) {
////        if (user == null) {
////            System.out.println("User with id " + id + " not found");
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
//        return new ResponseEntity<>(repoService.getTags(taskId), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = PATH + "/tags", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDTO> addTag(@RequestParam("taskId") Long taskId, @Valid @RequestBody  TagDTO tag, BindingResult result) {
//        return new ResponseEntity<>(repoService.addTag(taskId, tag), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = PATH + "/tags/byObj", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDTO> removeTag(@RequestParam("taskId") Long taskId, @Valid @RequestBody TagDTO tag) {
//        return new ResponseEntity<>(repoService.removeTag(taskId, tag), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = PATH + "/tags", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDTO> removeTag(@RequestParam("taskId") Long taskId, @RequestParam("tagId") Long tagId) {
//        return new ResponseEntity<>(repoService.removeTagById(taskId, tagId), HttpStatus.OK);
//    }
//
//    /*---END TAGS---*/

//    /*@RequestMapping(value = PATH + "/participants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<UserDTO>> getParticipants(@RequestParam("id") Long id) {
//        return new ResponseEntity<>(Translator.commentsToDTO(repoService.get(id).orElse(Task.EMPTY).getParticipants(), HttpStatus.OK);
//    }*/
//
//    /*---PARTICIPANTS---*/
//    @RequestMapping(value = PATH + "/participants/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<UserDTO>> getParticipants(@PathVariable("taskId") Long taskId) {
////        if (user == null) {
////            System.out.println("User with id " + id + " not found");
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
//        return new ResponseEntity<>(repoService.getParticipants(taskId), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = PATH + "/participants", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDTO> addParticipant(@RequestParam("taskId") Long taskId,@RequestParam("userId") Long userId/*, @Valid @RequestBody  UserDTO participant, BindingResult result*/) {
//        return new ResponseEntity<>(repoService.addParticipant(taskId, userId), HttpStatus.OK);
//    }
//
////    @RequestMapping(value = PATH + "/participants/byObj", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<TaskDTO> removeParticipant(@RequestParam("taskId") Long taskId, @Valid @RequestBody UserDTO participant) {
////        return new ResponseEntity<>(repoService.removeParticipant(taskId, participant), HttpStatus.OK);
////    }
//
//    @RequestMapping(value = PATH + "/participants", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDTO> removeParticipant(@RequestParam("taskId") Long taskId, @RequestParam("participantId") Long participantId) {
//        return new ResponseEntity<>(repoService.removeParticipantById(taskId, participantId), HttpStatus.OK);
//    }
//
//    /*---END PARTICIPANTS---*/

}
