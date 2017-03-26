package com.keeper.dao.springrepo;

/*
 * Created by GoodforGod on 23.03.2017.
 */

import com.keeper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA Repository for User
 *
 * MUST BE EXTENDED TO SUPPORT ZONES, SLEEP_TIMES
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByPhone(String phone);
}
