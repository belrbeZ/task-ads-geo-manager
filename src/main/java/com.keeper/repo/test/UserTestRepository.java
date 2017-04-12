package com.keeper.repo.test;

import com.keeper.model.dao.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Repository
//@Qualifier(value = "userTestRepository")
public interface UserTestRepository extends JpaRepository<UserTest, Long> {
    UserTest findOneByEmail(@Param("email") String email);
    UserTest findOneByPhone(@Param("phone") String phone);

    boolean existsByEmail(@Param("email") String email);
    boolean existsByPhone(@Param("phone") String phone);

    @Transactional UserTest removeByEmail(@Param("email") String email);
    @Transactional UserTest removeByPhone(@Param("phone") String phone);
}