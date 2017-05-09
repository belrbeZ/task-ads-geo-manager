package com.keeper.controllers.web;

import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.TemplateResolver;
import com.keeper.util.resolve.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by AlexVasil on 02.05.2017.
 *
 * @author AlexVasil
 */
@Controller
public class GeoPointWebController {

    private final UserService userService;
    private final GeoPointService geoPointService;

    @Autowired
    public GeoPointWebController(GeoPointService geoPointService, UserService userService) {
        this.geoPointService = geoPointService;
        this.userService = userService;
    }

    @RequestMapping(value = WebResolver.GEOPOINT_GETLIST, method = RequestMethod.GET)
    public String geoPointGetList(Model model) {

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {

            System.out.println(""+user.get().getEmail()+"ListGeoPoints size:"+user.get().getGeoPoints().size());

            model.addAttribute("geoPoints", Translator.geoPointsToDTO(user.get().getGeoPoints()));

        }

        return "fragments/geopointlist :: geopointlist";
    }

    @RequestMapping(value = WebResolver.GEOPOINT_CREATE, method = RequestMethod.POST)
    public ModelAndView geoPointCreateForm(GeoPointDTO geoPointDTO, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAP);

        Optional<User> user = userService.getAuthorized();

        System.out.println(geoPointDTO.getRadius());

        if(user.isPresent()) {
            geoPointDTO.setUserId(user.get().getId());
            geoPointService.saveDTO(geoPointDTO);

//            userService.addGeoPoint(user.getId(), geoPointDTO);
            // БЫЛО, то что не закомменчено стало т.к. теперь GeoPointService & and should save geoPoints via GeoPointService, not UserService

            modelAndView.addObject("geoPoint", geoPointDTO);
        } else
            modelAndView.addObject("errorMessage", "Session is expired!");

        return modelAndView;
    }

    @RequestMapping(value = WebResolver.GEOPOINT_REMOVE, method = RequestMethod.DELETE)
    public String geoPointRemoveForm(@RequestParam(value = "id", required = false) Long geoPointId, Model model) {

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            System.out.println(""+user.get().getEmail()+"ListGeoPoints size:"+user.get().getGeoPoints().size());
            geoPointService.remove(geoPointId);
            System.out.println(""+user.get().getEmail()+"ListGeoPoints size:"+user.get().getGeoPoints().size());
        }

        return "Removed!";
    }

    @RequestMapping(value = WebResolver.GEOPOINT_UPDATE, method = RequestMethod.PATCH)
    public String geoPointUpdateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAP);

        return "updated";
    }


}
