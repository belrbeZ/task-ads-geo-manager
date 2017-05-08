package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dto.GeoPointDTO;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IGeoPointService extends IModelDTOService<GeoPoint, GeoPointDTO> {
    Optional<List<GeoPoint>> getByUserId(Long userId);
}
