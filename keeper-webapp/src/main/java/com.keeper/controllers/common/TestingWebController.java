package com.keeper.controllers.common;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.dao.repo.UserRepository;
import com.keeper.entity.User;
import com.keeper.entity.Zone;
import com.keeper.service.impl.UserRepoService;
import com.keeper.states.UserType;
import com.keeper.util.ViewResolver;
import com.keeper.util.WebMappingResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Used for Testing and Debugging
 */
//@Controller
public class TestingWebController {

    private final UserRepoService userRepoService;

    /*
    private final MessageSource messageSource;

    //For using Hibernate
    ApplicationContext ctxHiber = new ClassPathXmlApplicationContext("applicationContext-tx-annot.xml");
    HibernateGenericService<User, Long> productServiceHiber = ctxHiber.getBean(HibernateGenericService.class);

    //For using JPA
    ApplicationContext ctxJpa = new AnnotationConfigApplicationContext(JpaSpringConfig.class);
    JpaUserService jpaUserService = ctxJpa.getBean(JpaUserService.class);
    */

    @Autowired
    public TestingWebController(UserRepoService userRepoService) {
        this.userRepoService = userRepoService;
    }

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = WebMappingResolver.TEST_USERS, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userRepoService.getAllUsers();
        model.addAttribute("users", users);
        return ViewResolver.TEST_USERLIST;
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = WebMappingResolver.WEB_PAGE_REGISTER, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        //TEST
        User user = new User(UserType.USER, "name", "email", "phone", "password", "about", new Zone(222L, "city", "country"));
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return ViewResolver.WEB_REGISTER;
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = WebMappingResolver.WEB_PAGE_REGISTER, method = RequestMethod.POST)
    public String saveUser(@Valid User user,
                           BindingResult result,
                           ModelMap model) {

        if (result.hasErrors())
            return ViewResolver.WEB_REGISTER;

        userRepoService.addUser(user);

        model.addAttribute("msg", "User "
                + user.getEmail()
                + " "
                + user.getEmail()
                + " registered successfully");

        return ViewResolver.WEB_MAIN;
    }
}
