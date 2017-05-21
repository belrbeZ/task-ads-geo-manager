package com.keeper.controllers.restful;

import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.FeedType;
import com.keeper.service.core.IFeed;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.resolvers.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by AlexVasil on 16.05.2017.
 *
 * @author AlexVasil
 */
@RestController
public class FeedRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRestController.class);

    private final UserService userService;
    private final IFeed feedService;

    @Autowired
    public FeedRestController(FeedService feedService, UserService userService) {
        this.feedService = feedService;
        this.userService = userService;
    }

    @RequestMapping(value = ApiResolver.FEED + "/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskDTO>> getFeed(@PathVariable(value = "type") Integer type,
                                                 @RequestParam(value = "search", required = false) String search) {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {

            Optional<List<TaskDTO>> usersTasks = (type == null)
                    ? feedService.getLocal(user.get().getId())
                    : feedService.getByTheme(user.get().getId(), search, FeedType.calc(type));

            if(!usersTasks.isPresent()) {
                LOGGER.warn(user.get().getEmail() + " REST Can't get list of Tasks!");
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
            }

            LOGGER.warn(user.get().getEmail() + " REST getListTasks "+FeedType.calc(type)+" size: " + usersTasks.get().size());
            return new ResponseEntity<>(usersTasks.get(), HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS ALL list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
