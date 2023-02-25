package de.krummacker.collections;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the Stack class.
 */
class StackTest {

    @Test
    void testPushAndPop() {
        Stack<String> stack = new Stack<>();
        String value = "kobylamamalybok";
        stack.push(value);
        String result = stack.pop();
        Assertions.assertEquals(result, value);
    }

    @Test
    void testEmptySize() {
        Stack<String> stack = new Stack<>();
        Assertions.assertEquals(stack.size(), 0);
    }

    @Test
    void testFilledSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(stack.size(), 3);
    }

    @Test
    void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(stack.peek(), 3);
        Assertions.assertEquals(stack.size(), 3);
        Assertions.assertEquals(stack.pop(), 3);
        Assertions.assertEquals(stack.pop(), 2);
        Assertions.assertEquals(stack.pop(), 1);
    }
}
