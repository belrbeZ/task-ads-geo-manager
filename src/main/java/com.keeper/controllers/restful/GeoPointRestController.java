package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.ModelService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class GeoPointRestController {
    protected final Logger LOGGER = LoggerFactory.getLogger(GeoPointRestController.class);

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

    @RequestMapping(value = PATH + "/geoPointList", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> getGeoPointsByEmail() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
            LOGGER.warn("" + user.get().getEmail() + " REST getList byEmail ListGeoPoints size:" + user.get().getGeoPoints().size());

            List<GeoPoint> geodao = user.get().getGeoPoints();
            LOGGER.warn(" gettedlist " + geodao.size());
            return new ResponseEntity<>(Translator.geoPointsToDTO(geodao), HttpStatus.OK);
        } else {
            LOGGER.warn("    REST ERROR of getting list!");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(model.getId()<1) {
            LOGGER.warn("    REST ERROR of updating by id" + model.getId());
            return new ResponseEntity<>("Неправильный ввод!", HttpStatus.NOT_FOUND);
        }

        if(user.isPresent()) {
            model.setUserId(user.get().getId());
            LOGGER.warn("    REST Updating " + model.toString());
            repoService.updateDTO(model);
        } else {
            LOGGER.warn("    REST ERROR of updating " + model.getId());
            return new ResponseEntity<>("Авторизуйтесь!", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Обновлено!", HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            model.setUserId(user.get().getId());
            LOGGER.warn(user.get().getEmail() + " REST Creating Geo " + model.toString());

            repoService.saveDTO(model);
        } else {
            LOGGER.warn("    REST ERROR of creating " + model.getId());
            return new ResponseEntity<>("Авторизуйтесь!", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Добавлено!", HttpStatus.OK);
    }


    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long pointId) {
        LOGGER.warn("    REST Removing point id:" + pointId);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            LOGGER.warn("        "+user.get().getEmail()+" remove from ListGeoPoints size:"+user.get().getGeoPoints().size());

            GeoPoint geoFroDelete = repoService.get(pointId).get();
            LOGGER.warn("    getted for delete:"+geoFroDelete);
            user.get().removeGeoPoint(geoFroDelete);
            userService.save(user.get());

            repoService.remove(pointId);
            LOGGER.warn("        "+user.get().getEmail()+" after remove ListGeoPoints size:"+user.get().getGeoPoints().size());
        }else {
            LOGGER.warn("    REST ERROR of deleting geo " + pointId);
            return new ResponseEntity<>("Авторизуйтесь!", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Место удалено!", HttpStatus.OK);
    }

    @RequestMapping(value = PATH+"/byObj", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  deleteByObj(@Valid GeoPointDTO model) {
        LOGGER.warn("REST Deleting " + model.toString());

        if(model.getId()<1) {
            LOGGER.warn("REST ERROR deleting by obj");
            return  new ResponseEntity<>("Неправильный ввод!", HttpStatus.BAD_REQUEST);
        }

        repoService.remove(model.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
