package com.keeper.controllers.web;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.util.resolvers.WebMappingResolver;
import com.keeper.util.resolvers.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Default Comment
 */
@Controller
public class MainPageWebController {

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.GET)
    public String mainPage(Model model) {


        return ViewResolver.WEB_MAIN;
    }

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.POST)
    public String mainPageUpdateGeoPoint(@PathVariable GeoPoint geoPoint,
                                         Model model) {


        return ViewResolver.WEB_MAIN;
    }
}
