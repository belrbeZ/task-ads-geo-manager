package com.keeper.controllers.web;

/*
 * Created by @GoodforGod on 25.04.2017.
 */

import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.resolvers.TemplateResolver;
import com.keeper.util.resolvers.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Default Comment
 */
@Controller
public class MapWebController {

    private final GeoPointService geoPointService;
    private final UserService userService;

    @Autowired
    public MapWebController(GeoPointService geoPointService, UserService userService) {
        this.geoPointService = geoPointService;
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.MAP, method = RequestMethod.GET)
    public ModelAndView mapGet(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAP);

		/*if(modelAndView.getModel().get("geoPoint") == null) {
			GeoPointDTO geoPointDTO = GeoPointDTO.EMPTY;
			modelAndView.addObject("geoPoint", geoPointDTO);
        }*/

        /*if(modelAndView.getModel().get("geoPoints") == null) {

            Optional<User> user = userService.getAuthorized();

            if(user.isPresent()) {
                System.out.println(""+user.get().getEmail()+"map WebControl getMAP ListGeoPoints size:"+user.get().getGeoPoints().size());

                List<GeoPoint> geodao = user.get().getGeoPoints();
                System.out.println(" gettedlist "+geodao.size());

                List<GeoPointDTO> geos = Translator.geoPointsToDTO(geodao);
                System.out.println(" gettedlis to dto "+geos.size());

                modelAndView.addObject("geoPoints", geos);
            }
        }*/
        return modelAndView;
    }

    @RequestMapping(value = WebResolver.MAP, method = RequestMethod.POST)
    public ModelAndView mapUpdate(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAP);
//        modelAndView.addObject("user", userDTO);
        return modelAndView;
    }
}
