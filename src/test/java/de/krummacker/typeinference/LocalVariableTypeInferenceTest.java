package de.krummacker.typeinference;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalVariableTypeInferenceTest {

    @Test
    public void testLocalVariableInference() {
        String expected = "message";
        var message = "message";
        Assert.assertEquals(message, expected);
    }

    @Test
    public void testVarIsNotAKeyWord() {
        int var = 42;
        Assert.assertEquals(var, 42);
    }
}
