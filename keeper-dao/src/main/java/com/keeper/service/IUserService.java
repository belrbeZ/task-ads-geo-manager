package com.keeper.service;

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

    boolean isExist(String email, String phone);

    /**
     * Creates a new user.
     * @param user   The information of the created user.
     * @return  The created user.
     */
    User add(User user);

    /**
     * Finds user by id.
     * @param id    The id of the wanted user.
     * @return  The found user. If no user is found, this method returns null.
     */
    User get(Long id);
    User get(String email, String phone);

    List<User> getAllUsers();

    /**
     * Updates the information of a user.
     * @param user   The information of the updated user.
     * @return  The updated user.
     */
    User update(User user);

    /**
     * Deletes a user.
     * @param user  The deleting user.
     * @return  The deleted user.
     */
    User remove(User user);
    void remove(Long id);
    void remove(String email, String phone);
}
