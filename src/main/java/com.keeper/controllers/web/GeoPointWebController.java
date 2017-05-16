package com.keeper.controllers.web;

import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.TemplateResolver;
import com.keeper.util.resolvers.WebResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
            model.addAttribute("geoPoints", ModelTranslator.geoPointsToDTO(user.get().getGeoPoints()));
        }

        return "fragments/geopointlist :: geopointlist";
    }

    @RequestMapping(value = WebResolver.GEOPOINT_CREATE, method = RequestMethod.POST)
    public ModelAndView geoPointCreateForm(@Valid GeoPointDTO geoPointDTO, Model model) {
        ModelAndView modelAndView = new ModelAndView(TemplateResolver.MAP);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            System.out.println(user.get().getEmail() + " Web Creating " + geoPointDTO.toString());

            geoPointDTO.setUserId(user.get().getId());
            geoPointService.saveDTO(geoPointDTO);
            modelAndView.addObject("geoPoint", geoPointDTO);
        } else
            modelAndView.addObject("errorMessage", "Session is expired!");

        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = WebResolver.GEOPOINT_REMOVE, method = RequestMethod.DELETE)
    public String geoPointRemoveForm(@RequestParam(value = "id", required = false) String geoPointId, Model model) {
        System.out.println(" Web Removing point id:" + geoPointId);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            System.out.println(""+user.get().getEmail()+" remove from ListGeoPoints size:"+user.get().getGeoPoints().size());

//            GeoPoint geoFroDelete = geoPointService.get(Long.parseLong(geoPointId)).get();
//            System.out.println("    getted for delete:"+geoFroDelete);
//            user.get().removeGeoPoint(geoFroDelete);
//            userService.save(user.get());

            geoPointService.remove(Long.parseLong(geoPointId));
            System.out.println(""+user.get().getEmail()+" after remove ListGeoPoints size:"+user.get().getGeoPoints().size());
        }

        return "fragments/ajaxrequest :: info-success";
    }

    @RequestMapping(value = WebResolver.GEOPOINT_REMOVE+"/byObj", method = RequestMethod.DELETE)
    public String deleteByObj(@Valid GeoPointDTO geo, BindingResult result, Model model) {
        System.out.println("Web Deleting " + geo.toString());

        // if any errors, re-render the user info edit form
        if (result.hasErrors()) {
            System.out.println("ERROR in deleting geo by id" + geo.getId());
            return "fragments/user :: info-error";
        }

        if (geo.getId() < 1) {
            System.out.println("ERROR in deleting geo by id" + geo.getId());
            return "fragments/ajaxrequest :: info-error";
        }

        Optional<User> user = userService.getAuthorized();

        if (user.isPresent()) {
            System.out.println("" + user.get().getEmail() + " remove from ListGeoPoints size:" + user.get().getGeoPoints().size());
//        user.get().removeGeoPoint(geoPointService.get(geo.getId()).get());
            geoPointService.remove(geo.getId());
            System.out.println("" + user.get().getEmail() + " after remove ListGeoPoints size:" + user.get().getGeoPoints().size());
        }

        return "fragments/ajaxrequest :: info-success";
    }

    @RequestMapping(value = WebResolver.GEOPOINT_UPDATE, method = RequestMethod.PATCH)
    public String geoPointUpdateForm(@Valid GeoPointDTO geo, BindingResult result, Model model) {
        Optional<User> user = userService.getAuthorized();

        if(geo.getId()<1) {
            System.out.println("Error of Web updating by id"+geo.getId());
            return "fragments/ajaxrequest :: info-error";
        }

        if(user.isPresent()) {
            System.out.println(user.get().getEmail() + " Web Updating " + geo.toString());
            geo.setUserId(user.get().getId());
            geoPointService.updateDTO(geo);
        }

        return "fragments/ajaxrequest :: info-success";
    }
}
