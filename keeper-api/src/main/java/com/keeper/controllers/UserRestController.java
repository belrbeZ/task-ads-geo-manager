package com.keeper.controllers;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.PathResolver;
import org.springframework.stereotype.Controller;

/**
 * Control Profile Rest End points
 */
@Controller
public class UserRestController {

    private final String restPath = PathResolver.API + PathResolver.REST_PROFILE;

    public String getProfile() {

        return null;
    }

    public String patchProfile() {

        return null;
    }

}
