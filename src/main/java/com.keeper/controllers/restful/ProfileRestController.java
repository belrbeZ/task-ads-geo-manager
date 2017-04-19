package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.UserDTO;
import com.keeper.service.impl.UserRepoService;
import com.keeper.util.Translator;
import com.keeper.util.annotations.GeoCoordinate;
import com.keeper.util.web.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Control Profile Rest End points
 */
@RestController
public class ProfileRestController {
    private final String PATH = ApiResolver.REST_PROFILE;

    private final UserRepoService repoService;

    @Autowired
    public ProfileRestController(UserRepoService repoService) {
        this.repoService = repoService;
    }


    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> get(@RequestParam(value = "id") Long userId) {
        return new ResponseEntity<>(Translator.convertToDTO(repoService.get(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody UserDTO model, BindingResult result) {
        repoService.update(Translator.convertToDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody UserDTO model, BindingResult result) {
        repoService.add(Translator.convertToDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //value = "/user/{id}", method = RequestMethod.PUT

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long userId) {
        repoService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*---GEOPOINTS---*/
    @RequestMapping(value = PATH + "/geoPoints/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> getGeoPoints(@PathVariable("userId") Long userId) {
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(repoService.getGeoPoints(userId), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/geoPoint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> addGeoPoint(@RequestParam("id") Long id, @Valid @RequestBody  GeoPointDTO geoPoint, BindingResult result) {
        return new ResponseEntity<>(repoService.addGeoPoint(id, geoPoint), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/geoPoint/byObj", method = RequestMethod.DELETE)
    public ResponseEntity<UserDTO> removeGeoPoint(@RequestParam("userId") Long userId, @Valid @RequestBody GeoPointDTO geoPoint) {
        return new ResponseEntity<>(repoService.removeGeoPoint(userId, geoPoint), HttpStatus.OK);
    }

    @RequestMapping(value = PATH + "/geoPoint", method = RequestMethod.DELETE)
    public ResponseEntity<UserDTO> removeGeoPoint(@RequestParam("userId") Long userId, @RequestParam("geoPointId") Long geoPointId) {
        return new ResponseEntity<>(repoService.removeGeoPointById(userId, geoPointId), HttpStatus.OK);
    }
}
