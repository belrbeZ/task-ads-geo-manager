package com.keeper.service.impl;

import com.keeper.entity.dao.UserTest;
import com.keeper.repo.UserTestRepository;
import com.keeper.service.IUserTestService;
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
public class UserTestRepoService implements IUserTestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserTestRepoService.class);

    @Autowired
    private UserTestRepository repository;

    @Override
    public boolean isExists(Long id) {
        return false;
    }

    @Override
    public UserTest add(UserTest model) {
        return null;
    }

    @Override
    public UserTest get(Long id) {
        return null;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return false;
    }

    @Override
    public List<UserTest> getAll() {
        return null;
    }

    @Override
    public UserTest update(UserTest model) {
        return null;
    }

    @Override
    public UserTest get(String email, String phone) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void remove(String email, String phone) {

    }
}
