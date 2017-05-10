package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@RestController
public class GeoPointRestController {

    private final String PATH = ApiResolver.GEO;

    private final UserService userService;
    private final GeoPointService repoService;

    @Autowired
    public GeoPointRestController(GeoPointService repoService, UserService userService) {
        this.repoService = repoService;
        this.userService = userService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> get(@RequestParam("id") Long userId) {
        return new ResponseEntity<>(Translator.geoPointsToDTO(repoService.getByUserId(userId).get()), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/geoPointList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> getGeoPointsByEmail() {
        Optional<User> user = userService.getAuthorized();
        if(user.isPresent()) {
            System.out.print(""+user.get().getEmail()+" Rest getList byE,ail ListGeoPoints size:"+user.get().getGeoPoints().size());
        }
        List<GeoPoint> geodao = user.get().getGeoPoints();
        System.out.println(" gettedlist "+geodao.size());
        List<GeoPointDTO> geos = Translator.geoPointsToDTO(geodao);
        System.out.println(" gettedlis to dto "+geos.size());
        return new ResponseEntity<>(geos, HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid GeoPointDTO model, BindingResult result) {
        System.out.println("Updating " + model.toString());

        repoService.updateDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid GeoPointDTO model, BindingResult result) {
        repoService.saveDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH+"/byEmail", method = RequestMethod.POST)
    public ResponseEntity<String> createByEmail(@Valid GeoPointDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();
        if(user.isPresent()) {
            System.out.println(""+user.get().getEmail()+" create Rest byEmail ListGeoPoints size:"+user.get().getGeoPoints().size());
            model.setUserId(user.get().getId());
            System.out.println(user.get().getEmail() + " Creating " + model.toString());
            repoService.saveDTO(model);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long pointId) {
        repoService.remove(pointId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH+"/byObj", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  deleteByObj(@Valid GeoPointDTO model) {
        System.out.println("Rest Deleting " + model.toString());

        if(model.getId()==0)
            return  new ResponseEntity<>(HttpStatus.OK);

        repoService.remove(model.getId());
        return new ResponseEntity<>(HttpStatus.OK);
//        return "deleted";
    }
}
