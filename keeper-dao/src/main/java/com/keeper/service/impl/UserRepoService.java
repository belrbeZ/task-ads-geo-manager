package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.dao.jpahibernate.UserDao;
import com.keeper.dao.jpahibernate.impl.UserDaoImpl_JpaHibernate;
import com.keeper.dao.repo.UserRepository;
import com.keeper.entity.User;
import com.keeper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository to work with User
 */
@Service("userService")
public class UserRepoService implements IUserService {

    private final UserDaoImpl_JpaHibernate userDao;

    private final UserRepository userRepo;

    @Autowired
    public UserRepoService(UserDao userDao, UserRepository userRepo) {
        this.userDao = (UserDaoImpl_JpaHibernate)userDao;
        this.userRepo = userRepo;
    }

    //<editor-fold desc="UserCRUD">

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(Long id) {
        return userRepo.findOne(id);
    }

    public User getUser(User user) {
        return userRepo.findOne(user.getId());
    }

    public User getUser(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? userRepo.findByEmail(email)
                : userRepo.findByPhone(phone);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void removeUser(Long id) {
        userRepo.delete(id);
    }

    public void removeUser(String email, String phone) {
        if(email != null && !email.isEmpty())
            userRepo.deleteByEmail(email);
        else
            userRepo.deleteByPhone(phone);
    }

    public User removeUser(User user) {
        userRepo.delete(user);
        return user;
    }
    //</editor-fold>
}
