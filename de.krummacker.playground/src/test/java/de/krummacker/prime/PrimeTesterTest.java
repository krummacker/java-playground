package de.krummacker.prime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeTesterTest {

    private PrimeTester primeTester;

    @BeforeEach
    void setUp() throws Exception {
        primeTester = new PrimeTester();
    }

    @AfterEach
    void tearDown() throws Exception {
        primeTester = null;
    }

    /**
     * Make sure that -1 is not considered a prime.
     */
    @Test
    void testMinusOneNotPrime() throws Exception {
        Assertions.assertFalse(primeTester.isPrime(-1));
    }

    /**
     * Make sure that 0 is not considered a prime.
     */
    @Test
    void testZeroNotPrime() throws Exception {
        Assertions.assertFalse(primeTester.isPrime(0));
    }

    /**
     * Make sure that 1 is not considered a prime.
     */
    @Test
    void testOneNotPrime() throws Exception {
        Assertions.assertFalse(primeTester.isPrime(1));
    }

    /**
     * Make sure that 2 is considered a prime.
     */
    @Test
    void testTwoPrime() throws Exception {
        Assertions.assertTrue(primeTester.isPrime(2));
    }

    /**
     * Make sure that 3 is considered a prime.
     */
    @Test
    void testThreePrime() throws Exception {
        Assertions.assertTrue(primeTester.isPrime(3));
    }

    /**
     * Make sure that 4 is not considered a prime.
     */
    @Test
    void testFourNotPrime() throws Exception {
        Assertions.assertFalse(primeTester.isPrime(4));
    }

    /**
     * Make sure that 5 is considered a prime.
     */
    @Test
    void testFivePrime() throws Exception {
        Assertions.assertTrue(primeTester.isPrime(5));
    }

    /**
     * Make sure that 91 is not considered a prime.
     */
    @Test
    void test91NotPrime() throws Exception {
        Assertions.assertFalse(primeTester.isPrime(91));
    }

    /**
     * Make sure that 97 is considered a prime.
     */
    @Test
    void test97Prime() throws Exception {
        Assertions.assertTrue(primeTester.isPrime(97));
    }

    /**
     * Make sure that Integer.MAX_VALUE is considered a prime, Joshua Bloch stated it so it must be true.
     */
    // @Test not executed, takes 6 seconds and thus too long
    @SuppressWarnings("unused")
    void testIntegerMAX_VALUEPrime() throws Exception {
        Assertions.assertTrue(primeTester.isPrime(Integer.MAX_VALUE));
    }

    /**
     * Make sure that Integer.MIN_VALUE is not considered a prime.
     */
    @Test
    void testIntegerMIN_VALUENotPrime() throws Exception {
        Assertions.assertFalse(primeTester.isPrime(Integer.MIN_VALUE));
    }
}