package com.keeper.repo;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(@Param("email") String email);
    Optional<User> findOneByPhone(@Param("phone") String phone);

    boolean existsByEmail(@Param("email") String email);
    boolean existsByPhone(@Param("phone") String phone);

    Optional<User> removeByEmail(@Param("email") String email);
    Optional<User> removeByPhone(@Param("phone") String phone);
}
