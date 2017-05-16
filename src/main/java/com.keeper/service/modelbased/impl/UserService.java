package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.UserDTO;
import com.keeper.repo.UserRepository;
import com.keeper.service.core.ISubscriptionRemove;
import com.keeper.service.core.impl.SubscriptionService;
import com.keeper.service.modelbased.IUserService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import com.keeper.util.resolvers.ErrorMessageResolver;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.keeper.util.resolvers.ErrorMessageResolver.*;


/**
 * Default Comment
 */
@Service
public class UserService extends PrimeModelService<User, Long> implements IUserService {

    private final UserRepository repository;
    private final ISubscriptionRemove subscriptionService;

    @Autowired
    public UserService(UserRepository repository,
                       SubscriptionService subscriptionService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public User getEmpty() {
        return User.EMPTY;
    }

    @Override
    public boolean existsByEmail(String email) {
        if(Validator.isStrEmpty(email)) {
            logger.warn(ErrorMessageResolver.GET_NULLABLE_ID);
            return false;
        }

        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        if(Validator.isStrEmpty(phone)) {
            logger.warn(ErrorMessageResolver.GET_NULLABLE_ID);
            return false;
        }

        return repository.existsByPhone(phone);
    }

    @Override
    public Optional<User> getAuthorized() {
        return getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public Optional<User> getByEmail(String email) {
        if(Validator.isStrEmpty(email)) {
            logger.warn(ErrorMessageResolver.GET_NULLABLE_ID);
            return Optional.empty();
        }

        return repository.findOneByEmail(email);
    }

    @Override
    public Optional<User> getByPhone(String phone) {
        if(Validator.isStrEmpty(phone)) {
            logger.warn(ErrorMessageResolver.GET_NULLABLE_ID);
            return Optional.empty();
        }

        return repository.findOneByPhone(phone);
    }

    @Transactional
    @Override
    public Optional<User> saveDTO(UserDTO model) {
        if(model == null) {
            logger.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        return super.save(ModelTranslator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<User> updateDTO(UserDTO model) {
        if(model == null) {
            logger.warn(UPDATE_MODEL_NULLABLE);
            throw new NullPointerException("");
        }
        Optional<User> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            logger.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        return super.save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<User> removeByEmail(@NotEmpty String email) {
        Optional<User> user = repository.removeByEmail(email);
        user.ifPresent(usr -> subscriptionService.removeUserSubscriptions(usr.getId()));
        return user;
    }

    @Transactional
    @Override
    public Optional<User> removeByPhone(@NotEmpty String phone) {
        Optional<User> user = repository.removeByEmail(phone);
        user.ifPresent(usr -> subscriptionService.removeUserSubscriptions(usr.getId()));
        return user;
    }

    @Override
    public void remove(Long id) {
        super.remove(id);
        subscriptionService.removeUserSubscriptions(id);
    }


}
