package com.keeper;

import com.keeper.test.service.impl.UserTestRepoService;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alexandr Vasiliev on 11.04.2017.
 *
 * @author Alexandr Vasiliev
 */
public class TestingController extends TestCase {

    private final UserTestRepoService repoService;

    @Autowired
    public TestingController(UserTestRepoService repoService) {
        this.repoService = repoService;
    }


    public void setUp() throws Exception {
        super.setUp();
    }

    public void testApp() throws Exception {
        System.out.println(repoService.get(1L).getEmail());
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

}
