package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.model.dao.User;
import com.keeper.model.test.UserTest;
import com.keeper.model.dao.Zone;
import com.keeper.model.test.ZoneTest;
import com.keeper.model.dto.UserDTO;
import com.keeper.model.test.UserTestDTO;
import com.keeper.model.dto.ZoneDTO;
import com.keeper.model.test.ZoneTestDTO;

/**
 * Translate and full fill DTO object to DAO object and revert
 */
public class Translator {
    //<editor-fold desc="toDTO">

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

    public static UserDTO convertToDTO(User model) {
        return (model == null)
                ? UserDTO.EMPTY
                : new UserDTO(model.getId(),
                model.getType(),
                model.getState(),
                model.getName(),
                model.getMaskedEmail(),
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
                : new ZoneDTO(model.getUserId(),
                model.getCity(),
                model.getCountry(),
                model.getRegisterDate());
    }

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
    //</editor-fold>
}
