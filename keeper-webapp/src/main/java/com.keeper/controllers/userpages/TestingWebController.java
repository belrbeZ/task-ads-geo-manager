package com.keeper.controllers.userpages;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import org.springframework.stereotype.Controller;

//import javax.validation.Valid;


/**
 * Used for Testing and Debugging
 */
@Controller
public class TestingWebController {

//    private final UserRepoService userRepoService;

//    @Autowired
//    public TestingWebController(UserRepoService userRepoService) {
//        this.userRepoService = userRepoService;
//    }

//
//    /**
//     * This method will list all existing users.
//     */
//    @RequestMapping(value = WebMappingResolver.TEST_USERS, method = RequestMethod.GET)
//    public String listUsers(ModelMap model) {
//
//        List<User> users = userRepoService.getAllUsers();
//        model.addAttribute("users", users);
//        return ViewResolver.TEST_USERLIST;
//    }
//
//    /**
//     * This method will provide the medium to add a new user.
//     */
//    @RequestMapping(value = WebMappingResolver.WEB_PAGE_REGISTER, method = RequestMethod.GET)
//    public String newUser(ModelMap model) {
//        //TEST
//        User user = new User(UserType.USER, "name", "email", "phone", "password", "about", new Zone(222L, "city", "country"));
//        model.addAttribute("user", user);
//        model.addAttribute("edit", false);
//        return ViewResolver.WEB_REGISTER;
//    }
//
//    /**
//     * This method will be called on form submission, handling POST request for
//     * saving user in database. It also validates the user input
//     */
//    @RequestMapping(value = WebMappingResolver.WEB_PAGE_REGISTER, method = RequestMethod.POST)
//    public String saveUser(@Valid User user,
//                           BindingResult result,
//                           ModelMap model) {
//
//        if (result.hasErrors())
//            return ViewResolver.WEB_REGISTER;
//
//        userRepoService.add(user);
//
//        model.addAttribute("msg", "User "
//                + user.getEmail()
//                + " "
//                + user.getEmail()
//                + " registered successfully");
//
//        return ViewResolver.WEB_MAIN;
//    }
}
