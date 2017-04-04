package com.keeper.managers;

import com.keeper.entity.GeoPoint;
import com.keeper.entity.dto.GeoPointDTO;
import com.keeper.service.IGeoPointService;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

public interface IGeoPointDtoManager<T> extends IModelDtoManager<T, GeoPointDTO>  {
    List<GeoPointDTO> addGeoPoints(Long ownerId, List<GeoPointDTO> geoPoints);

    List<GeoPointDTO> getGeoPoints(Long ownerId, List<Long> geoPointsIds);

    List<GeoPointDTO> getAllGeoPoints();

    List<GeoPointDTO> updateGeoPoints(Long ownerId, List<GeoPointDTO> geoPoints);

    void removeGeoPoints(Long ownerId, List<Long> geoPointsIds);
}
