package de.krummacker.exceptions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * Tests the new Java 22 language feature.
 */
public class UnnamedVariableTest {

    /**
     * Uses the new feature for unnamed variables.
     */
    @Test
    void testUnnamedVariable() {
        try (FileReader fileReader = new FileReader("test")) {
            Assert.assertNotNull(fileReader);
        } catch (IOException _) {
            // do nothing
        }
    }
}
