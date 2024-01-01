package de.krummacker.switchexpressions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

public class DayTypeCheckerTest {

    @Test
    public void testIsWeekDayOldStyle() {
        Assert.assertTrue(DayTypeChecker.isWeekDayOldStyle(Calendar.MONDAY));
        Assert.assertFalse(DayTypeChecker.isWeekDayOldStyle(Calendar.SUNDAY));
    }

    @Test
    public void testIsWeekDayNewStyle() {
        Assert.assertTrue(DayTypeChecker.isWeekDayNewStyle(Calendar.MONDAY));
        Assert.assertFalse(DayTypeChecker.isWeekDayNewStyle(Calendar.SUNDAY));
    }
    @Test
    public void testIsWeekDayNewStyleYield() {
        Assert.assertTrue(DayTypeChecker.isWeekDayNewStyleYield(Calendar.MONDAY));
        Assert.assertFalse(DayTypeChecker.isWeekDayNewStyleYield(Calendar.SUNDAY));
    }
}
