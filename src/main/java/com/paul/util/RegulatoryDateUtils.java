package com.paul.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author nijun
 * @date 2018/1/19
 */
public class RegulatoryDateUtils {

    public static Long getLastMondayStartMillis() {
        return getLastMondayStartDate().getTime();
    }

    public static Long getLastSundayEndMillis() {

        return getLastSundayEndDate().getTime();
    }

    public static Date getLastMondayStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastSundayEndDate() {
        Calendar calendar = Calendar.getInstance();
        // 周日默认为一周的第一天
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
