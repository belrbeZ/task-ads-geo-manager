package com.keeper.controllers.common;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.util.web.ViewResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class MainWebController {

    @RequestMapping(value = WebmapResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.GET)
    public String mainPage(Model model) {


        return ViewResolver.WEB_MAIN;
    }

    @RequestMapping(value = WebmapResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.POST)
    public String mainPageUpdateGeoPoint(Model model) {


        return ViewResolver.WEB_MAIN;
    }
}
