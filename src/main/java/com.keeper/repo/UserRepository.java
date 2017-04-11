package com.keeper.repo;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.entity.dao.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default Comment
 */
@Repository
//@Qualifier(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(@Param("email") String email);
    User findOneByPhone(@Param("phone") String phone);

    boolean existsByEmail(@Param("email") String email);
    boolean existsByPhone(@Param("phone") String phone);

    @Transactional User removeByEmail(@Param("email") String email);
    @Transactional User removeByPhone(@Param("phone") String phone);
}
