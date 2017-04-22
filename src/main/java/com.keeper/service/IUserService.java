package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.UserDTO;

import java.util.List;

/**
 * Default Comment
 */
public interface IUserService extends IModelService<User> {
    boolean isExists(String email, String phone);

    boolean isExistsByEmail(String email);

    boolean isUserLoginDataValid(String email, String phone, String password);

    User get(String email, String phone);

    User getByEmail(String email);

    User remove(String email, String phone);


    /*GEOPOINTS*/
    List<GeoPointDTO> getGeoPoints(Long userId);

    UserDTO addGeoPoint(Long id, GeoPointDTO geoPoint);

    UserDTO removeGeoPoint(Long userId, GeoPointDTO geoPoint);

    UserDTO removeGeoPointById(Long userId, Long geoPointId);

}
