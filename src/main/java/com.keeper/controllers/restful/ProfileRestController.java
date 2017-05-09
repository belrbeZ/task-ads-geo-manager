package com.keeper.controllers.restful;

/*
 * Created by GoodforGod on 19.03.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.dto.UserDTO;
import com.keeper.model.dto.UserFormDTO;
import com.keeper.service.modelbased.impl.UserService;
import com.keeper.util.Translator;
import com.keeper.util.resolve.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Control Profile Rest End points
 */
@RestController
public class ProfileRestController {
    private final String PATH = ApiResolver.PROFILE;

    private final UserService repoService;

    @Autowired
    public ProfileRestController(UserService repoService) {
        this.repoService = repoService;
    }


    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> get(@RequestParam(value = "id") Long userId) {
        return new ResponseEntity<>(Translator.toDTO(repoService.get(userId).orElse(User.EMPTY)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@RequestBody UserDTO model, BindingResult result) {
        HttpStatus code = HttpStatus.OK;
        String info = "";
        try {
            if(!repoService.updateDTO(model).isPresent()) {
                info = "NULLABLE";
                code = HttpStatus.NOT_MODIFIED;
            }
        } catch (Exception e) {
            info = e.getMessage();
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(info, code);
    }


    @RequestMapping(value = ApiResolver.PUBLIC_PROFILE, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody UserFormDTO model, BindingResult result) {
        repoService.save(Translator.toDAO(model));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long userId) {
        repoService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
