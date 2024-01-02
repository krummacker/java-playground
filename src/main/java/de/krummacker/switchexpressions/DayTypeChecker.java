package de.krummacker.switchexpressions;

import java.util.Calendar;

public class DayTypeChecker {

    @SuppressWarnings("all")
    public static boolean isWeekDayOldStyle(int day) throws IllegalArgumentException {
        switch (day) {
            case Calendar.MONDAY:
            case Calendar.TUESDAY:
            case Calendar.WEDNESDAY:
            case Calendar.THURSDAY:
            case Calendar.FRIDAY:
                return true;
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static boolean isWeekDayNewStyle(int day) throws IllegalArgumentException {
        return switch (day) {
            case Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY,
                    Calendar.THURSDAY, Calendar.FRIDAY -> true;
            case Calendar.SATURDAY, Calendar.SUNDAY -> false;
            default -> throw new IllegalArgumentException();
        };
    }

    public static boolean isWeekDayNewStyleYield(int day) throws IllegalArgumentException {
        return switch (day) {
            case Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY,
                    Calendar.THURSDAY, Calendar.FRIDAY:
                yield true;
            case Calendar.SATURDAY, Calendar.SUNDAY:
                yield false;
            default:
                throw new IllegalArgumentException();
        };
    }
}

