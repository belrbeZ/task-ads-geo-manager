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

            Optional<List<TaskDTO>> usersTasks;

            if(type == null)
                usersTasks = feedService.getLocal(user.get().getId());
            else {
                FeedType realType = FeedType.MY;
                switch (type) {
                    case 0:  realType = FeedType.ALL;   break;
                    case 20: realType = FeedType.NEW;   break;
                    case 30: realType = FeedType.LOCAL; break;
                    case 40: realType = FeedType.HOT;   break;
                    case 50: realType = FeedType.SUBSCRIBED; break;

                    default: break;  // ON PURPOSE CAUSE ALREADY FeedType = MY
                }
                usersTasks = feedService.getByTheme(user.get().getId(), search, realType);
            }

            LOGGER.warn(user.get().getEmail() + " REST getListTasks ALL size: " + usersTasks.get().size());
            return new ResponseEntity<>(usersTasks.get(), HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting TASKS ALL list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
