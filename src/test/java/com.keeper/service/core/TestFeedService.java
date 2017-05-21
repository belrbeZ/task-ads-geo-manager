package com.keeper.service.core;

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.RouteDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.model.types.RouteType;
import com.keeper.model.types.TaskType;
import com.keeper.model.util.SimpleGeoPoint;
import com.keeper.service.core.impl.FeedService;
import com.keeper.util.ModelTranslator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 21.05.2017
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Import(AppBootStarter.class)
public class TestFeedService { //extends TestCase {

    @Autowired
    private FeedService feedService;

    private static final Map<TestType, Task>    tasks = new HashMap<>();
    private static final Map<TestType, GeoPoint> geos = new HashMap<>();
    private static final Map<TestType, Route>   routes = new HashMap<>();

    enum TestType {
        SIMPLE,

    }

    @BeforeClass
    public static void setup() {
        // tasks
        tasks.put(TestType.SIMPLE, ModelTranslator.toDAO(new TaskDTO(1L, 1L,
                TaskType.COMMON, "Test", "Test Case",
                new SimpleGeoPoint(1., 1., 1))));


        // points
        geos.put(TestType.SIMPLE, ModelTranslator.toDAO(new GeoPointDTO(1L, 1L,
                "1.", "1.", 1, "Test Case")));


        // routes
        routes.put(TestType.SIMPLE, ModelTranslator.toDAO(new RouteDTO(1L, 1L, RouteType.COMMON, "Test Case",
                1, new String[]{ "1.", "2." }, new String[] { "1.", "2." })));

    }

    @AfterClass
    public static void cleanup() {

    }

    @After
    public void reCreateFeedService() {

    }

    //<editor-fold desc="Submit">

    public void testTaskSubmit() {
        Task task = tasks.get(TestType.SIMPLE);
        feedService.submit(task);
        feedService.update();
//        assertEquals(feedService.all(1L).get().get(0), ModelTranslator.toDTO(task));
    }

    public void testRouteSubmit() {
        Task task = tasks.get(TestType.SIMPLE);
        feedService.submit(task);
        feedService.update();
//        assertEquals(feedService.all(1L).get().get(0), ModelTranslator.toDTO(task));
    }

    public void testGeoSubmit() {
        Task task = tasks.get(TestType.SIMPLE);
        feedService.submit(task);
        feedService.update();
//        assertEquals(feedService.all(1L).get().get(0), ModelTranslator.toDTO(task));
    }

    //</editor-fold>

    //<editor-fold desc="Removal">

    public void testTaskRemoval() {

    }

    public void testRouteRemoval() {

    }

    public void testGeoRemoval() {

    }

    //</editor-fold>

    //<editor-fold desc="Prevent Removal">

    public void testTaskPreventRemoval() {

    }

    public void testRoutePreventRemoval() {

    }

    public void testGeoPreventRemoval() {

    }

    //</editor-fold>

    //<editor-fold desc="Chart Rate">

    public void testChartRateUp() {

    }

    public void testChartRateDown() {

    }

    //</editor-fold>


}
