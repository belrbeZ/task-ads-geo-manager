package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;
import com.keeper.service.impl.RouteService;
import com.keeper.util.Translator;
import com.keeper.util.web.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    private final String PATH = ApiResolver.REST_ROUTE;

    private final RouteService repoService;

    @Autowired
    public RouteRestController(RouteService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = PATH+"/byUserId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RouteDTO>> getByUserId(@RequestParam("id") Long userId) {
        List<Route> routes = repoService.getAllByUserId(userId);

//        System.out.println("User First Route:"+routes.get(0).getLongtitudes() [0]+" "+routes.get(0).getLatitudes()[0]);
//        LOGGER.debug("User First Route:"+routes.get(0).getLongtitudes() [0]+" "+routes.get(0).getLatitudes()[0]);

        return new ResponseEntity<>(Translator.convertRoutesToDTO(routes), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouteDTO> get(@RequestParam("id") Long id) {
        return new ResponseEntity<>(Translator.convertToDTO(repoService.get(id)), HttpStatus.OK);
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
    public ResponseEntity<String> delete(@RequestParam("id") Long routeId) {
        repoService.remove(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
