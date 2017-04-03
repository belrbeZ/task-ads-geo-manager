package com.keeper.controllers.main;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.dto.GeoPointDto;
import com.keeper.util.ViewResolver;
import com.keeper.util.WebMappingResolver;
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

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.GET)
    public String mainPage(Model model) {


        return ViewResolver.WEB_MAIN;
    }

    @RequestMapping(value = WebMappingResolver.WEB_PAGE_MAIN,
                    method = RequestMethod.POST)
    public String mainPageUpdateGeoPoint(@PathVariable GeoPointDto geoPoint,
                                         Model model) {


        return ViewResolver.WEB_MAIN;
    }
}
