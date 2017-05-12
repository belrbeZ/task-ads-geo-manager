package com.keeper;

import com.keeper.util.GeoComputer;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Alexandr Vasiliev on 11.04.2017.
 *
 * @author Alexandr Vasiliev
 */
public class TestingController extends TestCase{

    @Test
    public void testGeoInRadiusPositive() {
        assertEquals(true, GeoComputer.geoInRadius(11.5325, 55.535, 11.5325, 55.535, 5));
    }

    @Test
    public void testGeoInRadiusNegative() {
        assertEquals(false, GeoComputer.geoInRadius(11.5325, 57.535, 12.5325, 55.535, 5));
    }
}
