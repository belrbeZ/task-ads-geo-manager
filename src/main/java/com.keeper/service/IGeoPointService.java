package com.keeper.service;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoPoint;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IGeoPointService {
    Optional<List<GeoPoint>> getAllByUserId(Long userId);
}
