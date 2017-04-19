package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.UserDTO;
import com.keeper.repo.GeoPointRepository;
import com.keeper.repo.UserRepository;
import com.keeper.service.IUserService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Default Comment
 */
@Service
public class UserRepoService extends ModelRepoService<User> implements IUserService {

    private final UserRepository repository;
    private final GeoPointRepository geoPointRepository;

    @Autowired
    public UserRepoService(UserRepository repository, GeoPointRepository geoPointRepository) {
        this.repository = repository;
        this.primeRepository = repository;
        this.geoPointRepository = geoPointRepository;
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

}
