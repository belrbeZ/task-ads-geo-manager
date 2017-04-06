package com.keeper.service.impl;

import com.keeper.entity.dao.UserTest;
import com.keeper.repo.UserTestRepository;
import com.keeper.service.IUserTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Service
public class UserTestRepoService extends ModelRepoService<UserTest>  implements IUserTestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTestRepoService.class);

    private final UserTestRepository repository;

    @Autowired
    public UserTestRepoService(UserTestRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return get(email, phone) != null;
    }

    @Override
    public UserTest get(String email, String phone) {
        if(email != null && !email.isEmpty())
            return repository.findByEmail(email);
        else
            return repository.findByPhone(phone);
    }

    @Override
    public void remove(String email, String phone) {
        if(email != null && !email.isEmpty())
            repository.deleteByEmail(email);
        else
            repository.deleteByPhone(phone);
    }
}
