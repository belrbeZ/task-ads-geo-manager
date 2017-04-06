package com.keeper.managers.impl;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.ZoneTest;
import com.keeper.entity.dto.ZoneTestDTO;
import com.keeper.managers.IZoneManager;
import com.keeper.service.impl.ZoneTestRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Comment
 */
@Service
public class ZoneTestManager {

    @Autowired
    private ZoneTestRepoService repoService;

    //<editor-fold desc="Parse">

    public ZoneTest parseDtoToDao(ZoneTestDTO dtoMode) {
        return null;
    }

    public ZoneTestDTO parseDaoToDto(ZoneTest daoModel) {
        return null;
    }

    public List<ZoneTest> parseDtoToDao(List<ZoneTestDTO> dtoModelList) {
        return null;
    }

    public List<ZoneTestDTO> parseDaoToDto(List<ZoneTest> daoModelList) {
        return null;
    }


    //<editor-fold desc="Operations">

    public ZoneTestDTO addRoutes(Long ownerId, ZoneTestDTO zone) {
        return null;
    }

    public ZoneTestDTO getRoutes(Long ownerId, ZoneTestDTO zoneId) {
        return null;
    }

    public ZoneTestDTO getAllRoutes() {
        return null;
    }

    public ZoneTestDTO updateRoute(Long ownerId, Long zoneId) {
        return null;
    }

    public void removeRoutes(Long ownerId, Long zoneId) {

    }


    //</editor-fold>
}
