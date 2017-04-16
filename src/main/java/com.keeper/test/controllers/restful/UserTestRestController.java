package com.keeper.test.controllers.restful;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.test.model.dao.UserTest;
import com.keeper.test.model.dto.UserTestDTO;
import com.keeper.test.service.impl.UserTestRepoService;
import com.keeper.util.Tester;
import com.keeper.util.Translator;
import com.keeper.util.web.ApiResolver;
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
    private final String PATH = ApiResolver.TEST_REST_PROFILE;

    // Used for testing, so we won't need to go to DB
    private final Map<Long, UserTest> modelMap = new HashMap<>();

    private long ID_COUNTED = 1;

    private final UserTestRepoService repoService;

    @Autowired
    public UserTestRestController(UserTestRepoService repoService) {
        this.repoService = repoService;
        UserTest test = Tester.testSampleUserDAO();
        this.modelMap.put(test.getId(), test);
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTestDTO> get(@RequestParam(value = "id") Long userId) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //return new ResponseEntity<>(Converter.convertToDTO(repoService.get(userId)), HttpStatus.OK);
        return new ResponseEntity<>(Translator.convertToDTO(modelMap.get(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody UserTest model, BindingResult result) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //repoService.update(model);
        modelMap.replace(model.getId(), model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody UserTest model, BindingResult result) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //repoService.add(model);
        model.setId(++ID_COUNTED);
        modelMap.putIfAbsent(model.getId(), model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long userId) {
        // REAL IMPLEMENTATION THAT WORKS WITH DB
        //repoService.remove(userId);
        modelMap.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
