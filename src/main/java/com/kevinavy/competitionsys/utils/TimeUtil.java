package com.kevinavy.competitionsys.utils;

import java.sql.Timestamp;

public class TimeUtil {
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
