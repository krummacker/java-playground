package de.krummacker.records;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RecordsTest {

    private record Shape(String type, long unit){}

    @Test
    public void testCreateRecord() {
        Shape circle = new Shape("Circle", 10);
        Assert.assertEquals(circle.type(), "Circle");
        Assert.assertEquals(circle.unit(), 10);
    }
}
