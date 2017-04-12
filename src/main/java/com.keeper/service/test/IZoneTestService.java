package com.keeper.service.test;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import com.keeper.model.test.ZoneTest;

import java.util.List;

/**
 * Default Comment
 */
public interface IZoneTestService {
    List<ZoneTest> getByCountry(String country);

    List<ZoneTest> getByCity(String city);
}
