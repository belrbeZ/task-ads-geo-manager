package com.keeper.controllers.secure;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.config.JpaSpringConfig;
import com.keeper.entity.User;
import com.keeper.entity.Zone;
import com.keeper.service.hibernate.HibernateGenericService;
import com.keeper.service.impl.UserService;
import com.keeper.service.jpa.JpaUserService;
import com.keeper.states.UserType;
import com.keeper.util.PathManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Default Comment
 */
@Controller
public class OAuthWebController {

    //For using Spring data
    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;


    //For using Hibernate
    ApplicationContext ctxHiber = new ClassPathXmlApplicationContext("applicationContext-tx-annot.xml");
    HibernateGenericService<User, Long> productServiceHiber = ctxHiber.getBean(HibernateGenericService.class);


    //For using JPA
    ApplicationContext ctxJpa = new AnnotationConfigApplicationContext(JpaSpringConfig.class);
    JpaUserService jpaUserService = ctxJpa.getBean(JpaUserService.class);


    // Model vs ModelAndView READ!
    @RequestMapping(value = PathManager.WEB_REGISTER, method = RequestMethod.GET)
    public ModelAndView registerPage() {

        return new ModelAndView("Hi");
    }

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "userslist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        //TEST
        User user = new User(UserType.USER, "name", "email", "phone", "password", "about", new Zone(222L, "city", "country"));
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        userService.addUser(user);

        model.addAttribute("success", "User " + user.getEmail() + " "+ user.getEmail() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }

}
