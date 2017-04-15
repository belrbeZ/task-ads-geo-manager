package com.keeper.util;

/*
 * Created by @GoodforGod on 7.04.2017.
 */

import org.mindrot.jbcrypt.BCrypt;
import net.jpountz.xxhash.*;

import java.io.UnsupportedEncodingException;

/**
 * Used to Validate and Generate Hashes (for password as example)
 */
public class Hasher {

    public enum HashType {
        // Values are SALT used for hash generation
        COMMON(11),
        PASS(17),
        EMAIL(13);

        private final int value;

        HashType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    //<editor-fold desc="Hashes">

    private static final String EMPTY_HASH = "";

    private static final XXHashFactory hashFactory = XXHashFactory.fastestInstance();
    private static final long SEED = 0x57a1cc61;
    private static final String ENCODING = "UTF-8";

    public static Long generateHashSimple(String value, HashType type) {
        try {
            byte[] data = value.getBytes(ENCODING);
            return hashFactory.hash64().hash(data, 0, data.length, SEED);
        } catch (UnsupportedEncodingException e) {
            return 0L;
        }
    }

    public static String generateHashCrypto(String value, HashType type) {
        return (value == null || value.isEmpty())
                ? EMPTY_HASH
                : BCrypt.hashpw(value, BCrypt.gensalt(type.getValue()));
    }

    public static boolean validateHashCrypto(String candidate, String hash) throws NullPointerException {
        if(candidate == null || candidate.isEmpty())
            throw new NullPointerException("CANDIDATE");

        if(hash == null || hash.isEmpty())
            throw new NullPointerException("HASH");

        return BCrypt.checkpw(candidate, hash);
    }
    //</editor-fold>
}
