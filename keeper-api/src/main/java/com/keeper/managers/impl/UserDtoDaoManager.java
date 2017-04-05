package com.keeper.managers.impl;

import com.keeper.entity.dto.UserDTO;
import com.keeper.entity.User;
import com.keeper.managers.IUserDtoManager;
import com.keeper.service.impl.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class UserDtoDaoManager implements IUserDtoManager {

    @Autowired
    private UserRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public User parseDtoToDao(UserDTO dtoMode) {
        return null;
    }

    @Override
    public UserDTO parseDaoToDto(User daoModel) {
        return null;
    }

    @Override
    public List<User> parseDtoToDao(List<UserDTO> dtoModelList) {
        return null;
    }

    @Override
    public List<UserDTO> parseDaoToDto(List<User> daoModelList) {
        return null;
    }
    //</editor-fold>

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