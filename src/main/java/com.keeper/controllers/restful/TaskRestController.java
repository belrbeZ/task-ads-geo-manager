package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.ModelLoggerManager;
import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.*;
import com.keeper.service.impl.GeoPointService;
import com.keeper.service.impl.TaskService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * Control Tasks Rest End points
 */
@RestController
public class TaskRestController {

    private final String PATH = ApiResolver.TASK;

    private final TaskService repoService;

    @Autowired
    public TaskRestController(TaskService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = ApiResolver.SEARCH_TASK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> searchByTheme(@PathVariable("search") String search) {

        List<Task> tasks = repoService.getByTheme(search);
        List<TaskDTO> taskDTOS = Collections.emptyList();

        if(tasks != null && !tasks.isEmpty())
            taskDTOS = Translator.tasksToDTO(tasks);

        return new ResponseEntity<>(taskDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/tags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getTasksByTags(@PathVariable("tags") List<String> tags) {
        return new ResponseEntity<>(Translator.tasksToDTO(repoService.getByTags(tags)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH+"/byUserId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getByUserId(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(Translator.tasksToDTO(repoService.getByUserId(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> get(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.toDTO(repoService.get(id).orElse(Task.EMPTY)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody TaskDTO model, BindingResult result) {
        repoService.update(Translator.toDAO(model));

        HttpStatus code = HttpStatus.OK;
        String info = "";
        try {
            Task task = repoService.updateTaskDAO(repoService.get(model.getId()), model);
            ModelLoggerManager.logSetupError(task.getLastModifyDate().toString());
            repoService.update(task);
        } catch (NullPointerException e) {
            e.printStackTrace();
            info = e.getMessage();
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        } finally {

        }

        return new ResponseEntity<>(info, code);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestParam("userId") Long userId,@Valid @RequestBody TaskDTO modelTask, BindingResult result) {
            modelTask.setTopicStarterId(userId);
            repoService.add(Translator.toDAO(modelTask));
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


    /*---PICTURE---*/
    @RequestMapping(value = PATH + "/picture", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PictureDTO> getPicture(@RequestParam("taskId") Long taskId) {
        return new ResponseEntity<>(repoService.getPicture(taskId), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/picture", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> setPicture(@RequestParam("taskId") Long taskId, @Valid @RequestBody PictureDTO picture, BindingResult result) {
        return new ResponseEntity<>(repoService.setPicture(taskId, picture), HttpStatus.OK);
    }
    /*---END PICTURE---*/

    /*---ORIGIN GEO POINT---*/
    @RequestMapping(value = PATH + "/originGeo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleGeoPoint> getOriginGeoPoint(@RequestParam("taskId") Long taskId) {
        return new ResponseEntity<>(repoService.getOriginGeoPoint(taskId), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/originGeo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> setOriginGeoPoint(@RequestParam("taskId") Long taskId,@Valid @RequestBody GeoPointDTO modelGeo) {
        return new ResponseEntity<>(repoService.setOriginGeoPoint(taskId, modelGeo), HttpStatus.OK);
    }
    /*---END PICTURE---*/

    /*---COMMENTS---*/
    @RequestMapping(value = PATH + "/comments/{taskId}}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable("taskId") Long taskId) {
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(repoService.getComments(taskId), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/comments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> addComment(@RequestParam("taskId") Long taskId,@RequestParam("userId") Long userId, @Valid @RequestBody  CommentDTO comment, BindingResult result) {
        return new ResponseEntity<>(repoService.addComment(taskId, userId, comment), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/comments/byObj", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeComment(@RequestParam("taskId") Long taskId, @Valid @RequestBody CommentDTO comment) {
        return new ResponseEntity<>(repoService.removeComment(taskId, comment), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/comments", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeComment(@RequestParam("taskId") Long taskId, @RequestParam("commentId") Long commentId) {
        return new ResponseEntity<>(repoService.removeCommentById(taskId, commentId), HttpStatus.OK);
    }

    /*---END COMMENTS---*/


    /*---TAGS---*/
    @RequestMapping(value = PATH + "/tags/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TagDTO>> getTags(@PathVariable("taskId") Long taskId) {
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(repoService.getTags(taskId), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/tags", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> addTag(@RequestParam("taskId") Long taskId, @Valid @RequestBody  TagDTO tag, BindingResult result) {
        return new ResponseEntity<>(repoService.addTag(taskId, tag), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/tags/byObj", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeTag(@RequestParam("taskId") Long taskId, @Valid @RequestBody TagDTO tag) {
        return new ResponseEntity<>(repoService.removeTag(taskId, tag), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/tags", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeTag(@RequestParam("taskId") Long taskId, @RequestParam("tagId") Long tagId) {
        return new ResponseEntity<>(repoService.removeTagById(taskId, tagId), HttpStatus.OK);
    }

    /*---END TAGS---*/

    /*@RequestMapping(value = PATH + "/participants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getParticipants(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.commentsToDTO(repoService.get(id).orElse(Task.EMPTY).getParticipants(), HttpStatus.OK);
    }*/

    /*---PARTICIPANTS---*/
    @RequestMapping(value = PATH + "/participants/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getParticipants(@PathVariable("taskId") Long taskId) {
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(repoService.getParticipants(taskId), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/participants", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> addParticipant(@RequestParam("taskId") Long taskId,@RequestParam("userId") Long userId/*, @Valid @RequestBody  UserDTO participant, BindingResult result*/) {
        return new ResponseEntity<>(repoService.addParticipant(taskId, userId), HttpStatus.OK);
    }

//    @RequestMapping(value = PATH + "/participants/byObj", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDTO> removeParticipant(@RequestParam("taskId") Long taskId, @Valid @RequestBody UserDTO participant) {
//        return new ResponseEntity<>(repoService.removeParticipant(taskId, participant), HttpStatus.OK);
//    }

    @RequestMapping(value = PATH + "/participants", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> removeParticipant(@RequestParam("taskId") Long taskId, @RequestParam("participantId") Long participantId) {
        return new ResponseEntity<>(repoService.removeParticipantById(taskId, participantId), HttpStatus.OK);
    }

    /*---END PARTICIPANTS---*/

}
