package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.model.dto.ZoneDTO;
import com.keeper.service.modelbased.impl.ZoneService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.ApiResolver;
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

    private final ZoneService repoService;

    @Autowired
    public ZoneRestController(ZoneService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = ApiResolver.ZONE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZoneDTO> get(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(ModelTranslator.toDTO(repoService.get(userId).orElse(Zone.EMPTY)), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ZONE, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody ZoneDTO model, BindingResult result) {
        repoService.updateDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ZONE, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody ZoneDTO model, BindingResult result) {
        repoService.saveDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ZONE, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("userId") Long userId) {
        repoService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
