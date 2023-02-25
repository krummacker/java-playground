package de.krummacker.collections;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Tests the Bag class.
 */
class BagTest {

    /**
     * Make sure that we can add strings and that they are there.
     */
    @Test
    void testAddStringsAndTestContains() {

        Bag<String> bag = new Bag<>();
        Assertions.assertTrue(bag.isEmpty());
        Assertions.assertEquals(bag.size(), 0);

        String example = "kobylamamalybok";
        bag.add(example);
        Assertions.assertFalse(bag.isEmpty());
        Assertions.assertEquals(bag.size(), 1);
        Assertions.assertTrue(bag.contains(example));
    }

    /**
     * Make sure that we can add the same object twice.
     */
    @Test
    void testAddTwoObjects() {

        Bag<Object> bag = new Bag<>();
        Object example = new Object();
        bag.add(example);
        bag.add(example);

        Assertions.assertFalse(bag.isEmpty());
        Assertions.assertEquals(bag.size(), 2);
        Assertions.assertTrue(bag.contains(example));
    }

    /**
     * Make sure that we can use foreach with Bags.
     */
    @Test
    void testForEach() {

        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        for (Integer i : bag) {
            Assertions.assertNotNull(i);
        }
    }

    /**
     * Make sure that we can use an iterator of a Bag.
     */
    @Test
    void testIteratorHappyCase() {

        List<String> source = new ArrayList<>(4);
        source.add("one");
        source.add("two");
        source.add("two");
        source.add("three");

        Bag<String> bag = new Bag<>();
        bag.addAll(source);
        Iterator<String> iterator = bag.iterator();
        Assertions.assertNotNull(iterator);

        while (iterator.hasNext()) {
            String n = iterator.next();
            Assertions.assertTrue(source.contains(n));
        }
        Assertions.assertFalse(iterator.hasNext());
    }

    /**
     * Make sure that we can use an iterator of a Bag to remove elements.
     */
    @Test
    void testIteratorRemove() {

        Bag<String> bag = new Bag<>();
        bag.add("one");
        bag.add("two");
        bag.add("two");
        bag.add("three");
        Assertions.assertEquals(bag.size(), 4);

        Iterator<String> iterator = bag.iterator();
        Assertions.assertNotNull(iterator.next());
        Assertions.assertNotNull(iterator.next());
        iterator.remove();
        Assertions.assertEquals(bag.size(), 3);
    }

    /**
     * Make sure that a Bag iterator fails correctly when used too long.
     */
    @Test
    void testIteratorTooFar() {

        Bag<String> bag = new Bag<>();
        bag.add("foo");

        Iterator<String> iterator = bag.iterator();
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertNotNull(iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        try {
            iterator.next();
            Assertions.fail("expected NoSuchElementException but was not thrown");
        } catch (NoSuchElementException e) {
            // This is expected.
        }
    }

    /**
     * Make sure that a Bag iterator fails correctly when the Bag is modified in-between.
     */
    @Test
    void testIteratorConcurrentModification() {

        Bag<String> bag = new Bag<>();
        bag.add("foo");
        bag.add("bar");

        Iterator<String> iterator = bag.iterator();
        Assertions.assertNotNull(iterator.next());

        bag.add("baz");

        try {
            iterator.next();
            Assertions.fail("expected ConcurrentModificationException but was not thrown");
        } catch (ConcurrentModificationException e) {
            // This is expected.
        }
    }
}
