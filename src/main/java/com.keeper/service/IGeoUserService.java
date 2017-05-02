package com.keeper.service;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoUser;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IGeoUserService {
    Optional<List<GeoUser>> getAllByUserId(Long userId);
}
