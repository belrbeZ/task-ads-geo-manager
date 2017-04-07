package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.web.ApiResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Control Tasks Rest End points
 */
//@Controller
public class TaskRestController {

    private final String restEndpoint = WebmapResolver.WEB_SECURE
            + ApiResolver.API
            + ApiResolver.API
            + ApiResolver.REST_TASK;

}
