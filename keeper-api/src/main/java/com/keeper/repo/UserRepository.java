package com.keeper.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.User;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA Repository for User
 */
//@Repository
//@Qualifier(value = RepositoryResolver.QUALIFIER_USER)
public interface UserRepository {//extends JpaRepository<User, Long> {
    User findByEmail(@Param("email") String email);
    User findByPhone(@Param("phone") String phone);

    User deleteByEmail(@Param("email") String email);
    User deleteByPhone(@Param("phone") String phone);
}
