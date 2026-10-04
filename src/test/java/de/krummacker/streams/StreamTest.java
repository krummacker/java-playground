package de.krummacker.streams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tests for the stream API. This is more for trying out what this API can do.
 */
public class StreamTest {

    @Test
    public void testIterateAndLimit() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 1)
                .limit(10);
        List<Integer> produced = stream.collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testToArray() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 1)
                .limit(10);
        Object[] produced = stream.toArray();
        Object[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testSkip() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .skip(5);
        List<Integer> produced = stream.collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(5, 6, 7, 8, 9);
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testMap() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .map(n -> n * 2);
        List<Integer> produced = stream.collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18);
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testLimitSkipMap() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2)
                .limit(10)
                .skip(5)
                .map(n -> n * 2);
        List<Integer> produced = stream.collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(20, 24, 28, 32, 36);
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testSetStream() {
        Set<Integer> set = new HashSet<>();
        set.add(42);
        Stream<Integer> stream = set.stream();
        List<Integer> produced = stream.collect(Collectors.toList());
        List<Integer> expected = List.of(42);
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testReduceSum() {
        Integer produced = Stream.iterate(0, n -> n + 1)
                .limit(5)
                .reduce(0, Integer::sum);
        Integer expected = 10;
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testReduceMax() {
        Integer produced = Stream.iterate(0, n -> n + 1)
                .limit(5)
                .reduce(0, Integer::max);
        Integer expected = 4;
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testFilter() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(i -> i == 3);
        List<Integer> produced = stream.collect(Collectors.toList());
        List<Integer> expected = List.of(3);
        Assert.assertEquals(produced, expected);
    }

    @Test
    public void testMapToInt() {
        List<String> strings = List.of("alpha", "beta", "gamma", "delta", "epsilon");
        int sum = strings.stream()
                .mapToInt(String::length)
                .sum();
        Assert.assertEquals(sum, 26);
    }
}