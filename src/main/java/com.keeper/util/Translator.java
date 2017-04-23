package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.model.SimpleGeoPoint;
import com.keeper.model.dao.*;
import com.keeper.model.dto.*;
import com.keeper.model.types.UserType;
import com.keeper.test.model.dao.UserTest;
import com.keeper.test.model.dao.ZoneTest;
import com.keeper.test.model.dto.UserTestDTO;
import com.keeper.test.model.dto.ZoneTestDTO;

import java.time.LocalDateTime;
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
                : new TaskDTO(model.getTopicStarterId(),
                            model.getTopicStarterId(),
                            model.getType(),
                            model.getState(),
                            model.getTheme(),
                            model.getDescr(),
                            Translator.convertToDTO(model.getPicture())
                            /*convertUsersToDTO(model.getParticipants()),
                            convertCommentsToDTO(model.getComments()),
                            convertTagsToDTO(model.getTags()),
                            convertToDTO(model.getPicture())*/
        );
    }

    public static GeoPointDTO convertToDTO(GeoPoint model) {
        return (model == null)
                ? GeoPointDTO.EMPTY
                : new GeoPointDTO(model.getId(),
                                model.getLatitude().toString(),
                                model.getLongitude().toString(),
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
                            (model.getMuteStart() != null)
                                    ? model.getMuteStart().toLocalDateTime()
                                    : LocalDateTime.MIN,
                            (model.getMuteEnd() != null)
                                    ? model.getMuteEnd().toLocalDateTime()
                                    : LocalDateTime.MIN,
                            Translator.convertToDTO(model.getPic()),
                            convertToDTO(model.getZone()),
                            convertGeoToDTO(model.getGeoPoints()),
                            convertRoutesToDTO(model.getRoutes())/*,
                            convertTasksToDTO(model.getParticipantedTasks())*/
        );
    }

    public static ZoneDTO convertToDTO(Zone model) {
        return (model == null)
                ? ZoneDTO.EMPTY
                : new ZoneDTO(model.getProfileId(),
                            model.getCity(),
                            model.getCountry(),
                            model.getRegisterDate());
    }

    public static PictureDTO convertToDTO(Picture model) {
        return (model == null)
                ? PictureDTO.EMPTY
                : new PictureDTO(model.getUserId(),
                                model.getTaskId(),
                                model.getPic(),
                                model.getInfo());
    }

    public static CommentDTO convertToDTO(Comment model) {
        return (model == null)
                ? CommentDTO.EMPTY
                : new CommentDTO(model.getTaskId(),
                                model.getUserId(),
                                model.getCreateDate(),
                                model.getLastModifyDate(),
                                model.getMessage(),
                                new SimpleGeoPoint(model.getLongtitude(), model.getLatitude())
        );
    }

    public static RouteDTO convertToDTO(Route model) {
//        System.out.println("convertToDTO(Route model)"+model.getLatitudes()[0]);
        return (model == null)
                ? RouteDTO.EMPTY
                : new RouteDTO(model.getId(),
                                model.getUserId(),
                                model.getType(),
                                model.getInfo(),
                                model.getLatitudes(),
                                model.getLongtitudes());
    }

    public static TagDTO convertToDTO(Tag model) {
        return (model == null)
                ? TagDTO.EMPTY
                : new TagDTO(model.getTaskId(),
                            model.getValue(),
                            model.getCounter()
        );
    }

    //<editor-fold desc="Lists">
    public static List<PictureDTO> convertPicturesToDTO (List<Picture> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<CommentDTO> convertCommentsToDTO (List<Comment> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<TagDTO> convertTagsToDTO (List<Tag> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<UserDTO> convertUsersToDTO (List<User> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<TaskDTO> convertTasksToDTO(List<Task> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<GeoPointDTO> convertGeoToDTO(List<GeoPoint> models) {
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<RouteDTO> convertRoutesToDTO(List<Route> models) {
//        System.out.println("convertRoutesToDTO");
        return models.stream().map(Translator::convertToDTO).collect(Collectors.toList());
    }

    public static List<SimpleGeoPoint> convertToSimpleGeoPoints(String[] latitude,
                                                                String[] longtitude) {
        if(latitude == null || longtitude == null || latitude.length != longtitude.length)
            return null;

        List<SimpleGeoPoint> geoPoints = new ArrayList<>();

        for(int i = 0; i < latitude.length; i ++)
            geoPoints.add(new SimpleGeoPoint(latitude[i], longtitude[i]));

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

    public static User convertToDAO(UserFormDTO model) {
        return (model == null)
                ? User.EMPTY
                : new User(UserType.USER,
                            model.getName(),
                            model.getEmail(),
                            "",
                            model.getPassword(),
                            "");
    }

    public static Task convertToDAO(TaskDTO model) {
        return (model == null)
                ? Task.EMPTY
                : new Task(model.getTopicStarterId(),
                            model.getOriginGeoPointId(),
                            model.getType(),
                            model.getState(),
                            model.getTheme(),
                            model.getDescr(),
                            Translator.convertToDAO(model.getPicture())
                );
    }

    public static GeoPoint convertToDAO(GeoPointDTO model) {
        return (model == null)
                ? GeoPoint.EMPTY
                : new GeoPoint(model.getLatitude(),
                                model.getLongitude(),
                                model.getRadius(),
                                model.getInfo());
    }

    public static Route convertToDAO(RouteDTO model) {
        return (model == null)
                ? Route.EMPTY
                : new Route(model.getType(),
                            model.getInfo(),
                            model.getPoints());
    }

    public static Zone convertToDAO(ZoneDTO model) {
        return (model == null)
                ? Zone.EMPTY
                : new Zone(
                        model.getprofileId(),
                        model.getCity(),
                        model.getCountry()
//                        ,model.getRegisterDate().toLocalDateTime()
        );
    }

    public static Picture convertToDAO(PictureDTO model) {
        return (model == null)
                ? Picture.EMPTY
                : new Picture(
                model.getUserId(),
                model.getTaskId(),
                model.getPic(),
                model.getInfo()
        );
    }

    public static Comment convertToDAO(CommentDTO model) {
        return (model == null)
                ? Comment.EMPTY
                : new Comment(
                model.getUserId(),
                model.getTaskId(),
                model.getCreateDate(),
                model.getMessage(),
                new SimpleGeoPoint(model.getLongtitude(), model.getLatitude())
        );
    }
    //</editor-fold>
}
