package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.User;
import com.keeper.model.dto.*;
import com.keeper.repo.GeoPointRepository;
import com.keeper.repo.RouteRepository;
import com.keeper.repo.UserRepository;
import com.keeper.service.IUserService;
import com.keeper.util.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Default Comment
 */
@Service
public class UserService extends ModelRepoService<User> implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    private final UserRepository repository;
    private final GeoPointRepository geoPointRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public UserService(UserRepository repository, GeoPointRepository geoPointRepository, RouteRepository routeRepository) {
        this.repository = repository;
        this.primeRepository = repository;
        this.geoPointRepository = geoPointRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public User getEmpty() {
        return User.EMPTY;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.existsByEmail(email)
                : (phone != null && !phone.isEmpty()) && repository.existsByPhone(phone);
    }

    @Override
    public boolean isUserLoginDataValid(String email, String phone, String password) {
        return (get(email, phone).getPassword().equals(password));
    }

    @Override
    public User get(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.findOneByEmail(email).orElse(getEmpty())
                : (phone != null && !phone.isEmpty()) ? repository.findOneByPhone(phone).orElse(getEmpty()) : getEmpty();
    }

    @Override
    public User remove(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.removeByEmail(email).orElse(getEmpty())
                : (phone != null && !phone.isEmpty()) ? repository.removeByPhone(phone).orElse(getEmpty()) : getEmpty();
    }


    /*---ZONES---*/
    public ZoneDTO getZone(Long userId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        return Translator.convertToDTO(user.getZone());
    }

    public UserDTO createZone(Long userId, ZoneDTO zone) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        user.setZone(Translator.convertToDAO(zone));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }
    /*---END ZONES---*/

    /*---PICTURE---*/
    public PictureDTO getPicture(Long userId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        return Translator.convertToDTO(user.getPic());
    }

    public UserDTO setPicture(Long userId, PictureDTO picture) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        user.setPic(Translator.convertToDAO(picture));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }
    /*---END PICTURE---*/

    /*---GEOPOINTS---*/
    @Override
    public List<GeoPointDTO> getGeoPoints(Long userId) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        return Translator.convertGeoToDTO(user.getGeoPoints());
    }

    @Override
    @Transactional
    public UserDTO addGeoPoint(Long userId, GeoPointDTO geoPoint) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.addGeoPoint(Translator.convertToDAO(geoPoint));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    //This works programmic only! remove check on links.
    @Override
    @Transactional
    public UserDTO removeGeoPoint(Long userId, GeoPointDTO geoPoint) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.removeGeoPoint(Translator.convertToDAO(geoPoint));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    @Override
    @Transactional
    public UserDTO removeGeoPointById(Long userId, Long geoPointId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        GeoPoint geoPoint = geoPointRepository.findOne(geoPointId);
        if(geoPoint==null)
            throw new IllegalArgumentException("No such geoPoint!");
//        if(user.hasGeoPoint(geoPoint)>0)
            user.removeGeoPoint(geoPoint);
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }
    /*---END GEOPOINTS---*/

    /*---ROUTES---*/
    public List<RouteDTO> getRoutes(Long userId) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");

//        System.out.println("User First Route:"+user.getRoutes().get(0).getLongtitudes() [0]+" "+user.getRoutes().get(0).getLatitudes()[0]);

//        LOGGER.debug("User First Route:"+user.getRoutes().get(0).getLongtitudes() [0]+" "+user.getRoutes().get(0).getLatitudes()[0]);

//        List<RouteDTO> routes = Translator.convertRoutesToDTO(user.getRoutes());

//        System.out.println("User First Reversed Route:"+routes.get(0).getPoints().get(0)+" "+routes.get(0).getPoints().get(0));

        return Translator.convertRoutesToDTO(user.getRoutes());
    }

    public UserDTO addRoute(Long userId, RouteDTO route) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.addRoute(Translator.convertToDAO(route));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    public UserDTO removeRoute(Long userId, RouteDTO route) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.removeRoute(Translator.convertToDAO(route));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    public UserDTO removeRouteById(Long userId, Long routeId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        Route route = routeRepository.findOne(routeId);
        if(route==null)
            throw new IllegalArgumentException("No such geoPoint!");
//        if(user.hasGeoPoint(geoPoint)>0)
        user.removeRoute(route);
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }
    /*---END ROUTES---*/
}
