package com.keeper.managers.impl;

import com.keeper.dto.GeoPointDto;
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
public class GeoPointDtoDaoManager implements IGeoPointDtoManager<GeoPoint> {

    @Autowired
    private GeoPointRepoService repoService;

    //<editor-fold desc="Dao&Dto">

    @Override
    public GeoPoint parseDtoToDao(GeoPointDto dtoMode) {
        return null;
    }

    @Override
    public GeoPointDto parseDaoToDto(GeoPoint daoModel) {
        return null;
    }

    @Override
    public List<GeoPoint> parseDtoToDao(List<GeoPointDto> dtoModelList) {
        return null;
    }

    @Override
    public List<GeoPointDto> parseDaoToDto(List<GeoPoint> daoModelList) {
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="Operations">

    @Override
    public List<GeoPoint> addGeoPoints(Long ownerId, List<GeoPoint> geoPoints) {
        return null;
    }

    @Override
    public List<GeoPoint> getGeoPoints(Long ownerId, List<Long> geoPointsIds) {
        return null;
    }

    @Override
    public List<GeoPoint> getAllGeoPoints() {
        return null;
    }

    @Override
    public List<GeoPoint> updateGeoPoints(Long ownerId, List<GeoPoint> geoPoints) {
        return null;
    }

    @Override
    public void removeGeoPoints(Long ownerId, List<Long> geoPointsIds) {

    }
    //</editor-fold>
}
