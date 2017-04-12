package com.keeper.service.test;

import com.keeper.model.test.UserTest;
import com.keeper.repo.test.UserTestRepository;
import com.keeper.service.impl.ModelRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Service
public class UserTestRepoService extends ModelRepoService<UserTest> implements IUserTestService {

    private final UserTestRepository repository;

    @Autowired
    public UserTestRepoService(UserTestRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public UserTest getEmpty() {
        return UserTest.EMPTY;
    }

    @Override
    public boolean isExists(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.existsByEmail(email)
                : (phone != null && !phone.isEmpty()) && repository.existsByPhone(phone);
    }

    @Override
    public UserTest get(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.findOneByEmail(email)
                : (phone != null && !phone.isEmpty()) ? repository.findOneByPhone(phone) : getEmpty();
    }

    @Override
    public UserTest remove(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.removeByEmail(email)
                : (phone != null && !phone.isEmpty()) ? repository.removeByPhone(phone) : getEmpty();
    }
}
