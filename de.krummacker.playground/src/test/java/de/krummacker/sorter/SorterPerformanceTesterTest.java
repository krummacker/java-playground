package de.krummacker.sorter;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests the SorterPerformanceTester class.
 */
class SorterPerformanceTesterTest {

    /**
     * Make sure that the main method can be called (happy case).
     */
    @Test
    void testMain() {
        String[] args = new String[]{"-m", "5", "-s", "1"};
        SorterPerformanceTester.executeApplication(args, new PrintStream(new ByteArrayOutputStream()));
    }
}