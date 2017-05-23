package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dao.User;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.util.SimpleGeoPoint;
import com.keeper.model.util.SimpleResponse;
import com.keeper.service.modelbased.impl.RouteService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.ApiResolver;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@RestController
public class RouteRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteRestController.class);

    private final RouteService repoService;
    private final UserService userService;

    @Autowired
    public RouteRestController(RouteService repoService, UserService userService) {
        this.repoService = repoService;
        this.userService = userService;
    }

    @RequestMapping(value = ApiResolver.ROUTE + "/routesList", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RouteDTO>> getByEmail() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            LOGGER.info("Rest getting list of routes");
            Optional<List<Route>> routes = repoService.getByUserId(user.get().getId());
            if(routes.isPresent())
                return new ResponseEntity<>(ModelTranslator.routesToDTO(routes.get()), HttpStatus.OK);
            else
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
        } else {
            LOGGER.warn("REST ERROR of getting list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouteDTO> get(@RequestParam(value = "id", required = false) Long id,
                                        @RequestParam(value = "userId", required = false) Long userId) {
        return new ResponseEntity<>(ModelTranslator.toDTO(repoService.get(id).orElse(Route.EMPTY)), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> update(@Valid @RequestBody RouteDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            model.setUserId(user.get().getId());
            LOGGER.info("Rest updating route "+user.get().getEmail() + " modelId:" + model.toString());

            repoService.updateDTO(model);
        } else {
            LOGGER.warn("Rest ERROR of updating route " + model.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Маршрут обновлен!"), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> create(@Valid @RequestBody RouteDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            model.setUserId(user.get().getId());
            LOGGER.info("Rest updating route "+user.get().getEmail() + " modelId:" + model.toString());

            repoService.saveDTO(model);
        } else {
            LOGGER.warn("Rest ERROR of updating route " + model.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Маршрут сохранен!"), HttpStatus.OK);
    }

//    @RequestMapping(value = ApiResolver.ROUTE+"/list", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<SimpleResponse> createByList(@Valid @RequestBody List<SimpleGeoPoint> listOfPoints, BindingResult result) {
//        Optional<User> user = userService.getAuthorized();
//
//        RouteDTO routeModel = new RouteDTO();
//
//        if(user.isPresent()) {
//            routeModel.setUserId(user.get().getId());
//            LOGGER.info(user.get().getEmail() + " REST Creating ROUTE " + routeModel.toString());
//
//            routeModel.setPoints(listOfPoints);
//
//            repoService.saveDTO(routeModel);
//        } else {
//            LOGGER.warn("    REST ERROR of creating TASK " + routeModel.getId());
//            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
//        }
//        return new ResponseEntity<>(new SimpleResponse("Маршрут добавлен!"), HttpStatus.OK);
//    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> delete(@RequestParam("id") Long routeId) {

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            LOGGER.info("Rest deleting route "+user.get().getEmail() + " modelId:" + routeId);

            repoService.remove(routeId);
        } else {
            LOGGER.warn("Rest ERROR of deleting route " + routeId);
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Маршрут удален."), HttpStatus.OK);
    }
}
