package com.keeper.controllers.testing;


import com.keeper.entity.dto.UserTestDTO;
import com.keeper.managers.impl.UserTestManager;
import com.keeper.managers.impl.ZoneTestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Petri Kainulainen
 */
/*@Controller
@SessionAttributes("user")*/
public class UserTestController extends AbstractController {
    
/*    private static final Logger LOGGER = LoggerFactory.getLogger(UserTestController.class);
    
    protected static final String ERROR_MESSAGE_KEY_DELETED_USER_WAS_NOT_FOUND = "error.message.deleted.not.found";
    protected static final String ERROR_MESSAGE_KEY_EDITED_USER_WAS_NOT_FOUND = "error.message.edited.not.found";
    
    protected static final String FEEDBACK_MESSAGE_KEY_USER_CREATED = "feedback.message.user.created";
    protected static final String FEEDBACK_MESSAGE_KEY_USER_DELETED = "feedback.message.user.deleted";
    protected static final String FEEDBACK_MESSAGE_KEY_USER_EDITED = "feedback.message.user.edited";
    
    protected static final String MODEL_ATTIRUTE_USER = "user";
    protected static final String MODEL_ATTRIBUTE_USERS = "users";
    protected static final String MODEL_ATTRIBUTE_SEARCH_CRITERIA = "searchCriteria";
    
    protected static final String USER_ADD_FORM_VIEW = "user/create";
    protected static final String USER_EDIT_FORM_VIEW = "user/edit";
    protected static final String USER_LIST_VIEW = "user/list";
    protected static final String USER_SEARCH_RESULT_VIEW = "user/searchResults";
    
    protected static final String REQUEST_MAPPING_LIST = "/";
    
//    @Resource
    @Autowired //final
    private UserTestManager userTestManager;

    @Autowired //final
    private ZoneTestManager zoneTestManager;

//    @Resource
//    private GeoPointDtoDaoManager geoPointDtoDaoManager;
//
//    @Resource
//    private LocationDtoDaoManager locationDtoDaoManager;
//
//    @Resource
//    private RouteDtoDaoManager routeDtoDaoManager;
//
//    @Resource
//    private TaskDtoDaoManager taskDtoDaoManager;


    *//**
     * Processes delete user requests.
     * @param id    The id of the deleted user.
     * @param attributes
     * @return
     *//*
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        LOGGER.debug("Deleting user with id: " + id);

        userTestManager.removeUser(id);
        addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_USER_DELETED, id);

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }

    
    *//**
     * Processes create user requests.
     * @param model
     * @return  The name of the create user form view.
     *//*
    @RequestMapping(value = "/user/create", method = RequestMethod.GET) 
    public String showCreateUserForm(Model model) {
        LOGGER.debug("Rendering create user form");
        
        model.addAttribute(MODEL_ATTIRUTE_USER, UserTestDTO.EMPTY);

        return USER_ADD_FORM_VIEW;
    }

    *//**
     * Processes the submissions of create user form.
     * @param created   The information of the created users.
     * @param bindingResult
     * @param attributes
     * @return
     *//*
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String submitCreateUserForm(@Valid @ModelAttribute(MODEL_ATTIRUTE_USER) UserTestDTO created, BindingResult bindingResult, RedirectAttributes attributes) {
        LOGGER.debug("Create user form was submitted with information: " + created);

        if (bindingResult.hasErrors()) {
            return USER_ADD_FORM_VIEW;
        }
                
        UserTestDTO user = userTestManager.addUser(created);

        addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_USER_CREATED, user.getName());

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }

    *//**
     * Processes edit user requests.
     * @param id    The id of the edited user.
     * @param model
     * @param attributes
     * @return  The name of the edit user form view.
     *//*
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public String showEditUserForm(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        LOGGER.debug("Rendering edit user form for user with id: " + id);
        
        UserTestDTO user = userTestManager.getUser(id);
        if (user == null) {
            LOGGER.debug("No user found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_USER_WAS_NOT_FOUND);
            return createRedirectViewPath(REQUEST_MAPPING_LIST);            
        }

        model.addAttribute(MODEL_ATTIRUTE_USER, user);
        
        return USER_EDIT_FORM_VIEW;
    }

    *//**
     * Processes the submissions of edit user form.
     * @param updated   The information of the edited user.
     * @param bindingResult
     * @param attributes
     * @return
     *//*
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String submitEditUserForm(@Valid @ModelAttribute(MODEL_ATTIRUTE_USER) UserTestDTO updated, BindingResult bindingResult, RedirectAttributes attributes) {
        LOGGER.debug("Edit user form was submitted with information: " + updated);
        
        if (bindingResult.hasErrors()) {
            LOGGER.debug("Edit user form contains validation errors. Rendering form view.");
            return USER_EDIT_FORM_VIEW;
        }
        
        UserTestDTO user = userTestManager.updateUser(updated);
        addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_USER_EDITED, user.getName());

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }
    

    *//**
     * Processes requests to home page which lists all available users.
     * @param model
     * @return  The name of the user list view.
     *//*
    @RequestMapping(value = REQUEST_MAPPING_LIST, method = RequestMethod.GET)
    public String showList(Model model) {
        LOGGER.debug("Rendering user list page");

        List<UserTestDTO> users = userTestManager.getAllUsers();
        model.addAttribute(MODEL_ATTRIBUTE_USERS, users);

        return USER_LIST_VIEW;
    }


    public void test() {
        LOGGER.debug("Rendering user list page");

        //userTestManager.test();

    }
   
    *//**
     * This setter method should only be used by unit tests
     * @param userTestManager
     *//*
    protected void setUserService(UserTestManager userTestManager) {
        this.userTestManager = userTestManager;
    }*/
}
