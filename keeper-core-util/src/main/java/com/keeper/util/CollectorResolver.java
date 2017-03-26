package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Help to resolve and work with entity collections
 */
public class CollectorResolver {

    //<editor-fold desc="makeList">
    private static final List<String>       nullableStringList  = null;
    private static final List<Route>        nullableRouteList   = null;
    private static final List<Long>      nullableIdList      = null;
    private static final List<Location>     nullableLocationList = null;
    private static final List<Coordinate>   nullableCoordList   = null;
    private static final List<User>         nullableUserList    = null;
    private static final List<Task>         nullableTaskList    = null;

    public static List<Long> makeIdList(final Long value) {
        return value != null ? new ArrayList<Long>() {{ add(value); }} : nullableIdList;
    }

    public static List<String> makeStringList(final String value) {
        return value != null ? new ArrayList<String>() {{add(value);}} : nullableStringList;
    }

    public static List<Coordinate> makeCoordList(final Coordinate value) {
        return value != null ? new ArrayList<Coordinate>() {{ add(value);}} : nullableCoordList;
    }

    public static List<Route> makeRouteList(final Route value) {
        return value != null ? new ArrayList<Route>() {{add(value);}} : nullableRouteList;
    }

    public static List<Location> makeLocationList(final Location value) {
        return value != null ? new ArrayList<Location>() {{add(value);}} : nullableLocationList;
    }

    public static List<User> makeUserList(final User value) {
        return value != null ? new ArrayList<User>() {{add(value);}} : nullableUserList;
    }

    public static List<Task> makeTaskList(final Task value) {
        return value != null ? new ArrayList<Task>() {{add(value);}} : nullableTaskList;
    }
    //</editor-fold>

    //<editor-fold desc="getFirst">
    private static final User         nullableUser    = User.empty;
    private static final Task         nullableTask    = Task.empty;
    private static final Route        nullableRoute   = Route.empty;
    private static final Coordinate   nullableCoord   = Coordinate.empty;
    private static final Location     nullableLocation = Location.empty;

    public static User getFirstUser(List<User> users) {
        return (users == null || users.isEmpty()) ? nullableUser : users.get(0);
    }

    public static Location getFirstLocation(List<Location> locations) {
        return (locations == null || locations.isEmpty()) ? nullableLocation : locations.get(0);
    }

    public static Coordinate getFirstCoordinate(List<Coordinate> coordinates) {
        return (coordinates == null || coordinates.isEmpty()) ? nullableCoord : coordinates.get(0);
    }

    public static Route getFirstRoute(List<Route> routes) {
        return (routes == null || routes.isEmpty()) ? nullableRoute : routes.get(0);
    }

    public static Task getFirstTask(List<Task> tasks) {
        return (tasks == null || tasks.isEmpty()) ? nullableTask : tasks.get(0);
    }
    //</editor-fold>
}
