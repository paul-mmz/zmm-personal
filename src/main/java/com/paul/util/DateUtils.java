package com.paul.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hzhuangkangning on 2017/3/31.
 */
public class DateUtils {

    public static final String format1 = "yyyy-MM-dd HH:mm:ss";
    public static final String format2 = "yyyy-MM-dd";
    public static final String format3 = "yyyy/MM/dd HH:mm:ss";
    public static final String format4 = "yyyy/MM/dd";
    public static final String format5 = "yyyyMMddHHmmss";
    public static final String format6 = "yyyyMMdd";
    public static final String[] allFormat = { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd",
            "yyyyMMddHHmmss", "yyyyMMdd" };

    // 每秒钟毫秒数
    public static final int MILLIS_PER_SECOND = 1000;

    // 每分钟毫秒数
    public static final int MILLIS_PER_MINUTE = 60000;

    // 每小时毫秒数
    public static final int MILLIS_PER_HOUR = 3600000;

    // 每天毫秒数
    public static final int MILLIS_PER_DAY = 86400000;

    // 每天小时数
    public static final int HOUR_PER_DAY = 24;

    private static final long defaultZeroTime = new Date(0L).getTime();

    public static Date parseToDate(long time) {
        return new Date(time);
    }

    public static Date parse(String time) {
        Date date = null;
        for (String format : allFormat) {
            try {
                date = parse(time, format);
            } catch (ParseException localParseException) {
            }
            if (date != null) {
                return date;
            }
        }
        return null;
    }

    public static Date parse(String time, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(time);
    }

    public static long parseToLongtime(String time) {
        Date date = parse(time);
        return ((date == null) ? 0L : date.getTime());
    }

    public static String format(long time) {
        Date date = parseToDate(time);
        return ((date == null) ? null : format(date));
    }

    public static String format(long time, String format) {
        Date date = parseToDate(time);
        return ((date == null) ? null : new SimpleDateFormat(format).format(date));
    }

    public static String format(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        return calendar.getTime();
    }
}
