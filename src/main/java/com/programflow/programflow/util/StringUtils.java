package com.programflow.programflow.util;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class StringUtils {

    private final static String MASKING_CHAR = "*";

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String mask(String pan) {

        if (pan == null || pan.length() < 10) {
            throw new IllegalArgumentException(
                    "Argument should be longer than 10 chars, not valid argument= " + pan);
        }

        int length = pan.length();
        String fillStr = fillChar(MASKING_CHAR, length - 10);
        StringBuilder maskPan = new StringBuilder(pan);
        maskPan.replace(6, length - 4, fillStr);

        return maskPan.toString();
    }

    public static String fillChar(String chr, int size) {

        return Stream.generate(() -> chr).limit(size).collect(joining(""));
    }

}
