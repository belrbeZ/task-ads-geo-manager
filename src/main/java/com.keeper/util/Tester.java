package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import com.keeper.model.ModelManager;
import com.keeper.model.dao.UserTest;
import com.keeper.model.dao.ZoneTest;
import com.keeper.model.dto.UserTestDTO;
import com.keeper.model.dto.ZoneTestDTO;
import com.keeper.model.types.UserType;

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
        } catch (NullPointerException e) {
            ModelManager.logSetupError(e);
        }
        return ZoneTest.EMPTY;
    }

    public static UserTest testSampleUserDAO() {
        try {
            return new UserTest(UserType.USER,
                    "Bobby",
                    "superbob@mail.ru",
                    "+77795435",
                    "superBobbyPass",
                    "My name is Bobby and I'll test the shit out of you!") {{ setId((long) 1); }};
        } catch (NullPointerException e) {
            ModelManager.logSetupError(e);
        }
        return UserTest.EMPTY;
    }
}
