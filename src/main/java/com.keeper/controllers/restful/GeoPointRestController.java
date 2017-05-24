package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.util.SimpleResponse;
import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.service.modelbased.impl.GeoPointService;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@RestController
public class GeoPointRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRestController.class);

    private final UserService userService;
    private final GeoPointService repoService;

    @Autowired
    public GeoPointRestController(GeoPointService repoService, UserService userService) {
        this.repoService = repoService;
        this.userService = userService;
    }

    @RequestMapping(value = ApiResolver.GEO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> get(@RequestParam("id") Long userId) {
        return new ResponseEntity<>(ModelTranslator.geoPointsToDTO(repoService.getByUserId(userId).get()), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.GEO + "/geoPointList", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoPointDTO>> getGeoPointsByEmail() {
        Optional<User> user = userService.getAuthorized();
        if (user.isPresent()) {
//            LOGGER.debug("" + user.get().getEmail() + " REST getList byEmail ListGeoPoints size:" + user.get().getGeoPoints().size());

//            List<GeoPoint> geodao = user.get().getGeoPoints();
            List<GeoPoint> geodao = repoService.getByUserId(user.get().getId()).get();

            LOGGER.debug("{}: Rest getting list of geoPoints {}", Thread.currentThread().getName(), geodao.size());
            return new ResponseEntity<>(ModelTranslator.geoPointsToDTO(geodao), HttpStatus.OK);
        } else {
            LOGGER.debug("{}: Rest ERROR of getting list of geoPoints.",Thread.currentThread().getName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = ApiResolver.GEO, method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> update(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(model.getId()<1) {
            LOGGER.debug("{}: Rest ERROR of updating by id: {}",Thread.currentThread().getName(), model.getId());
            return new ResponseEntity<>(new SimpleResponse("Неправильный ввод!"), HttpStatus.NOT_FOUND);
        }

        if(user.isPresent()) {
            model.setUserId(user.get().getId());
            LOGGER.debug("{}: Rest Updating {}",Thread.currentThread().getName(), model.toString());
            repoService.updateDTO(model);
        } else {
            LOGGER.debug("{}: Rest ERROR of updating {}",Thread.currentThread().getName(),model.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new SimpleResponse("Место обновлено!"), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.GEO, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse> create(@Valid @RequestBody GeoPointDTO model, BindingResult result) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
            model.setUserId(user.get().getId());
            LOGGER.debug("{}: Rest Creating Geo by {} : {}",Thread.currentThread().getName(),user.get().getEmail(), model.toString());

            repoService.saveDTO(model);
        } else {
            LOGGER.debug("{}: Rest ERROR of creating geo {}" ,Thread.currentThread().getName(), model.getId());
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Место добавлено!"), HttpStatus.OK);
    }


    @RequestMapping(value = ApiResolver.GEO, method = RequestMethod.DELETE)
    public ResponseEntity<SimpleResponse> delete(@RequestParam("id") Long pointId) {
        LOGGER.debug("{}: Rest Removing point id: {}" ,Thread.currentThread().getName(), pointId);

        Optional<User> user = userService.getAuthorized();

        if(user.isPresent()) {
//            LOGGER.debug("        "+user.get().getEmail()+" remove from ListGeoPoints size:"+user.get().getGeoPoints().size());

//            GeoPoint geoFroDelete = repoService.get(pointId).get();
//            LOGGER.debug("    getted for delete:"+geoFroDelete);
//            user.get().removeGeoPoint(geoFroDelete);
//            userService.save(user.get());

            repoService.remove(pointId);
//            repoService.removeByObj(geoFroDelete, user.get());
//            LOGGER.debug("        "+user.get().getEmail()+" after remove ListGeoPoints size:"+user.get().getGeoPoints().size());
        }else {
            LOGGER.debug("{}: Rest ERROR of deleting geo {}",Thread.currentThread().getName(), pointId);
            return new ResponseEntity<>(new SimpleResponse("Авторизуйтесь!"), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new SimpleResponse("Место удалено!"), HttpStatus.OK);
    }

    /*@RequestMapping(value = PATH+"/byObj", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponse>  deleteByObj(@Valid GeoPointDTO model) {
        LOGGER.debug("REST Deleting " + model.toString());

        if(model.getId()<1) {
            LOGGER.debug("REST ERROR deleting by obj");
            return  new ResponseEntity<>(new SimpleResponse("Неправильный ввод!"), HttpStatus.BAD_REQUEST);
        }

        repoService.remove(model.getId());

        return new ResponseEntity<>(new SimpleResponse("Место удалено!"),HttpStatus.OK);
    }*/
}
