package de.krummacker.collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Tests new Java 9 features around Sets.
 */
public class SetTest {

    /**
     * Create a set out of one method call.
     */
    @Test
    void testCreateSet() {
        Set set = Set.of(1, 2, 3);
        Assert.assertTrue(set.contains(1));
        Assert.assertTrue(set.contains(2));
        Assert.assertTrue(set.contains(3));
    }
}