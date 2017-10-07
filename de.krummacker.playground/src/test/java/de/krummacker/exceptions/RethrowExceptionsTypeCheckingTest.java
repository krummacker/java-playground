package de.krummacker.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RethrowExceptionsTypeCheckingTest {

    private static class FirstException extends Exception {
    }

    private static class SecondException extends Exception {
    }

    private void rethrowException(String exceptionName) throws FirstException, SecondException {
        //noinspection CaughtExceptionImmediatelyRethrown
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    void testRethrowExceptionsTypeCheckingTest() {
        try {
            rethrowException("First");
        } catch (Exception e) {
            return;
        }
        Assertions.fail("not expected");
    }

    @Test
    void testRethrowExceptionsTypeCheckingTestOtherValue() {
        try {
            rethrowException("Second");
        } catch (Exception e) {
            return;
        }
        Assertions.fail("not expected");
    }
}