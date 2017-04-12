package com.keeper.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.UserDTO;

import java.util.List;

/**
 * Default Comment
 */
public interface IUserManager extends IModelManager<User, UserDTO> {
    boolean isExists(String email, String phone);

    UserDTO addUser(UserDTO user);

    UserDTO getUser(Long id);
    UserDTO getUser(String email, String phone);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    UserDTO removeUser(UserDTO user);
    void removeUser(Long id);
    void removeUser(String email, String phone);
}
