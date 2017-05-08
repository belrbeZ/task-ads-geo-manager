package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.*;
import com.keeper.model.dto.*;
import com.keeper.model.types.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Translate and full fill DTO object to DAO object and revert
 */
public class Translator {

    //<editor-fold desc="toDTO">

    public static TaskDTO toDTO(Task model) {
        return (model == null)
                ? TaskDTO.EMPTY
                : new TaskDTO(model.getId(),
                            model.getTopicStarterId(),
                            model.getType(),
                            model.getState(),
                            model.getTheme(),
                            model.getDescr(),
                            model.getLatitude(),
                            model.getLongitude(),
                            model.getRadius(),
                            toDTO(model.getPicture()),
                            model.getCreateDate(),
                            model.getLastModifyDate(),
                            commentsToDTO(model.getComments()),
                            usersToDTO(model.getParticipants()),
                            tagsToDTO(model.getTags()));
    }

    public static GeoPointDTO toDTO(GeoPoint model) {
        return (model == null)
                ? GeoPointDTO.EMPTY
                : new GeoPointDTO(model.getId(),
                                model.getUserId(),
                                model.getLatitude().toString(),
                                model.getLongitude().toString(),
                                model.getRadius(),
                                model.getDescr());
    }

    public static UserDTO toDTO(User model) {
        return (model == null)
                ? UserDTO.EMPTY
                : new UserDTO(model.getId(),
                            model.getType(),
                            model.getName(),
                            model.getEmail(),
                            model.getPhone(),
                            model.getAbout(),
                            model.getPassword(),
                            model.getNotified(),
                            model.getMuteEnd(),
                            toDTO(model.getPic()),
                            toDTO(model.getZone()),
                            geoPointsToDTO(model.getGeoPoints()),
                            routesToDTO(model.getRoutes()));
    }

    public static ZoneDTO toDTO(Zone model) {
        return (model == null)
                ? ZoneDTO.EMPTY
                : new ZoneDTO(model.getProfileId(),
                            model.getCity(),
                            model.getCountry(),
                            model.getRegisterDate());
    }

    public static PictureDTO toDTO(Picture model) {
        return (model == null)
                ? PictureDTO.EMPTY
                : new PictureDTO(model.getUserId(),
                                model.getTaskId(),
                                model.getPic(),
                                model.getInfo());
    }

    public static CommentDTO toDTO(Comment model) {
        return (model == null)
                ? CommentDTO.EMPTY
                : new CommentDTO(model.getId(),
                                model.getTaskId(),
                                model.getUserId(),
                                model.getCreateDate(),
                                model.getLastModifyDate(),
                                model.getMessage(),
                                model.getLongtitude(), model.getLatitude());
    }

    public static RouteDTO toDTO(Route model) {
        return (model == null)
                ? RouteDTO.EMPTY
                : new RouteDTO(model.getId(),
                                model.getUserId(),
                                model.getType(),
                                model.getInfo(),
                                model.getRadius(),
                                model.getLatitudes(),
                                model.getLongtitudes());
    }

    public static TagDTO toDTO(Tag model) {
        return (model == null)
                ? TagDTO.EMPTY
                : new TagDTO(model.getId(),
                            model.getTag(),
                            model.getCounter()
        );
    }

    //</editor-fold>

    //<editor-fold desc="toListsDTO">

    public static List<PictureDTO> picsToDTO(List<Picture> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<CommentDTO> commentsToDTO(List<Comment> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<TagDTO> tagsToDTO(List<Tag> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<UserDTO> usersToDTO(List<User> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<TaskDTO> tasksToDTO(List<Task> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<GeoPointDTO> geoPointsToDTO(List<GeoPoint> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<RouteDTO> routesToDTO(List<Route> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDTO).collect(Collectors.toList());
    }

    public static List<Comment> commentsToDAO(List<CommentDTO> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(Translator::toDAO).collect(Collectors.toList());
    }

    public static List<SimpleGeoPoint> toSimpleGeoPoints(String[] latitude, String[] longtitude) {
        List<SimpleGeoPoint> geoPoints = new ArrayList<>();

        if(latitude == null || longtitude == null || latitude.length != longtitude.length)
            return geoPoints;

        for(int i = 0; i < latitude.length; i ++)
            geoPoints.add(new SimpleGeoPoint(latitude[i], longtitude[i]));

        return geoPoints;
    }

    //</editor-fold>

    //<editor-fold desc="toDAO">

    public static User toDAO(UserDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new User(model.getType(),
                        model.getName(),
                        model.getEmail(),
                        model.getPhone(),
                        model.getPassword(),
                        model.getAbout(),
                        model.getNotified(),
                        model.getMuteEnd());
    }

    public static Tag toDAO(TagDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new Tag(model.getId(),
                        model.getTag(),
                        model.getCounter());
    }

    public static User toDAO(UserFormDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new User(UserType.USER,
                        model.getName(),
                        model.getEmail(),
                        "",
                        model.getPassword(),
                        "");
    }

    public static Task toDAO(TaskDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new Task(model.getTopicStarterId(),
                    model.getType(),
                    model.getState(),
                    model.getTheme(),
                    model.getDescr(),
                    model.getGeo());
    }

    public static GeoPoint toDAO(GeoPointDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new GeoPoint(model.getUserId(),
                              model.getLatitude(),
                              model.getLongitude(),
                              model.getRadius(),
                              model.getDescr());
    }

    public static Route toDAO(RouteDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new Route(model.getUserId(),
                    model.getType(),
                    model.getInfo(),
                    model.getRadius(),
                    model.getPoints());
    }

    public static Zone toDAO(ZoneDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new Zone(model.getprofileId(),
                       model.getCity(),
                       model.getCountry()
        );
    }

    public static Picture toDAO(PictureDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new Picture(model.getUserId(),
                      model.getTaskId(),
                      model.getPic(),
                      model.getInfo()
        );
    }

    public static Comment toDAO(CommentDTO model) {
        if(model == null)
            throw new NullPointerException();

        return new Comment(model.getTaskId(),
                            model.getUserId(),
                            model.getMessage(),
                            model.getGeo());
    }
    //</editor-fold>
}
