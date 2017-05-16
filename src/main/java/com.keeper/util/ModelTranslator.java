package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.model.dao.*;
import com.keeper.model.dto.*;
import com.keeper.model.types.UserType;
import com.keeper.model.util.SimpleGeoPoint;
import com.keeper.model.util.TaskModification;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.keeper.util.Validator.*;

/**
 * Translate and full fill DTO object to DAO object and revert
 */
public class ModelTranslator {

    //<editor-fold desc="toDTO">

    public static TaskModification toDTO(Participant model) {
        return (model == null)
                ? TaskModification.EMPTY
                : new TaskModification(model.getId(),
                                        model.getTaskId(),
                                        model.getModifyCounter(),
                                        model.getLastModifyDate().toLocalDateTime());
    }

    public static TaskDTO toDTO(Task model) {
        return (model == null)
                ? TaskDTO.EMPTY
                : new TaskDTO(model.getId(),
                            model.getTopicStarterId(),
                            model.getType(),
                            model.getTheme(),
                            model.getDescr(),
                            model.getGeo(),
                            toDTO(model.getPicture()),
                            model.getCreateDate(),
                            model.getLastModifyDate(),
                            commentsToDTO(model.getComments()),
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
                            toDTO(model.getZone())/*,
                            geoPointsToDTO(model.getGeoPoints()),
                            routesToDTO(model.getRoutes())*/);
    }

    public static ZoneDTO toDTO(Zone model) {
        return (model == null)
                ? ZoneDTO.EMPTY
                : new ZoneDTO(model.getUserId(),
                            model.getCity(),
                            model.getCountry(),
                            model.getRegisterDate());
    }

    public static PictureDTO toDTO(Picture model) {
        return (model == null)
                ? PictureDTO.EMPTY
                : new PictureDTO(model.getId(),
                                model.getUserId(),
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
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<CommentDTO> commentsToDTO(List<Comment> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<TagDTO> tagsToDTO(List<Tag> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<UserDTO> usersToDTO(List<User> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<TaskDTO> tasksToDTO(List<Task> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<GeoPointDTO> geoPointsToDTO(List<GeoPoint> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<RouteDTO> routesToDTO(List<Route> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDTO).collect(Collectors.toList());
    }

    public static List<Comment> commentsToDAO(List<CommentDTO> models) {
        return (models == null)
                ? Collections.emptyList()
                : models.stream().map(ModelTranslator::toDAO).collect(Collectors.toList());
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

    public static Participant toDAO(TaskModification model, Long userId) {
        if(model == null)
            throw new NullPointerException("MODEL");

        if(Validator.isIdValid(userId))
            throw new NullPointerException("USER ID");

        return new Participant(model, userId);

    }

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

        return new Zone(model.getProfileId(),
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

    //<editor-fold desc="DAO update strategy">

    public static User updateDAO(User dao, UserDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        dao.setEmail(isEmailValid(dto.getEmail()) ? dto.getEmail() : dao.getEmail());
        dao.setName(!isStrEmpty(dto.getName()) ? dto.getName() : dao.getName());
        dao.setAbout(!isStrEmpty(dto.getAbout()) ? dto.getAbout() : dao.getAbout());
        dao.setPhone(isPhoneValid(dto.getPhone()) ? dto.getPhone() : dao.getPhone());
        dao.setPassword(isPassValid(dto.getPassword()) ? dto.getPassword() : dao.getPassword());
        dao.setNotified((dto.getNotified() != null) ? dto.getNotified() : dao.getNotified());
        dao.setMuteEnd((dto.getMuteEnd() != null && dto.getMuteEnd().isAfter(LocalDateTime.now())) ? Timestamp.valueOf(dto.getMuteEnd()) : dao.getMuteEnd());
        dao.setType(dto.getType() != null ? dto.getType() : dao.getType());

        return dao;
    }

    public static Tag updateDAO(Tag dao, TagDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        dao.setCounter((dto.getCounter() != null && dto.getCounter() >= 0) ? dto.getCounter() : dao.getCounter());
        dao.setTag((!isStrEmpty(dto.getTag())) ? dto.getTag() : dao.getTag());

        return dao;
    }

    public static Task updateDAO(Task dao, TaskDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        if(!Objects.equals(dao.getTopicStarterId(), dto.getTopicStarterId()))
            throw new NumberFormatException("DAO TopicStarterId differ from DTO TopicStarterId");

        dao.setGeo((dto.getGeo() != null) ? dto.getGeo() : dao.getGeo());
        dao.setDescr((!isStrEmpty(dto.getDescr())) ? dto.getDescr() : dao.getDescr());
        dao.setTheme((!isStrEmpty(dto.getTheme())) ? dto.getTheme() : dao.getDescr());
        dao.setType((dto.getType() != null) ? dto.getType() : dao.getType());

        return dao;
    }

    public static GeoPoint updateDAO(GeoPoint dao, GeoPointDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        dao.setLatitude((isGeoValid(dto.getLatitude().toString())) ? dto.getLatitude() : dao.getLatitude());
        dao.setLongitude((isGeoValid(dto.getLongitude().toString())) ? dto.getLongitude() : dao.getLongitude());
        dao.setDescr((!isStrEmpty(dto.getDescr())) ? dto.getDescr() : dao.getDescr());
        dao.setRadius((dto.getRadius() != null && dto.getRadius() > 0) ? dto.getRadius() : dao.getRadius());

        return dao;
    }

    public static Route updateDAO(Route dao, RouteDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        if(!Objects.equals(dao.getUserId(), dto.getUserId()))
            throw new NumberFormatException("DAO UserId differ from DTO UserId");

        dao.setRadius((dto.getRadius() != null && dto.getRadius() > 0) ? dto.getRadius() : dao.getRadius());
        dao.setInfo((!isStrEmpty(dto.getInfo())) ? dto.getInfo() : dao.getInfo());
        dao.setLatitudes((isGeoDoubleValid(dto.getLatitudes())) ? dto.getLatitudes().stream().toArray(String[]::new) : dao.getLatitudes());
        dao.setLongtitudes((isGeoDoubleValid(dto.getLongitudes())) ? dto.getLongitudes().stream().toArray(String[]::new) : dao.getLongtitudes());
        dao.setType((dto.getType() != null) ? dto.getType() : dao.getType());

        return dao;
    }

    public static Zone updateDAO(Zone dao, ZoneDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getUserId(), dto.getProfileId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        dao.setCity(!isStrEmpty(dto.getCity()) ? dto.getCity() : dao.getCity());
        dao.setCountry((!isStrEmpty(dto.getCity())) ? dto.getCity() : dao.getCity());

        return dao;
    }

    public static Picture updateDAO(Picture dao, PictureDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        if(!Objects.equals(dao.getUserId(), dto.getUserId()))
            throw new NumberFormatException("DAO UserId differ from DTO UserId");

        if(!Objects.equals(dao.getTaskId(), dto.getTaskId()))
            throw new NumberFormatException("DAO TaskId differ from DTO TaskId");

        dao.setInfo(!isStrEmpty(dto.getInfo()) ? dto.getInfo() : dao.getInfo());
        dao.setPic(!isStrEmpty(dto.getPic()) ? dto.getPic() : dao.getPic());

        return dao;
    }

    public static Comment updateDAO(Comment dao, CommentDTO dto) throws NullPointerException, NumberFormatException {
        if(dto == null)
            throw new NullPointerException("NULLABLE dto");

        if(dao == null)
            throw new NullPointerException("NULLABLE dao");

        if(!Objects.equals(dao.getId(), dto.getId()))
            throw new NumberFormatException("DAO id differ from DTO id");

        if(!Objects.equals(dao.getUserId(), dto.getUserId()))
            throw new NumberFormatException("DAO UserId differ from DTO UserId");

        if(!Objects.equals(dao.getTaskId(), dto.getTaskId()))
            throw new NumberFormatException("DAO TaskId differ from DTO TaskId");

        dao.setMessage(!isStrEmpty(dto.getMessage()) ? dto.getMessage() : dao.getMessage());

        return dao;
    }
    //</editor-fold>
}
