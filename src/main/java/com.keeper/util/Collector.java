package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.test.model.dao.UserTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Help to resolve and work with entity collections
 */
public class Collector {

    //<editor-fold desc="Test">

    private static final List<UserTest>     nullableUserTestList = null;

    public static List<UserTest> makeUserTestList(final UserTest value) {
        return value != null ? new ArrayList<UserTest>() {{ add(value); }} : nullableUserTestList;
    }

    private static final UserTest           nullableUserTest = UserTest.EMPTY;

    public static UserTest getFirstUserTest(final List<UserTest> list) {
        return (list == null || list.isEmpty()) ? nullableUserTest : list.get(0);
    }
    //</editor-fold>

    //<editor-fold desc="makeList">

/*    private static final List<String>       nullableStringList  = null;
    private static final List<Route>        nullableRouteList   = null;
    private static final List<Long>         nullableIdList      = null;
    private static final List<GeoCoordinate>     nullableCoordList   = null;
    private static final List<User>         nullableUserList    = null;
    private static final List<Task>         nullableTaskList    = null;

    public static List<Long> makeIdList(final Long value) {
        return value != null ? new ArrayList<Long>() {{ add(value); }} : nullableIdList;
    }

    public static List<String> makeStringList(final String value) {
        return value != null ? new ArrayList<String>() {{add(value);}} : nullableStringList;
    }

    public static List<GeoCoordinate> makeCoordList(final GeoCoordinate value) {
        return value != null ? new ArrayList<GeoCoordinate>() {{ add(value);}} : nullableCoordList;
    }

    public static List<Route> makeRouteList(final Route value) {
        return value != null ? new ArrayList<Route>() {{add(value);}} : nullableRouteList;
    }

    public static List<User> makeUserList(final User value) {
        return value != null ? new ArrayList<User>() {{add(value);}} : nullableUserList;
    }

    public static List<Task> makeTaskList(final Task value) {
        return value != null ? new ArrayList<Task>() {{add(value);}} : nullableTaskList;
    }*/
    //</editor-fold>

    //<editor-fold desc="getFirst">
/*    private static final User         nullableUser    = User.EMPTY;
    private static final Task         nullableTask    = Task.EMPTY;
    private static final Route        nullableRoute   = Route.EMPTY;
    private static final GeoCoordinate nullableCoord   = GeoCoordinate.EMPTY;

    public static User getFirstUser(List<User> users) {
        return (users == null || users.isEmpty()) ? nullableUser : users.get(0);
    }

    public static GeoCoordinate getFirstCoordinate(List<GeoCoordinate> geoPoints) {
        return (geoPoints == null || geoPoints.isEmpty()) ? nullableCoord : geoPoints.get(0);
    }

    public static Route getFirstRoute(List<Route> routes) {
        return (routes == null || routes.isEmpty()) ? nullableRoute : routes.get(0);
    }

    public static Task getFirstTask(List<Task> tasks) {
        return (tasks == null || tasks.isEmpty()) ? nullableTask : tasks.get(0);
    }*/
    //</editor-fold>
}
