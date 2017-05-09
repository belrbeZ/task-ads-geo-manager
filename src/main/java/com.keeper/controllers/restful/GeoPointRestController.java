package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Default Comment
 */
public class GeoPointRestController {

    private final String PATH = ApiResolver.GEO;

    private final GeoPointService repoService;

    @Autowired
    public GeoPointRestController(GeoPointService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> get(@RequestParam("id") Long userId) {
        return new ResponseEntity<>(Translator.geoPointsToDTO(repoService .getByUserId(userId).get()), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        repoService.updateDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        repoService.saveDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long pointId) {
        repoService.remove(pointId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
