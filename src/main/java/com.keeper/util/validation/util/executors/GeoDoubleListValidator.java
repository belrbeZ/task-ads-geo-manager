package com.keeper.util.validation.util.executors;

import com.keeper.util.validation.util.IValidator;

import java.util.List;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
public class GeoDoubleListValidator implements IValidator<List<Double>> {

    private static final GeoValidator geoValidator = new GeoValidator();

    @Override
    public boolean validate(List<Double> geos) {
        return geos.stream().map(Object::toString).noneMatch(geoValidator::validate);
    }
}
