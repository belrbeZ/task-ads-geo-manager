package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dto.RouteDTO;
import com.keeper.service.impl.RouteRepoService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Default Comment
 */
@RestController
public class RouteRestController {
    private final String PATH = ApiResolver.REST_ROUTE;

    private final RouteRepoService repoService;

    @Autowired
    public RouteRestController(RouteRepoService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RouteDTO>> get(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(Translator.convertRoutesToDTO(repoService.getAllByUserId(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody RouteDTO model, BindingResult result) {
        repoService.update(Translator.convertToDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody RouteDTO model, BindingResult result) {
        repoService.add(Translator.convertToDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long routeId) {
        repoService.remove(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
