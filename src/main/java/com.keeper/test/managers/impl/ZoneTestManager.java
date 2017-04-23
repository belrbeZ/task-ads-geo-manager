package com.keeper.test.managers.impl;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.test.model.dto.ZoneTestDTO;
import com.keeper.test.managers.IZoneTestManager;
import com.keeper.test.service.impl.ZoneTestRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Comment
 */
@Service
public class ZoneTestManager implements IZoneTestManager {

    @Autowired
    private ZoneTestRepoService repoService;


}
