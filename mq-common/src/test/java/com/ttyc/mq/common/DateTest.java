package com.ttyc.mq.common;

import com.ttyc.mq.common.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class DateTest {

    @Test
    public void testNow() {
        String nowAsString = DateUtils.getNowAsString();
        System.out.println(nowAsString);
        Assert.assertNotNull(nowAsString);
    }

    @Test
    public void testFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTimeAsString = DateUtils.getDateTimeAsString(localDateTime, "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeAsString);
        Assert.assertNotNull(dateTimeAsString);
    }

    @Test
    public void testLong() {
        long timestampOfDateTime = DateUtils.getTimestampOfDateTime(LocalDateTime.now());
        System.out.println(timestampOfDateTime);
        Assert.assertTrue(timestampOfDateTime > 0);
    }
}
