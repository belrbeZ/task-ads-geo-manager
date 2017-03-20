package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.entity.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Help to resolve and work with entity collections
 */
public class CollectorResolver {

    //<editor-fold desc="makeList">
    private static List<Route>        nullableRouteList   = null;
    private static List<Integer>      nullableIdList      = null;
    private static List<Location>     nullableLocationList = null;
    private static List<Coordinate>   nullableCoordList   = null;
    private static List<User>         nullableUserList    = null;
    private static List<Task>         nullableTaskList    = null;

    public static List<Integer> makeIdList(final Integer value) {
        return value != null ? new ArrayList<Integer>() {{ add(value); }} : nullableIdList;
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

    public static User getFirstUser(List<User> users) {
        return (users == null || users.isEmpty()) ? User.emptyUser : users.get(0);
    }

    public static Location getFirstLocation(List<Location> locations) {
        return (locations == null || locations.isEmpty()) ? Location.emptyLocation : locations.get(0);
    }

    public static Coordinate getFirstCoordinate(List<Coordinate> coordinates) {
        return (coordinates == null || coordinates.isEmpty()) ? Coordinate.emptyCoordinate : coordinates.get(0);
    }

    public static Route getFirstRoute(List<Route> routes) {
        return (routes == null || routes.isEmpty()) ? Route.emptyRoute : routes.get(0);
    }

    public static Task getFirstTask(List<Task> tasks) {
        return (tasks == null || tasks.isEmpty()) ? Task.emptyTask : tasks.get(0);
    }
    //</editor-fold>
}
