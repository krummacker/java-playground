package de.krummacker.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Tests new Java 9 features around Sets.
 */
class SetTest {

    /**
     * Create a set out of one method call.
     */
    @Test
    void testCreateSet() {
        Set set = Set.of(1, 2, 3);
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
    }
}