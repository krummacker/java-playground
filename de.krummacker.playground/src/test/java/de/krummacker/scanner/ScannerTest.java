package de.krummacker.scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tests the Java Scanner class.
 */
class ScannerTest {

    /**
     * Make sure that a scanned file is not empty.
     */
    @Test
    void testScanner() {
        try {
            File source = new File("de.krummacker.playground/src/test/java/de/krummacker/scanner/ScannerTest.java");
            String str = new Scanner(source, "UTF-8").useDelimiter("\\A").next();
            Assertions.assertNotNull(str);
            Assertions.assertNotEquals(str, "");
        } catch (FileNotFoundException e) {
            Assertions.fail("not able to open file", e);
        }
    }
}