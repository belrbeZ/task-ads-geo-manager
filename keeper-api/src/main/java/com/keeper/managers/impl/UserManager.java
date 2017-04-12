package com.keeper.managers.impl;

import com.keeper.model.dto.UserDTO;
import com.keeper.managers.IUserManager;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

//@Service
public class UserManager implements IUserManager {

//    @Autowired
//    private UserRepoService repoService;

    //<editor-fold desc="Operations">

    @Override
    public boolean isExists(String email, String phone) {
        return false;
    }

    @Override
    public UserDTO addUser(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO getUser(Long id) {
        return null;
    }

    @Override
    public UserDTO getUser(String email, String phone) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO removeUser(UserDTO user) {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }

    @Override
    public void removeUser(String email, String phone) {

    }


    //</editor-fold>
}