package org.example;

import java.util.Calendar;

public class DateUtils {
    public static int addYearsToCurrent(int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, years);
        return calendar.get(Calendar.YEAR);
    }
}