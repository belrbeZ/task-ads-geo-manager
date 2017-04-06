package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.User;
import com.keeper.repo.UserRepository;
import com.keeper.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to work with User
 */

//@Service(value = "userService")
public class UserRepoService implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

//    @Autowired
//    private UserRepository repository;

    @Override
    public boolean isExist(String email, String phone) {
        return false;
    }

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User get(String email, String phone) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User remove(User user) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void remove(String email, String phone) {

    }

//    /**
//     * An initialization method which is run after the bean has been constructed.
//     * This ensures that the entity manager is injected before we try to use it.
//     */
//    @PostConstruct
//    public void init() {
//        JpaEntityInformation<User, Long> userEntityInfo = new JpaMetamodelEntityInformation<>(User.class, entityManager.getMetamodel());
//        userRepository = new QueryDslJpaRepository<>(userEntityInfo, entityManager);
//    }
//
//    /**
//     * This setter method should be used only by unit tests
//     * @param userRepository
//     */
//    protected void setPersonRepository(QueryDslJpaRepository<User, Long> userRepository) {
//        this.userRepository = userRepository;
//    }

    public void test(){
        System.out.println("UserRepoService");
    }
}
