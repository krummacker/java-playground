package de.krummacker.scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Tests the Java Scanner class.
 */
public class ScannerTest {

    /**
     * Make sure that a scanned file is not empty.
     */
    @Test
    void testScanner() {
        try {
            File source = new File("src/test/java/de/krummacker/scanner/ScannerTest.java");
            String str = new Scanner(source, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            Assert.assertNotNull(str);
            Assert.assertNotEquals(str, "");
        } catch (FileNotFoundException e) {
            Assert.fail("not able to open file", e);
        } catch (IOException e) {
            Assert.fail("unable to create scanner", e);
        }
    }
}