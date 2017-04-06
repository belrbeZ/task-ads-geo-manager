package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Default Comment
 */
public class Validator {

    public enum HashType {
        PASS(0),
        EMAIL(1);

        private final int value;

        HashType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static final String EMPTY_HASH = "";

    private static final Integer SALT_PASS = 17;
    private static final Integer SALT_MAIL = 13;

    public static String generateHashcode(String value, HashType type) {

        if(value == null || value.isEmpty())
            return EMPTY_HASH;

        switch (type) {
            case PASS:  return BCrypt.hashpw(value, BCrypt.gensalt(SALT_PASS));
            case EMAIL: return BCrypt.hashpw(value, BCrypt.gensalt(SALT_MAIL));
            default:    return EMPTY_HASH;
        }
    }

    public static boolean validateHashcode(String candidate, String hash) throws NullAttributeException {

        if(candidate == null || candidate.isEmpty())
            throw new NullAttributeException("Nullable", "CANDIDATE");

        if(hash == null || hash.isEmpty())
            throw new NullAttributeException("Nullable", "HASH");

        return BCrypt.checkpw(candidate, hash);
    }
}
