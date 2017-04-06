package com.keeper.repo;

import com.keeper.entity.dao.UserTest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Repository
@Qualifier(value = "userTestRepository")
public interface UserTestRepository extends JpaRepository<UserTest, Long> {
    UserTest findByEmail(@Param("email") String email);
    UserTest findByPhone(@Param("phone") String phone);

    UserTest deleteByEmail(@Param("email") String email);
    UserTest deleteByPhone(@Param("phone") String phone);
}