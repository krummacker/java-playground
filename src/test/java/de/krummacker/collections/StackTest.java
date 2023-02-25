package de.krummacker.collections;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests the Stack class.
 */
public class StackTest {

    @Test
    void testPushAndPop() {
        Stack<String> stack = new Stack<>();
        String value = "kobylamamalybok";
        stack.push(value);
        String result = stack.pop();
        Assert.assertEquals(result, value);
    }

    @Test
    void testEmptySize() {
        Stack<String> stack = new Stack<>();
        Assert.assertEquals(stack.size(), 0);
    }

    @Test
    void testFilledSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(stack.size(), 3);
    }

    @Test
    void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(stack.peek(), 3);
        Assert.assertEquals(stack.size(), 3);
        Assert.assertEquals(stack.pop(), 3);
        Assert.assertEquals(stack.pop(), 2);
        Assert.assertEquals(stack.pop(), 1);
    }
}
