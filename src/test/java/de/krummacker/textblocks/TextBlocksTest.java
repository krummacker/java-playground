package de.krummacker.textblocks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBlocksTest {
    @Test
    public void testGetMultilineTextBlock() {
        String expected = "This is a text block.\n" +
                "It has multiple lines.\n" +
                "They work like HERE documents.\n" +
                "You can even use parameters: hello\n" +
                "And this is the last line.";
        String actual = TextBlocks.getMultilineTextBlock("hello");
        Assert.assertEquals(actual, expected);
    }
}

