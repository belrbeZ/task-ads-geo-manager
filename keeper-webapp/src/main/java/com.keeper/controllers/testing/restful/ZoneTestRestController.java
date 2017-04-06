package com.keeper.controllers.testing.restful;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.entity.dao.ZoneTest;
import com.keeper.entity.dto.UserTestDTO;
import com.keeper.entity.dto.ZoneTestDTO;
import com.keeper.util.web.ApiResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class ZoneTestRestController {

    public static final MediaType type = MediaType.APPLICATION_JSON;

    public static final String path = WebmapResolver.WEB_SECURE
            + ApiResolver.API
            + ApiResolver.TEST_REST
            + ApiResolver.REST_ZONE;

    @RequestMapping(value = path, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    String get(@PathVariable("id") String userId) {
        return null;
    }

    @RequestMapping(value = path, method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    String update(@RequestBody ZoneTestDTO model) {
        return null;
    }

    @RequestMapping(value = path, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    String create(@RequestBody ZoneTest model) {
        return null;
    }

    @RequestMapping(value = path, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    String delete(@PathVariable("id") String userId) {
        return null;
    }
}
