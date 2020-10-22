package com.programflow.programflow.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.getInstance;

public class DateUtils {

    private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private static Calendar calendar = getInstance();

    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String formatDate(Date date, String format) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String formatDateyyyyMMdd(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        return simpleDateFormat.format(date);
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {

        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // month is not zero based
    public static Date createDate(
            int year, int month, int date, int hourOfDay, int minute, int second) {
        calendar.set(year, month - 1, date, hourOfDay, minute, second);
        calendar.set(MILLISECOND, 0);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        return calendar.getTime();
    }
}
