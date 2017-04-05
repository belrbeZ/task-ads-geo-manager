package com.keeper.managers.impl;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.Zone;
import com.keeper.entity.dto.ZoneDTO;
import com.keeper.managers.IZoneManager;

import java.util.List;

/**
 * Default Comment
 */
public class ZoneManager implements IZoneManager {

//    @Autowired
//    private ZoneRepoService repoService;

    //<editor-fold desc="Parse">

    @Override
    public Zone parseDtoToDao(ZoneDTO dtoMode) {
        return null;
    }

    @Override
    public ZoneDTO parseDaoToDto(Zone daoModel) {
        return null;
    }

    @Override
    public List<Zone> parseDtoToDao(List<ZoneDTO> dtoModelList) {
        return null;
    }

    @Override
    public List<ZoneDTO> parseDaoToDto(List<Zone> daoModelList) {
        return null;
    }


    //<editor-fold desc="Operations">

    @Override
    public ZoneDTO addRoutes(Long ownerId, ZoneDTO zone) {
        return null;
    }

    @Override
    public ZoneDTO getRoutes(Long ownerId, ZoneDTO zoneId) {
        return null;
    }

    @Override
    public ZoneDTO getAllRoutes() {
        return null;
    }

    @Override
    public ZoneDTO updateRoute(Long ownerId, Long zoneId) {
        return null;
    }

    @Override
    public void removeRoutes(Long ownerId, Long zoneId) {

    }


    //</editor-fold>
}
