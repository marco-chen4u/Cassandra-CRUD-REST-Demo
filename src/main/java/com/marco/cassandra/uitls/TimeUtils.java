package com.marco.cassandra.uitls;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.regex.Pattern;

public class TimeUtils {
    // fields
    private final static String REGEX_DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    private final static String DATE_PATTERN = "yyyy-MM-dd";
    private final static String REGEX_TIME_PATTERN = "^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$";
    private final static String TIME_PATTERN = "HH:mm:ss";
    private final static String LOCAL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final static int LOCAL_TIME_HOUR_DIFFERENCE = -5;
    private final static String DELIMITER = " ";
    private final static String DEFAULT_TIME_VALUE = "00:00:00";
    private final static String DEFAULT_DATE_VALUE = "2014-05-19";

    // methods
    public static Date getLocalTime(String date, String time) throws Exception{
        date = validDate(date) ? date : DEFAULT_DATE_VALUE;
        time = validTime(time) ?  time : DEFAULT_TIME_VALUE;

        String dateTime = date + DELIMITER + time;

        Date value = DateUtils.parseDate(dateTime, new String[]{LOCAL_TIME_FORMAT});

        return DateUtils.addHours(value, LOCAL_TIME_HOUR_DIFFERENCE);
    }

    public static boolean validDate(String value) {
        // check corner case
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        Pattern datePattern = Pattern.compile(REGEX_DATE_PATTERN);
        return datePattern.matcher(value).matches();
    }

    public static boolean validTime(String value) {
        // check corner case
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        Pattern timePattern = Pattern.compile(REGEX_TIME_PATTERN);
        return timePattern.matcher(value).matches();
    }
}
