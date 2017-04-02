package com.keeper.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA Repository for User
 */
public interface UserRepository extends JpaRepository<User, Long>{//, QueryDslPredicateExecutor<User>
    User findByEmail(@Param("email") String email);
    User findByPhone(@Param("phone") String phone);

    User deleteByEmail(@Param("email") String email);
    User deleteByPhone(@Param("phone") String phone);
}
