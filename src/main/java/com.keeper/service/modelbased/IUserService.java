package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.UserDTO;

import java.util.Optional;

/**
 * Default Comment
 */
public interface IUserService extends IModelDTOService<User, UserDTO> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    Optional<User> getAuthorized();

    Optional<User> getByEmail(String email);
    Optional<User> getByPhone(String phone);

    /** TRANSACTIONAL */
    Optional<User> removeByEmail(String email);

    /** TRANSACTIONAL */
    Optional<User> removeByPhone(String phone);
}
