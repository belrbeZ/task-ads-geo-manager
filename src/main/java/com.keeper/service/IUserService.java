package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IUserService extends IModelService<User> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    Optional<User> getByEmail(String email);
    Optional<User> getByPhone(String phone);

    Optional<User> removeByEmail(String email);
    Optional<User> removeByPhone(String phone);


    /*GEOPOINTS*/
    List<GeoPointDTO> getGeoPoints(Long userId);

    UserDTO addGeoPoint(Long id, GeoPointDTO geoPoint);

    UserDTO removeGeoPoint(Long userId, GeoPointDTO geoPoint);

    UserDTO removeGeoPointById(Long userId, Long geoPointId);

}
