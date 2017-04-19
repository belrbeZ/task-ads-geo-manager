package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.model.dto.ZoneDTO;
import com.keeper.service.impl.ZoneRepoService;
import com.keeper.util.Translator;
import com.keeper.util.web.ApiResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Default Comment
 */
@RestController
public class ZoneRestController {
    private final String PATH = ApiResolver.REST_ZONE;

    private final ZoneRepoService repoService;

    @Autowired
    public ZoneRestController(ZoneRepoService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZoneDTO> get(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(Translator.convertToDTO(repoService.get(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody Zone model, BindingResult result) {
        repoService.update(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody Zone model, BindingResult result) {
        repoService.add(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = PATH, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("userId") Long userId) {
        repoService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
