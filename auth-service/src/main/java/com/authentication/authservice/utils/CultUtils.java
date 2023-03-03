package com.authentication.authservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CultUtils {
    public static String getTimeStamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
