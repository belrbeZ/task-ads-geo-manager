package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.test.model.dao.UserTest;
import com.keeper.model.dao.Zone;
import com.keeper.test.model.dao.ZoneTest;
import com.keeper.model.dto.UserDTO;
import com.keeper.test.model.dto.UserTestDTO;
import com.keeper.model.dto.ZoneDTO;
import com.keeper.test.model.dto.ZoneTestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Translate and full fill DTO object to DAO object and revert
 */
public class Translator {
    //<editor-fold desc="toDTO">

    public static TaskDTO convertToDTO(Task model) {
        return (model == null)
                ? TaskDTO.EMPTY
                : new TaskDTO(
                        model.getTopicStarterId(),
                        model.getType(),
                        model.getState(),
                        model.getTheme(),
                        model.getDescr());
    }

    public static GeoPointDTO convertToDTO(GeoPoint model) {
        return (model == null)
                ? GeoPointDTO.EMPTY
                : new GeoPointDTO(
                        model.getId(),
                        model.getLatitude(),
                        model.getLongitude(),
                        model.getRadius(),
                        model.getInfo());
    }

    public static UserDTO convertToDTO(User model) {
        return (model == null)
                ? UserDTO.EMPTY
                : new UserDTO(model.getId(),
                            model.getType(),
                            model.getState(),
                            model.getName(),
                            model.getEmail(),
                            model.getPhone(),
                            model.getPassword(),
                            model.getAbout(),
                            model.getNotified(),
                            model.getMuteStart().toLocalDateTime(),
                            model.getMuteEnd().toLocalDateTime());
    }

    public static ZoneDTO convertToDTO(Zone model) {
        return (model == null)
                ? ZoneDTO.EMPTY
                : new ZoneDTO(model.getProfileId(),
                            model.getCity(),
                            model.getCountry(),
                            model.getRegisterDate());
    }

    //<editor-fold desc="Lists">

    public static List<TaskDTO> convertTasksToDTO(List<Task> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<GeoPointDTO> convertGeoToDTO(List<GeoPoint> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<SimpleGeoPoint> convertToSimpleGeoPoints(List<String> latitude,
                                                                List<String> longtitude) {
        if(latitude == null || longtitude == null || latitude.size() != longtitude.size())
            return null;

        List<SimpleGeoPoint> geoPoints = new ArrayList<>();

        for(int i = 0; i < latitude.size(); i ++)
            geoPoints.add(new SimpleGeoPoint(latitude.get(i), longtitude.get(i)));

        return geoPoints;
    }

    //</editor-fold>

    //<editor-fold desc="Testing">

    public static UserTestDTO convertToDTO(UserTest model) {
        return (model == null)
                ? UserTestDTO.EMPTY
                : new UserTestDTO(model.getId(),
                model.getType(),
                model.getState(),
                model.getName(),
                model.getMaskedEmail(),
                model.getPhone(),
                model.getAbout(),
                model.getNotified(),
                model.getMuteStart().toLocalDateTime(),
                model.getMuteEnd().toLocalDateTime());
    }

    public static ZoneTestDTO convertToDTO(ZoneTest model) {
        return (model == null)
                ? ZoneTestDTO.EMPTY
                : new ZoneTestDTO(model.getUserId(),
                model.getCity(),
                model.getCountry(),
                model.getRegisterDate());
    }
    //</editor-fold>

    //</editor-fold>

    //<editor-fold desc="toDAO">

    public static User convertToDAO(UserDTO model) {
        return (model == null)
                ? User.EMPTY
                : new User(model.getType(),
                            model.getName(),
                            model.getEmail(),
                            model.getPhone(),
                            model.getPassword(),
                            model.getAbout(),
                            model.getNotified(),
                            model.getMuteStart(),
                            model.getMuteEnd());
    }

    public static Task convertToDAO(TaskDTO model) {
        return (model == null)
                ? Task.EMPTY
                : new Task(
                model.getTopicStarterId(),
                model.getType(),
                model.getState(),
                model.getTheme(),
                model.getDescr());
    }

    public static GeoPoint convertToDAO(GeoPointDTO model) {
        return (model == null)
                ? GeoPoint.EMPTY
                : new GeoPoint(
                model.getLatitude(),
                model.getLongitude(),
                model.getRadius(),
                model.getInfo());
    }
    //</editor-fold>
}
