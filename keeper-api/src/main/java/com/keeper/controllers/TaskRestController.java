package com.keeper.controllers;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.PathResolver;
import org.springframework.stereotype.Controller;

/**
 * Control Tasks Rest End points
 */
@Controller
public class TaskRestController {

    private final String restPath = PathResolver.API + PathResolver.REST_TASKS;

    public String getTasks() {

        return null;
    }

    public String postTasks() {

        return null;
    }

    public String patchTasks() {

        return null;
    }

    public String deleteTasks() {

        return null;
    }

}
