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

    @Override
    public ZoneTestDTO getEmpty() {
        return null;
    }

    @Override
    public boolean isExists(Long id) {
        return false;
    }

    @Override
    public ZoneTestDTO add(ZoneTestDTO model) {
        return null;
    }

    @Override
    public ZoneTestDTO get(Long id) {
        return null;
    }

    @Override
    public List<ZoneTestDTO> getAll() {
        return null;
    }

    @Override
    public ZoneTestDTO update(ZoneTestDTO model) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
