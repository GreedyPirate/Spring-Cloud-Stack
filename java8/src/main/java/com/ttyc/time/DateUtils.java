package com.ttyc.time;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * 舍弃对Calendar，joda-time的依赖，用java 8重写
 *
 * @author yangjie
 * @createTime 2019/1/17
 * @since 1.0.0
 */
public class DateUtils {

    public static LocalDate today = LocalDate.now();

    public static LocalDateTime now = LocalDateTime.now();

    public static final String GENERAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String GENERAL_DATE_PATTERN = "yyyy-MM-dd";

    public static final long MAX_TIME_STAMP = 10000_000_000L;

    public static final long MIN_TIME_STAMP = 1000_000_000L;

    /***
     * 分别获取年月日的值
     * @return
     */
    public static <L, M, R> Triple<Integer, Integer, Integer> getYearMonthDay() {
        return ImmutableTriple.of(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
    }

    /**
     * 获取日期文本
     */
    public static String getDateText() {
        return today.format(DateTimeFormatter.ofPattern(GENERAL_DATE_PATTERN));
    }

    /**
     * 获取时间本文
     */
    public static String getDateTimeText() {
        return now.format(DateTimeFormatter.ofPattern(GENERAL_PATTERN));
    }

    /**
     * 根据毫秒数获取时间文本
     */
    public static String getDateTimeText(long time) {
        return now.format(DateTimeFormatter.ofPattern(GENERAL_PATTERN));
    }

    /**
     * 给定日期是否是今日
     */
    public static boolean isToday(String time) {
        return LocalDate.parse(time).isEqual(today);
    }

    /**
     * 当前时间戳是否是今天
     */
    public static boolean isToday(long time) {
        LocalDate date = LocalDateTime.ofInstant(transToInstant(time), ZoneId.systemDefault()).toLocalDate();
        return date.isEqual(today);
    }

    /**
     * 获取n天之前至今的时间段
     */
    public static Pair<Long, Long> getDaysAgoTime(Integer days) {
        LocalDate localDate = LocalDate.now().minusDays(days);
        long begin = localDate.atTime(0, 0, 0).toEpochSecond(ZoneOffset.ofHours(8));
        long end = localDate.atTime(23, 59, 59).toEpochSecond(ZoneOffset.ofHours(8));
        return ImmutablePair.of(begin, end);
    }

    /**
     * 获取两个时间段区间 00:00:00 - 23:59:59
     */
    public static Pair<Long, Long> getDurationPair(String beginStr, String endStr) {
        long begin = LocalDate.parse(beginStr, DateTimeFormatter.ofPattern(GENERAL_DATE_PATTERN)).atTime(0, 0, 0).toEpochSecond(ZoneOffset.ofHours(8));
        long end = LocalDate.parse(endStr, DateTimeFormatter.ofPattern(GENERAL_DATE_PATTERN)).atTime(23, 59, 59).toEpochSecond(ZoneOffset.ofHours(8));
        return ImmutablePair.of(begin, end);
    }

    /**
     * 获取两个时间段之间的天数
     */
    public static long getBetweenDays(long start, long end) {
        return ChronoUnit
                .DAYS
                .between(
                        LocalDateTime.ofInstant(transToInstant(start), ZoneId.systemDefault()),
                        LocalDateTime.ofInstant(transToInstant(end), ZoneId.systemDefault())
                );
    }

    /**
     * 获取两个时间段之间的天数
     */
    public static long getBetweenDays(String start, String end) {
        return ChronoUnit.DAYS.between(LocalDate.parse(start), LocalDate.parse(end));
    }

    /**
     * 获取两个时间段之间的所有日期
     */
    public static List<String> getBetweenDates(String start, String end) {
        List<String> list = new ArrayList<>();

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long distance = ChronoUnit.DAYS.between(startDate, endDate);

        if (distance < 1) {
            return list;
        }

        if (distance == 0) {
            list.add(start);
            return list;
        }

        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> {
            list.add(f.toString());
        });
        return list;
    }

    /**
     * 防止PHP接口返回的10位时间戳
     */
    private static long ensureMillsTime(long seconds) {
        if (seconds < MIN_TIME_STAMP) {
            throw new IllegalArgumentException("无效的时间戳");
        }

        if (seconds < MAX_TIME_STAMP) {
            seconds *= 1000;
        }
        return seconds;
    }

    private static Instant transToInstant(long time) {
        if (time < MAX_TIME_STAMP && time > MIN_TIME_STAMP) {
            return Instant.ofEpochSecond(time);
        }
        if (time < MAX_TIME_STAMP * 1000 && time > MIN_TIME_STAMP * 1000){
            return Instant.ofEpochMilli(time);
        }
        throw new IllegalArgumentException("illegal time value");
    }

    public static void main(String[] args) {
        Triple<Integer, Integer, Integer> yearMonthDay = getYearMonthDay();
        System.out.println(yearMonthDay.getLeft());
        System.out.println(yearMonthDay.getMiddle());
        System.out.println(yearMonthDay.getRight());

        System.out.println(getDateText());
        System.out.println(getDateTimeText());
        System.out.println(getDateTimeText(1547704586724L));
        System.out.println(isToday(1547704586724L));
        System.out.println(isToday("2019-01-17"));

        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());

        System.out.println(LocalDate.from(LocalDateTime.now()));
        System.out.println(LocalTime.now());
        Instant.now().toEpochMilli();
        LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
        LocalDate.now().toEpochDay();

        LocalDate parse = LocalDate.parse("2019-01-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        Period period = Period.between(LocalDate.of(2019, 1, 19), LocalDate.of(2019, 2, 10));
        long days = ChronoUnit.DAYS.between(LocalDate.of(2019, 1, 19), LocalDate.of(2019, 2, 10));
        Assert.assertTrue("二者不等", days==period.getDays());
        System.out.println(period.getDays());
        System.out.println(days);
        System.out.println(period.getMonths());
    }
}
