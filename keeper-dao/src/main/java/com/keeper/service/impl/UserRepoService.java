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
import com.keeper.service.contracts.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Repository to work with User
 */

@Service(value = "userService")
public class UserRepoService implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    @PersistenceContext
    private EntityManager entityManager;

//    private QueryDslJpaRepository<User, Long> userRepository;

    @Resource
//    @Autowired
    private UserRepository userRepo;

    @Transactional(readOnly=true)
//    @Override
    List<User> findAllCustomersWithName(String name){
        return entityManager.createQuery("SELECT c FROM Users c WHERE c.name LIKE :custName")
                .setParameter("custName", name)
                .setMaxResults(10)
                .getResultList();
    }

    //<editor-fold desc="UserCRUD">

    public boolean findUser(Long id){
        return userRepo.findOne(id) != null;
    }

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
