package com.programflow.programflow.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import static java.lang.String.format;

public class NumberUtils {

    private static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private NumberUtils() throws NoSuchAlgorithmException {
        throw new IllegalStateException("Utility class");
    }

    public static int getRandomNumber() {

        // It will generate 6 digit random Number.
        // from 0 to 999999
        return rand.nextInt(999999);
    }

    public static String getRandomNumberString() {
        // this will convert any number sequence into 6 character.
        return format("%06d", getRandomNumber());
    }
}
