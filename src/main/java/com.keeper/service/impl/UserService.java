package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.*;
import com.keeper.repo.GeoPointRepository;
import com.keeper.repo.RouteRepository;
import com.keeper.repo.TaskRepository;
import com.keeper.repo.UserRepository;
import com.keeper.service.IUserService;
import com.keeper.util.Translator;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Default Comment
 */
@Service
public class UserService extends ModelRepoService<User> implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    private final UserRepository repository;
    private final GeoPointRepository geoPointRepository;
    private final RouteRepository routeRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserService(UserRepository repository, GeoPointRepository geoPointRepository, RouteRepository routeRepository, TaskRepository taskRepository) {
        this.repository = repository;
        this.primeRepository = repository;
        this.geoPointRepository = geoPointRepository;
        this.routeRepository = routeRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public User getEmpty() {
        return User.EMPTY;
    }

    @Override
    public boolean existsByEmail(@NotEmpty String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(@NotEmpty String phone) {
        return repository.existsByPhone(phone);
    }

    @Override
    public Optional<User> getByEmail(@NotEmpty String email) {
        return repository.findOneByEmail(email);
    }

    @Override
    public Optional<User> getByPhone(@NotEmpty String phone) {
        return repository.findOneByPhone(phone);
    }

    @Transactional
    @Override
    public Optional<User> removeByEmail(@NotEmpty String email) {
        return repository.removeByEmail(email);
    }

    @Transactional
    @Override
    public Optional<User> removeByPhone(@NotEmpty String phone) {
        return repository.removeByPhone(phone);
    }

    /*---ZONES---*/
    @Override
    public ZoneDTO getZone(Long userId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        return Translator.convertToDTO(user.getZone());
    }

    @Override
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
    @Override
    public PictureDTO getPicture(Long userId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        return Translator.convertToDTO(user.getPic());
    }

    @Override
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
    public UserDTO removeGeoPoint(Long userId, GeoPointDTO geoPoint) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.removeGeoPoint(Translator.convertToDAO(geoPoint));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    @Override
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
    @Override
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

    @Override
    public UserDTO addRoute(Long userId, RouteDTO route) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        Route routeDao = Translator.convertToDAO(route);
        routeDao.setUserId(user.getId());
        user.addRoute(routeDao);
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    @Override
    public UserDTO removeRoute(Long userId, RouteDTO route) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.removeRoute(Translator.convertToDAO(route));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    @Override
    public UserDTO removeRouteById(Long userId, Long routeId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        Route route = routeRepository.findOne(routeId);
        if(route==null)
            throw new IllegalArgumentException("No such route!");
//        if(user.hasGeoPoint(geoPoint)>0)
        user.removeRoute(route);
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }
    /*---END ROUTES---*/

    /*---PARTICIPANTED TASKS---*/
    /*@Override
    public List<TaskDTO> getParticipantedTasks(Long userId) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        return Translator.convertTasksToDTO(user.getParticipantedTasks());
    }

    @Override
    public UserDTO addParticipantedTask(Long userId, TaskDTO task) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.addParticipantedTask(Translator.convertToDAO(task));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    //This works programmic only! remove check on links.
    @Override
    public UserDTO removeParticipantedTask(Long userId, TaskDTO task) {
        User user;
        if((user = repository.findOne(userId))==null)
            throw new IllegalArgumentException("No such user!");
        user.removeParticipantedTask(Translator.convertToDAO(task));
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }

    @Override
    public UserDTO removeParticipantedTaskById(Long userId, Long taskId) {
        User user = repository.findOne(userId);
        if((user)==null)
            throw new IllegalArgumentException("No such user!");
        Task task = taskRepository.findOne(taskId);
        if(task==null)
            throw new IllegalArgumentException("No such task!");
//        if(user.hasGeoPoint(geoPoint)>0)
        user.removeParticipantedTask(task);
        primeRepository.save(user);
        return Translator.convertToDTO(user);
    }*/
    /*---END PARTICIPANTED TASKS---*/
}
