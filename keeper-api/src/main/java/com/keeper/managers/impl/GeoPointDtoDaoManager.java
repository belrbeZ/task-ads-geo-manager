package com.keeper.managers.impl;

import com.keeper.dto.GeoPointDto;
import com.keeper.entity.GeoPoint;
import com.keeper.managers.contracts.IGeoPointDtoManager;
import org.springframework.stereotype.Service;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

@Service
public class GeoPointDtoDaoManager implements IGeoPointDtoManager<GeoPoint> {

    @Override
    public GeoPoint parseDtoToDao(GeoPointDto geoPointDto) {
        return null;
    }

    @Override
    public GeoPointDto parseDaoToDto(GeoPoint geoPoint) {
        return null;
    }

}
