package com.keeper.managers.impl;

import com.keeper.entity.dto.GeoPointDTO;
import com.keeper.entity.GeoPoint;
import com.keeper.managers.IGeoPointDtoManager;
import com.keeper.service.impl.GeoPointRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class GeoPointDtoDaoManager implements IGeoPointDtoManager {

    @Autowired
    private GeoPointRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public GeoPoint parseDtoToDao(GeoPointDTO dtoMode) {
        return null;
    }

    @Override
    public GeoPointDTO parseDaoToDto(GeoPoint daoModel) {
        return null;
    }

    @Override
    public List<GeoPoint> parseDtoToDao(List<GeoPointDTO> dtoModelList) {
        return null;
    }

    @Override
    public List<GeoPointDTO> parseDaoToDto(List<GeoPoint> daoModelList) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Operations">

    @Override
    public List<GeoPointDTO> addGeoPoints(Long ownerId, List<GeoPointDTO> geoPoints) {
        return null;
    }

    @Override
    public List<GeoPointDTO> getGeoPoints(Long ownerId, List<Long> geoPointsIds) {
        return null;
    }

    @Override
    public List<GeoPointDTO> getAllGeoPoints() {
        return null;
    }

    @Override
    public List<GeoPointDTO> updateGeoPoints(Long ownerId, List<GeoPointDTO> geoPoints) {
        return null;
    }

    @Override
    public void removeGeoPoints(Long ownerId, List<Long> geoPointsIds) {

    }
    //</editor-fold>
}
