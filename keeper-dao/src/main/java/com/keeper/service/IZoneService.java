package com.keeper.service;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.Zone;

/**
 * Default Comment
 */
public interface IZoneService {
    Zone add(Zone zone);

    Zone get(Long userId);

    Zone update(Zone zone);

    void remove(Long userId);
}
