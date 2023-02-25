package de.krummacker.prime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OddNumberTesterTest {

    private OddNumberTester oddNumberTester;

    @BeforeEach
    void setUp() throws Exception {
        oddNumberTester = new OddNumberTester();
    }

    @AfterEach
    void tearDown() throws Exception {
        oddNumberTester = null;
    }

    /**
     * Make sure that -1 is considered odd.
     */
    @Test
    void testMinusOneOdd() throws Exception {
        Assertions.assertTrue(oddNumberTester.isOdd(-1));
    }

    /**
     * Make sure that 0 is considered even.
     */
    @Test
    void testZeroNotOdd() throws Exception {
        Assertions.assertFalse(oddNumberTester.isOdd(0));
    }

    /**
     * Make sure that 1 is considered odd.
     */
    @Test
    void testOneOdd() throws Exception {
        Assertions.assertTrue(oddNumberTester.isOdd(1));
    }

    /**
     * Make sure that 2 is considered even.
     */
    @Test
    void testTwoNotOdd() throws Exception {
        Assertions.assertFalse(oddNumberTester.isOdd(2));
    }

    /**
     * Make sure that Integer.MAX_VALUE is considered odd.
     */
    @Test
    void testIntegerMAX_VALUEPrime() throws Exception {
        Assertions.assertTrue(oddNumberTester.isOdd(Integer.MAX_VALUE));
    }

    /**
     * Make sure that Integer.MIN_VALUE is considered odd.
     */
    @Test
    void testIntegerMIN_VALUENotOdd() throws Exception {
        Assertions.assertFalse(oddNumberTester.isOdd(Integer.MIN_VALUE));
    }
}