package com.gset.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.valueOf;

/**
 * @author Mohammad.Mahdi.Bahrami <m2.bahrami@parsijoo.ir>
 * @version 1.0
 * @since 2016-01-01
 */
public class PersianCalendar implements Serializable {
    private static CalendarConversion calenderConversion = new CalendarConversion();

    public static Timestamp SolarToGregorian(String farsiDate) {
        if (farsiDate == null) return null;
        String fDate = farsiDate.trim();
        if (fDate.equals("") || fDate.length() < 6)
            return null;
        String[] split;
        split = fDate.split("-");
        try {
            if (split.length > 3)
                throw new Exception("Date Error");
            if (split[0].length() > 4 || Integer.valueOf(split[1]) < 1 || Integer.valueOf(split[1]) > 12
                    || Integer.valueOf(split[2]) < 1 || Integer.valueOf(split[2]) > 31)
                throw new Exception("Date Error");
            if (Integer.valueOf(split[1]) > 6 && Integer.valueOf(split[2]) > 30)
                throw new Exception("Date Error");
        } catch (Exception ignored) {
        }
        if (split[0].length() < 3)
            split[0] = "13" + split[0];
        calenderConversion.setIranianDate(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
        return Timestamp.valueOf(calenderConversion.getGregorianDate() + " 00:00:00.0");
    }

    public static String SolarToStringGregorian(String farsiDate) {
        if (farsiDate == null) return null;
        String fDate = farsiDate.trim();
        if (fDate.equals("") || fDate.length() < 6)
            return null;
        String[] split;
        split = fDate.split("-");
        try {
            if (split.length > 3)
                throw new Exception("Date Error");
            if (split[0].length() > 4 || Integer.valueOf(split[1]) < 1 || Integer.valueOf(split[1]) > 12
                    || Integer.valueOf(split[2]) < 1 || Integer.valueOf(split[2]) > 31)
                throw new Exception("Date Error");
            if (Integer.valueOf(split[1]) > 6 && Integer.valueOf(split[2]) > 30)
                throw new Exception("Date Error");
        } catch (Exception ignored) {
        }
        if (split[0].length() < 3)
            split[0] = "13" + split[0];
        calenderConversion.setIranianDate(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
        return calenderConversion.getGregorianDate();
    }

    public static String GregorianToSolar(Date date) {
        if (date == null) return null;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String str = df.format(date);
        String[] split;
        split = str.split("/");
        calenderConversion.setGregorianDate(valueOf(split[0]), valueOf(split[1]), valueOf(split[2]));
        return calenderConversion.getIranianDateFix10Char();
    }

    public static int getMonthIndex(String monthName) {
        switch (monthName) {
            case "فروردین":
                return 1;
            case "اردیبهشت":
                return 2;
            case "خرداد":
                return 3;
            case "تیر":
                return 4;
            case "مرداد":
            case "امرداد":
                return 5;
            case "شهریور":
                return 6;
            case "مهر":
                return 7;
            case "آبان":
                return 8;
            case "آذر":
                return 9;
            case "دی":
                return 10;
            case "بهمن":
                return 11;
            case "اسفند":
                return 12;
        }
        return 0;
    }
}