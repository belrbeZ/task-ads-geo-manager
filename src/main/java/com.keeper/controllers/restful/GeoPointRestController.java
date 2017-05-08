package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.impl.GeoPointService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Default Comment
 */
@RestController
public class GeoPointRestController {
    private final String PATH = ApiResolver.GEOPOINT;

    private final GeoPointService repoService;

    @Autowired
    public GeoPointRestController(GeoPointService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeoPointDTO> get(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.toDTO(repoService.get(id).orElse(GeoPoint.EMPTY)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        repoService.update(Translator.toDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        repoService.save(Translator.toDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = PATH+"/byRouteId", method = RequestMethod.DELETE)
//    public ResponseEntity<String> deleteByRouteId(@RequestParam("routeId") Long routeId) {
//        repoService.remove(routeId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long routeId) {
        repoService.remove(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
