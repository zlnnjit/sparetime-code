/*
 * Copyright © 2019 fnii and others.  All rights reserved.
 */

package top.bcoder.test.service.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zln
 * @date 2019/7/23
 */
public final class DateUtils {

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final int NS_TO_MS = 1000000;
    /**
     * 每天凌晨0点01分运行
     */
    public static final String CRON1 = "0 1 0 * * ?";

    /**
     * 每天凌晨0点31分运行
     */
    public static final String CRON2 = "0 31 0 * * ?";

    /**
     * 每分钟执行一次
     */
    public static final String CRON3 = "0 */1 * * * ?";

    /**
     * 每20分钟执行一次
     */
    public static final String CRON4 = "0 0/20 * * * ?";

    /**
     * 每秒执行一次
     */
    public static final String CRON5 = "*/5 * * * * ?";


    private DateUtils() {
    }


    /**
     * 获取格式化过的时间,eg:2019-09-08 11:11:11
     */
    public static String getNowTimeFormat() {
        return DATE_TIME_FORMAT.format(LocalDateTime.now());
    }

    /**
     * LocalDateTime转时间戳(秒级)
     */
    public static Long localDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }

    public static Integer getDuration(Instant startTime, Instant endTime) {
        return Duration.between(startTime, endTime).getNano() / NS_TO_MS;
    }

    /**
     * 将LocalDateTime的时间变为整分
     */
    public static LocalDateTime localDateTimeZeroSecond(LocalDateTime localDateTime) {
        localDateTime = localDateTime.minusNanos(localDateTime.getNano());
        return localDateTime.minusSeconds(localDateTime.getSecond());
    }

    /**
     * 将LocalDateTime的时间变为整小时
     */
    public static LocalDateTime localDateTimeZeroMinute(LocalDateTime localDateTime) {
        localDateTime = localDateTime.minusNanos(localDateTime.getNano());
        localDateTime = localDateTime.minusSeconds(localDateTime.getSecond());
        return localDateTime.minusMinutes(localDateTime.getMinute());
    }

    /**
     * 将LocalDateTime对象转换为Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }


    /**
     *
     */
    public static Boolean isBewteen(LocalDateTime cur, LocalDateTime start, LocalDateTime end) {
        return !(cur.isBefore(start) && cur.isAfter(end));

    }

    /**
     * 获取精确到秒的时间戳
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }
}
