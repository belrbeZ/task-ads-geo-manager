package com.keeper;

/*
  Created by AlexVasil on 26.03.2017.
 */


import com.keeper.service.impl.UserRepoService;
import junit.framework.TestCase;

/**
 * Testing of JPA and Hibernate
 */

public class TestJpaDemoConfig extends TestCase {

//    @Autowired
//    @Qualifier("userService")
//    static UserRepoService userRepoService;

    public void testApp() {
        UserRepoService userRepoService = new UserRepoService();
        System.out.println("TestJpaDemoConfig");
        userRepoService.getAllUsers();
    }

}
