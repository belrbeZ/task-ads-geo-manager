package com.keeper.service;

import com.keeper.util.GeoComputer;
import com.keeper.util.Validator;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 21.05.2017
 */
public class TestGeoCompute extends TestCase {

    @Test
    public void testGeoValid() {
        assertEquals(true, Validator.isGeoValid("54.41241"));
    }

    @Test
    public void testGeoInRadiusPositive() {
        assertEquals(true, GeoComputer.geoInRadius(11.5325, 55.535, 11.5325, 55.535, 5));
    }

    @Test
    public void testGeoInRadiusNegative() {
        assertEquals(false, GeoComputer.geoInRadius(11.5325, 57.535, 12.5325, 55.535, 5));
    }
}
