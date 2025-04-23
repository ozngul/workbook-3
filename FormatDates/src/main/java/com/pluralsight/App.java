package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // get current date and time

        //call different formatting methods for date and time
        MonthDayYear(now);
        YearMonthDay(now);
        System.out.println(getFullMonthDayYear(now));
        FullWeekdayMonthdayYear(now);
        TimeInGMTLabel(now);
        TimeWithDateLocalLabel(now);
    }
    // Format: MM-dd-yyyy
    static void MonthDayYear(LocalDateTime now) {
        DateTimeFormatter MonthDayYearFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(now.format(MonthDayYearFormatter));
    }
    // Format: yyyy/MM/dd
    static void YearMonthDay(LocalDateTime now) {
        DateTimeFormatter YearMonthDayFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(YearMonthDayFormatter));
    }
    // format: full month name, dd ,yyyy
    static String getFullMonthDayYear(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return format3.format(now);
    // System.out.println("This will never execute");
    }
    // Format: Day name, short month, day, year
    static void FullWeekdayMonthdayYear(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
        System.out.println(time.format(format4));
    }
    // Format: hour:minute with GMT display label
    static void TimeInGMTLabel(LocalDateTime now) {
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(now.format(format5) + " display in GMT time");

    }
    // Format: hour:minute on dd MMM yyyy with local time zone display label
    static void TimeWithDateLocalLabel(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(format6.format(now) + " display in your local time zone");
    }
}
