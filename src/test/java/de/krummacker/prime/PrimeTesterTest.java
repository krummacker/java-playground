package de.krummacker.prime;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrimeTesterTest {

    private PrimeTester primeTester;

    @BeforeMethod
    public void setUp() {
        primeTester = new PrimeTester();
    }

    @AfterMethod
    public void tearDown() {
        primeTester = null;
    }

    /**
     * Make sure that -1 is not considered a prime.
     */
    @Test
    public void testMinusOneNotPrime() {
        Assert.assertFalse(primeTester.isPrime(-1));
    }

    /**
     * Make sure that 0 is not considered a prime.
     */
    @Test
    public void testZeroNotPrime() {
        Assert.assertFalse(primeTester.isPrime(0));
    }

    /**
     * Make sure that 1 is not considered a prime.
     */
    @Test
    public void testOneNotPrime() {
        Assert.assertFalse(primeTester.isPrime(1));
    }

    /**
     * Make sure that 2 is considered a prime.
     */
    @Test
    public void testTwoPrime() {
        Assert.assertTrue(primeTester.isPrime(2));
    }

    /**
     * Make sure that 3 is considered a prime.
     */
    @Test
    public void testThreePrime() {
        Assert.assertTrue(primeTester.isPrime(3));
    }

    /**
     * Make sure that 4 is not considered a prime.
     */
    @Test
    public void testFourNotPrime() {
        Assert.assertFalse(primeTester.isPrime(4));
    }

    /**
     * Make sure that 5 is considered a prime.
     */
    @Test
    public void testFivePrime() {
        Assert.assertTrue(primeTester.isPrime(5));
    }

    /**
     * Make sure that 91 is not considered a prime.
     */
    @Test
    public void test91NotPrime() {
        Assert.assertFalse(primeTester.isPrime(91));
    }

    /**
     * Make sure that 97 is considered a prime.
     */
    @Test
    public void test97Prime() {
        Assert.assertTrue(primeTester.isPrime(97));
    }

    /**
     * Make sure that Integer.MAX_VALUE is considered a prime,
     * Joshua Bloch stated it, so it must be true.
     */
    @Test
    public void testIntegerMAX_VALUEPrime() {
        Assert.assertTrue(primeTester.isPrime(Integer.MAX_VALUE));
    }

    /**
     * Make sure that Integer.MIN_VALUE is not considered a prime.
     */
    @Test
    public void testIntegerMIN_VALUENotPrime() {
        Assert.assertFalse(primeTester.isPrime(Integer.MIN_VALUE));
    }
}