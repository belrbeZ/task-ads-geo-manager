package com.keeper.managers.contracts;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.dto.UserDto;
import com.keeper.managers.ItemNotFoundException;

import java.util.List;

/**
 * Default Comment
 */
public interface IUserDtoManager<T> extends ModelDtoManager<T,UserDto>{

    /**
     * Creates a new user.
     * @param userDto   The information of the created user.
     * @return  The created user.
     */
    UserDto addUser(UserDto userDto);

    /**
     * Finds user by id.
     * @param id    The id of the wanted user.
     * @return  The found user. If no user is found, this method returns null.
     */
    UserDto getUser(Long id);
    UserDto getUser(UserDto userDto);
    UserDto getUser(String email, String phone);

    List<UserDto> getAllUsers();

    /**
     * Updates the information of a user.
     * @param userDto   The information of the updated user.
     * @return  The updated user.
     * @throws ItemNotFoundException  if no user is found by criteria.
     */
    UserDto updateUser(UserDto userDto) throws ItemNotFoundException;

    /**
     * Deletes a user.
     * @param userDto  The userDto of the deleted user.
     * @return  The deleted user.
     * @throws ItemNotFoundException  if no user is found by criteria.
     */    
    UserDto removeUser(UserDto userDto) throws ItemNotFoundException;
    void removeUser(Long id)  throws ItemNotFoundException;
    void removeUser(String email, String phone) throws ItemNotFoundException;

}
