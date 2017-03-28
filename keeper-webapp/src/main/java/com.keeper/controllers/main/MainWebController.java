package com.keeper.controllers.main;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.entity.GeoPoint;
import com.keeper.util.WebappResolver;
import com.keeper.util.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class MainWebController {

    @RequestMapping(value = WebappResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.GET)
    public String mainPage(Model model) {


        return ViewResolver.WEB_MAIN;
    }

    @RequestMapping(value = WebappResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.POST)
    public String mainPageUpdateGeoPoint(@PathVariable GeoPoint geoPoint,
                                         Model model) {


        return ViewResolver.WEB_MAIN;
    }
}
