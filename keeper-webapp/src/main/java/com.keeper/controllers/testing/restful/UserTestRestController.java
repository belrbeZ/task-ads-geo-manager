package com.keeper.controllers.testing.restful;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.entity.dao.UserTest;
import com.keeper.entity.dto.UserTestDTO;
import com.keeper.service.impl.UserTestRepoService;
import com.keeper.util.Converter;
import com.keeper.util.web.ApiResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Default Comment
 */
@RestController
public class UserTestRestController {

    public static final MediaType type = MediaType.APPLICATION_JSON;

    public static final String path = WebmapResolver.WEB_SECURE
            + ApiResolver.API
            + ApiResolver.TEST_REST
            + ApiResolver.REST_PROFILE;

    @Autowired
    private UserTestRepoService repoService;

    @RequestMapping(value = path, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    String get(@RequestParam(value = "id") Long userId) {
        return Converter.convertToJson(repoService.get(userId));
    }

    @RequestMapping(value = path, method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    String update(@RequestParam(value = "id") Long userId) {
        //
        return null;
    }

    @RequestMapping(value = path, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    String create(@RequestBody UserTest model) {
        repoService.add(model);
        return null;
    }

    @RequestMapping(value = path, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    String delete(@RequestParam("id") Long userId) {
        repoService.remove(userId);
        return null;
    }
}
