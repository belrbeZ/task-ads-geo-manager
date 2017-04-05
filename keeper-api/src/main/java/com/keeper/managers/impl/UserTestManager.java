package com.keeper.managers.impl;

import com.keeper.entity.UserTest;
import com.keeper.entity.UserTest;
import com.keeper.entity.dto.UserDTO;
import com.keeper.service.impl.UserRepoService;
import com.keeper.service.impl.UserTestRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */
@Service
public class UserTestManager {

    @Autowired
    private UserTestRepoService userTestRepoService;

    //<editor-fold desc="Dao&Dto">

    public UserTest parseDtoToDao(UserDTO dtoMode) {
        return null;
    }

    public UserDTO parseDaoToDto(UserTest daoModel) {
        return null;
    }

    public List<UserTest> parseDtoToDao(List<UserDTO> dtoModelList) {
        return null;
    }

    public List<UserDTO> parseDaoToDto(List<UserTest> daoModelList) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Operations">

    public boolean isExists(String email, String phone) {
        return false;
    }

    public UserDTO addUser(UserDTO user) {
        return null;
    }

    public UserDTO getUser(Long id) {
        return null;
    }

    public UserDTO getUser(String email, String phone) {
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return null;
    }

    public UserDTO updateUser(UserDTO user) {
        return null;
    }

    public UserDTO removeUser(UserDTO user) {
        return null;
    }

    public void removeUser(Long id) {

    }

    public void removeUser(String email, String phone) {

    }

}
