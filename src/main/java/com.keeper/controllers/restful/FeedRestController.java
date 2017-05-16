package com.keeper.controllers.restful;

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.core.IFeedService;
import com.keeper.service.modelbased.impl.CommentService;
import com.keeper.service.modelbased.impl.TaskService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

/**
 * Created by AlexVasil on 16.05.2017.
 *
 * @author AlexVasil
 */
public class FeedRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRestController.class);

    private final UserService userService;
    private IFeedService feedServise;

    @Autowired
    public FeedRestController(IFeedService feedServise, UserService userService) {
        this.feedServise = feedServise;
        this.userService = userService;
    }

    @RequestMapping(value = ApiResolver.FEEDTASK+"/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getGeoPointsAll() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            List<TaskDTO> usersTasks = feedServise.getAll(user.get().getId()).get();
            LOGGER.warn(user.get().getEmail() + " REST getListTasks ALL size: " + usersTasks.size());
            return new ResponseEntity<>(usersTasks, HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS ALL list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = ApiResolver.FEEDTASK+"/recent", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getGeoPointsRecent() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            List<TaskDTO> usersTasks = feedServise.getRecent(user.get().getId()).get();
            LOGGER.warn(user.get().getEmail() + " REST getListTasks RECENT size: " + usersTasks.size());
            return new ResponseEntity<>(usersTasks, HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS RECENT list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = ApiResolver.FEEDTASK+"/hot", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getGeoPointsHot() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            List<TaskDTO> usersTasks = feedServise.getHot(user.get().getId()).get();
            LOGGER.warn(user.get().getEmail() + " REST getListTasks HOT size: " + usersTasks.size());
            return new ResponseEntity<>(usersTasks, HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS HOT list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = ApiResolver.FEEDTASK+"/local", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getGeoPointsLocal() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            List<TaskDTO> usersTasks = feedServise.getLocal(user.get().getId()).get();
            LOGGER.warn(user.get().getEmail() + " REST getListTasks LOCAL size: " + usersTasks.size());
            return new ResponseEntity<>(usersTasks, HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS LOCAL list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = ApiResolver.FEEDTASK+"/owner", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getGeoPointsOwner() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            List<TaskDTO> usersTasks = feedServise.getOwned(user.get().getId()).get();
            LOGGER.warn(user.get().getEmail() + " REST getListTasks OWNER size: " + usersTasks.size());
            return new ResponseEntity<>(usersTasks, HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS OWNER list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}
