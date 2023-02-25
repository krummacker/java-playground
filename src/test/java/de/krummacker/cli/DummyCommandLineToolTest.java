package de.krummacker.cli;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DummyCommandLineToolTest {

    /**
     * Make sure that the help text contains usage instructions.
     */
    @Test
    void testHelp() throws Exception {
        String[] args = {"--help"};
        String output = DummyCommandLineTool.determineOutput(args);
        Assertions.assertTrue(output.startsWith("usage"));
    }

    /**
     * Make sure that the target value is rendered correctly.
     */
    @Test
    void testOnlyTarget() throws Exception {
        String[] args = {"--target", "foobar"};
        String expected = "Verbose: false\nTarget: foobar\n";
        String output = DummyCommandLineTool.determineOutput(args);
        Assertions.assertEquals(output, expected);
    }

    /**
     * Make sure that both target value and verbose are rendered correctly.
     */
    @Test
    void testTargetAndVerbose() throws Exception {
        String[] args = {"--target", "foobar", "--verbose"};
        String expected = "Verbose: true\nTarget: foobar\n";
        String output = DummyCommandLineTool.determineOutput(args);
        Assertions.assertEquals(output, expected);
    }

    /**
     * Make sure that short options work too.
     */
    @Test
    void testShortOptions() throws Exception {
        String[] args = {"-t", "foobar", "-v"};
        String expected = "Verbose: true\nTarget: foobar\n";
        String output = DummyCommandLineTool.determineOutput(args);
        Assertions.assertEquals(output, expected);
    }

    /**
     * Make sure illegal arguments cause an error.
     */
    @Test
    void testIllegalArguments() throws Exception {
        String[] args = {"-x", "y", "-z"};
        String expected = "Unrecognized option: -x\n";
        String output = DummyCommandLineTool.determineOutput(args);
        Assertions.assertEquals(output, expected);
    }
}