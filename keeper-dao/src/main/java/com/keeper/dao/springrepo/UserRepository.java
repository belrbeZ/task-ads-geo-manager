package com.keeper.dao.springrepo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.Task;
import com.keeper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA Repository for User
 *
 * MUST BE EXTENDED TO SUPPORT ZONES, SLEEP_TIMES
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByIdStartingWith(String start);

    //Better for using
//    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//    User findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);

//    @Query("select u from #{#entityName} u where u.lastname = ?1")
//    List<User> findByLastname(String lastname);

//    @Query("select t from #{#entityName} t where t.attribute = ?1")
//    List<T> findAllByAttribute(String attribute);

    User findByEmail(String email);

    User findByPhone(String phone);
}
