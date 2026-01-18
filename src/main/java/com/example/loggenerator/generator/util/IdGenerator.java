package com.example.loggenerator.generator.util;

import java.util.UUID;

public class IdGenerator {
    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    private static String[] getUuidParts() {
        String uuid = getUuid();
        return uuid.split("-");
    }

    public static String getUuid4Digits() {
        String[] parts = getUuidParts();
        return parts[1];
    }

    public static String getUuid8Digits() {
        String[] parts = getUuidParts();
        return parts[0];
    }

    public static String getUuid12Digits() {
        String[] parts = getUuidParts();
        return parts[4];
    }
}
