package com.keeper.service;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.dao.Zone;

import java.util.List;

/**
 * Default Comment
 */
public interface IZoneService extends IModelService<Zone> {
    List<Zone> getByCountry(String country);

    List<Zone> getByCity(String city);
}
