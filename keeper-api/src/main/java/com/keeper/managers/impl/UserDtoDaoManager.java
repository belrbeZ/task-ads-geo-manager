package com.keeper.managers.impl;

import com.keeper.dto.UserDto;
import com.keeper.entity.User;
import com.keeper.entity.Zone;
import com.keeper.entity.states.UserType;
import com.keeper.managers.ItemNotFoundException;
import com.keeper.managers.IUserDtoManager;
import com.keeper.service.impl.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class UserDtoDaoManager implements IUserDtoManager<User> {

    @Autowired
    private UserRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public User parseDtoToDao(UserDto dtoMode) {
        return null;
    }

    @Override
    public UserDto parseDaoToDto(User daoModel) {
        return null;
    }

    @Override
    public List<User> parseDtoToDao(List<UserDto> dtoModelList) {
        return null;
    }

    @Override
    public List<UserDto> parseDaoToDto(List<User> daoModelList) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Operations">

    @Override
    public boolean isExists(String email, String phone) {
        return false;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User getUser(String email, String phone) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User removeUser(User user) {
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