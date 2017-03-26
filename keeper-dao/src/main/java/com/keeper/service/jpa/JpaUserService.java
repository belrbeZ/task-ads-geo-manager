package com.keeper.service.jpa;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.dao.springrepo.UserRepository;
import com.keeper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by AlexVasil on 26.03.2017.
 *
 * Repository to work with User with JPA
 */

@Service("jpaUserService")
@Transactional
public class JpaUserService  {

    //    @Autowired
    @Autowired(required = false) // set to false to remove conflicts with other configurations
    private EntityManagerFactory entityManagerFactory;


    @Transactional
    public void printUsers() {
        List<User> locations = entityManagerFactory.createEntityManager().createQuery("select p from Users p").getResultList();
        for (User location : locations) {
            System.out.println(location);
        }
    }


    @Autowired(required = false)
    private UserRepository userRepository;

    @Transactional
    public void printUsersStartingWith(String start) {
        for (User user : userRepository.findByIdStartingWith(start)) {
            System.out.println(user);
        }
    }

}
