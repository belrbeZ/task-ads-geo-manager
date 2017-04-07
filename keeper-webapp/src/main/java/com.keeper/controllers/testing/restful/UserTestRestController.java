package com.keeper.controllers.testing.restful;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.entity.dao.UserTest;
import com.keeper.entity.dao.ZoneTest;
import com.keeper.entity.dto.UserTestDTO;
import com.keeper.service.impl.UserTestRepoService;
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
 * Is testing RestController to work with UserTest model
 */
@RestController
public class UserTestRestController {

    private static final String path = WebmapResolver.WEB_SECURE
                                        + ApiResolver.API
                                        + ApiResolver.TEST_REST
                                        + ApiResolver.REST_PROFILE;

    private final Map<Long, UserTest> modelMap;

    private final UserTestRepoService repoService;

    @Autowired
    public UserTestRestController(UserTestRepoService repoService) {
        this.repoService = repoService;
        this.modelMap = new HashMap<>();
        UserTest test = Tester.testSampleUserDAO();
        this.modelMap.put(test.getId(), test);
    }

    @RequestMapping(value = path, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTestDTO> get(@RequestParam(value = "id") Long userId) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //return new ResponseEntity<>(Converter.convertToDTO(repoService.get(userId)), HttpStatus.OK);
        return new ResponseEntity<>(Converter.convertToDTO(modelMap.get(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = path, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody UserTest model, BindingResult result) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //repoService.update(model);
        modelMap.replace(model.getId(), model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = path, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody UserTest model, BindingResult result) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //repoService.add(model);
        modelMap.putIfAbsent(model.getId(), model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = path, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long userId) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //repoService.remove(userId);
        modelMap.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
