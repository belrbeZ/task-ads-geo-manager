package com.keeper.managers.impl;

import com.keeper.entity.UserTest;
import com.keeper.entity.UserTest;
import com.keeper.entity.dto.UserTestDTO;
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

    public UserTest parseDtoToDao(UserTestDTO dtoMode) {
        return null;
    }

    public UserTestDTO parseDaoToDto(UserTest daoModel) {
        return null;
    }

    public List<UserTest> parseDtoToDao(List<UserTestDTO> dtoModelList) {
        return null;
    }

    public List<UserTestDTO> parseDaoToDto(List<UserTest> daoModelList) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Operations">

    public boolean isExists(String email, String phone) {
        return false;
    }

    public UserTestDTO addUser(UserTestDTO user) {
        return null;
    }

    public UserTestDTO getUser(Long id) {
        return null;
    }

    public UserTestDTO getUser(String email, String phone) {
        return null;
    }

    public List<UserTestDTO> getAllUsers() {
        return null;
    }

    public UserTestDTO updateUser(UserTestDTO user) {
        return null;
    }

    public UserTestDTO removeUser(UserTestDTO user) {
        return null;
    }

    public void removeUser(Long id) {

    }

    public void removeUser(String email, String phone) {

    }

}
