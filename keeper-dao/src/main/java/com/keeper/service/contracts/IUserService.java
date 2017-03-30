package com.keeper.service.contracts;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */


import com.keeper.entity.User;

import java.util.List;

/**
 * Default Comment
 */
public interface IUserService {

    /**
     * Creates a new user.
     * @param id   The information of the searching user.
     * @return  result of searching.
     */
    boolean findUser(Long id);
    
    /**
     * Creates a new user.
     * @param user   The information of the created user.
     * @return  The created user.
     */
    User addUser(User user);

    /**
     * Finds user by id.
     * @param id    The id of the wanted user.
     * @return  The found user. If no user is found, this method returns null.
     */
    User getUser(Long id);
    User getUser(User user);
    User getUser(String email, String phone);

    List<User> getAllUsers();

    /**
     * Updates the information of a user.
     * @param user   The information of the updated user.
     * @return  The updated user.
     */
    User updateUser(User user);

    /**
     * Deletes a user.
     * @param user  The deleting user.
     * @return  The deleted user.
     */
    User removeUser(User user);
    void removeUser(Long id);
    void removeUser(String email, String phone);
}
