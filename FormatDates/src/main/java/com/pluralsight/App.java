package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        MonthDayYear(now);
        YearMonthDay(now);
        System.out.println(getFullMonthDayYear(now));
        FullWeekdayMonthdayYear(now);
        TimeInGMTLabel(now);
        TimeWithDateLocalLabel(now);
    }

    static void MonthDayYear(LocalDateTime now) {
        DateTimeFormatter MonthDayYearFormatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        System.out.println(now.format(MonthDayYearFormatter));
    }

    static void YearMonthDay(LocalDateTime now) {
        DateTimeFormatter YearMonthDayFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(YearMonthDayFormatter));
    }

    static String getFullMonthDayYear(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return format3.format(now);
// System.out.println("This will never execute");
    }

    static void FullWeekdayMonthdayYear(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("eeee, MMM d, yyyy");
        System.out.println(time.format(format4));
    }

    static void TimeInGMTLabel(LocalDateTime now) {
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(now.format(format5) + " display in GMT time");

    }

    static void TimeWithDateLocalLabel(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(format6.format(now) + " display in your local time zone");
    }
}
