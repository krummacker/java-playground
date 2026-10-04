package de.krummacker.flexconstructors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    void testConstructorTooYoung() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Employee(15));
    }

    @Test
    void testConstructorTooOld() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new Employee(80));
    }

    @Test
    void testConstructorAcceptsValidAge() {
        new Employee(30);
    }

    @Test
    void testGetAge() {
        Employee emp = new Employee(30);
        Assert.assertEquals(emp.getAge(), 30);
    }
}
