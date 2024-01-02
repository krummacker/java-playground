package de.krummacker.patternswitch;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class PatternMatchingForSwitchTest {

    private static String formatterPatternSwitch(Object obj) {
        // As of Java 21
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }

    @Test
    public void testSwitchOnClass() {
        Assert.assertEquals(formatterPatternSwitch(1), "int 1");
        Assert.assertEquals(formatterPatternSwitch(42L), "long 42");
        Assert.assertEquals(formatterPatternSwitch("foobar"), "String foobar");
        Assert.assertEquals(formatterPatternSwitch(BigDecimal.ONE), "1");
    }
}
