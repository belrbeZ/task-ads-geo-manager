package com.keeper.service.impl;

import com.keeper.entity.User;
import com.keeper.entity.UserTest;
import com.keeper.repo.UserRepository;
import com.keeper.repo.UserTestRepository;
import com.keeper.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Service
public class UserTestRepoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserTestRepository userTestRepository;

    public boolean isExists(String email, String phone) {
        return false;
    }

    public User addUser(UserTest user) {
        return null;
    }

    public User getUser(Long id) {
        return null;
    }

    public User getUser(String email, String phone) {
        return null;
    }

    public List<User> getAllUsers() {
        return null;
    }

    public User updateUser(UserTest user) {
        return null;
    }

    public User removeUser(UserTest user) {
        return null;
    }

    public void removeUser(Long id) {}

    public void removeUser(String email, String phone) {

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
