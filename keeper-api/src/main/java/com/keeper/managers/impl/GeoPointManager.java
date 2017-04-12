package com.keeper.managers.impl;

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.managers.IGeoPointManager;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

//@Service
public class GeoPointManager implements IGeoPointManager<GeoPoint> {

//    @Autowired
//    private GeoPointRepoService repoService;

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
