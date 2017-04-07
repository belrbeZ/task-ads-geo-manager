package com.keeper.controllers.testing.restful;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.entity.dao.ZoneTest;
import com.keeper.entity.dto.ZoneTestDTO;
import com.keeper.service.impl.ZoneTestRepoService;
import com.keeper.util.Converter;
import com.keeper.util.Tester;
import com.keeper.util.web.ApiResolver;
import com.keeper.util.web.WebmapResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Is testing RestController to work with ZoneTest model
 */
@RestController
public class ZoneTestRestController {

    private static final String path = WebmapResolver.WEB_SECURE
                                        + ApiResolver.API
                                        + ApiResolver.TEST_REST
                                        + ApiResolver.REST_ZONE;

    private final ZoneTestRepoService repoService;

    private final Map<Long, ZoneTest> modelMap;

    @Autowired
    public ZoneTestRestController(ZoneTestRepoService repoService) {
        this.repoService = repoService;
        this.modelMap = new HashMap<>();
        ZoneTest test = Tester.testSampleZoneDAO();
        this.modelMap.put(test.getUserId(), test);
    }

    @RequestMapping(value = path, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZoneTestDTO> get(@PathVariable("id") Long userId) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        // return new ResponseEntity<>(Converter.convertToDTO(repoService.get(userId)), HttpStatus.OK);
        return new ResponseEntity<>(Converter.convertToDTO(modelMap.get(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = path, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody ZoneTest model, BindingResult result) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        // repoService.update(model);
        modelMap.replace(model.getUserId(), model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = path, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody ZoneTest model, BindingResult result) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        // repoService.add(model);
        modelMap.putIfAbsent(model.getUserId(), model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = path, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long userId) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        // repoService.remove(userId);
        modelMap.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
