package de.krummacker.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ToolsTest {

    /**
     * Make sure that the createRandomList() method returns a random list of the right length (happy case).
     */
    @Test
    void testCreateRandomList() throws Exception {
        List<Integer> actual = Tools.createRandomList(10);
        Assertions.assertEquals(actual.size(), 10);
    }

    /**
     * Make sure that the createRandomList() method returns still works if the argument is zero.
     */
    @Test
    void testCreateRandomListZero() throws Exception {
        List<Integer> actual = Tools.createRandomList(0);
        Assertions.assertEquals(actual.size(), 0);
    }

    /**
     * Make sure that the createRandomList() method fails if the parameter is negative.
     */
    @Test
    void testCreateRandomListNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Tools.createRandomList(-10);
        });
    }

    /**
     * Make sure that the computeMedian() method works fine in the happy case.
     */
    @Test
    void testComputeMedianHappyCase() throws Exception {
        Comparable actual = Tools.computeMedian(1, 2, 3);
        Assertions.assertEquals(actual, 2);
    }

    /**
     * Make sure that the computeMedian() method works fine if two arguments are equal.
     */
    @Test
    void testComputeMedianTwoEqual() throws Exception {
        Comparable actual = Tools.computeMedian(42, 17, 42);
        Assertions.assertEquals(actual, 42);
    }

    /**
     * Make sure that the computeMedian() method works fine if all arguments are equal.
     */
    @Test
    void testComputeMedianAllEqual() throws Exception {
        Comparable actual = Tools.computeMedian(99, 99, 99);
        Assertions.assertEquals(actual, 99);
    }

    /**
     * Make sure that the computeMedian() method fails if a single parameter is null.
     */
    @Test
    void testComputeMedianNullSingle() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Tools.computeMedian(1, null, 3);
        });
    }

    /**
     * Make sure that the computeMedian() method fails if all parameters are null.
     */
    @Test
    void testComputeMedianNullAll() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Tools.computeMedian(null, null, null);
        });
    }
}