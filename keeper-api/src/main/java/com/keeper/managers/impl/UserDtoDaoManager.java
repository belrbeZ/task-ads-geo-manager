package com.keeper.managers.impl;

import com.keeper.dto.UserDto;
import com.keeper.entity.User;
import com.keeper.entity.Zone;
import com.keeper.entity.states.UserType;
import com.keeper.managers.ItemNotFoundException;
import com.keeper.managers.contracts.IUserDtoManager;
import com.keeper.service.impl.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private UserRepoService userRepoService;

//    @Autowired
//    public UserDtoDaoManager() {
//        this.userRepoService = new UserRepoService();
//    }


    //<editor-fold desc="UserCRUD">


    public UserDto addUser(UserDto user) {
        return parseDaoToDto(userRepoService.addUser(parseDtoToDao(user)));
    }

    public UserDto getUser(Long id) {
        return parseDaoToDto(userRepoService.getUser(id));
    }

    public UserDto getUser(UserDto user) {
        return parseDaoToDto(userRepoService.getUser(user.getId()));
    }

    public UserDto getUser(String email, String phone) {
        return parseDaoToDto(userRepoService.getUser(email,phone));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> tmpUserList = userRepoService.getAllUsers();
        List<UserDto> returnUserDtoList = new LinkedList<>();
        for (User tmpUser :
                tmpUserList) {
            returnUserDtoList.add(parseDaoToDto(tmpUser));
        }
        return returnUserDtoList;
    }

    public UserDto updateUser(UserDto user) throws ItemNotFoundException {
        User updatedUser = userRepoService.updateUser(parseDtoToDao(user));
        if(updatedUser == null){
            throw new ItemNotFoundException();
        }
        return parseDaoToDto(updatedUser);
    }

    public void removeUser(Long id) throws ItemNotFoundException {
        if(userRepoService.findUser(id))
            userRepoService.removeUser(id);
        else
            throw new ItemNotFoundException();
    }

    public void removeUser(String email, String phone)  {
        userRepoService.removeUser(email, phone);
    }

    public UserDto removeUser(UserDto user) {
        return parseDaoToDto(userRepoService.removeUser(parseDtoToDao(user)));
    }
    //</editor-fold>


    @Override
    public User parseDtoToDao(UserDto userDto) {
        User user = new User(UserType.USER, "name", "email", "phone", "password", "about", new Zone(222L, "city", "country"));

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());

        return user;
    }

    private List<UserDto> constructDTOs(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();

        for (User user: users) {
            UserDto dto = parseDaoToDto(user);
            dtos.add(dto);
        }

        return dtos;
    }

    private List<User> constructDAOs(List<UserDto> users) {
        List<User> daos = new ArrayList<>();

        for (UserDto user: users) {
            User dto = parseDtoToDao(user);
            daos.add(dto);
        }

        return daos;
    }

    @Override
    public UserDto parseDaoToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

    public void test(){
        System.out.println("UserDtoDaoManager");
        userRepoService.test();
    }
}