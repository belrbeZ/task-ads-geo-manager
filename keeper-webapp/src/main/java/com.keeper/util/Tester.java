package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.entity.ModelManager;
import com.keeper.entity.dao.UserTest;
import com.keeper.entity.dao.ZoneTest;
import com.keeper.entity.dto.UserTestDTO;
import com.keeper.entity.dto.ZoneTestDTO;
import com.keeper.entity.states.UserType;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Default Comment
 */
public class Tester {

    public static UserTestDTO testSampleUserDTO() {
        return new UserTestDTO((long) 1,
                UserType.USER,
                "Bobby",
                "superbob@mail.ru",
                "+77795435",
                "My name is Bobby and I'll test the shit out of you!",
                false);
    }

    public static ZoneTestDTO testSampleZoneDTO() {
        return new ZoneTestDTO((long) 1,
                "Saint-Petersburg",
                "Mother Russia",
                Timestamp.valueOf(LocalDateTime.now()));
    }

    public static ZoneTest testSampleZoneDAO() {
        try {
            return new ZoneTest((long) 1,
                    "Saint-Petersburg",
                    "Mother Russia");
        } catch (NullAttributeException e) {
            ModelManager.logSetupError(e);
        }
        return ZoneTest.empty;
    }

    public static UserTest testSampleUserDAO() {
        try {
            return new UserTest(UserType.USER,
                    "Bobby",
                    "superbob@mail.ru",
                    "+77795435",
                    "superBobbyPass",
                    "My name is Bobby and I'll test the shit out of you!");
        } catch (NullAttributeException e) {
            ModelManager.logSetupError(e);
        }
        return UserTest.empty;
    }
}
