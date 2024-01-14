package de.krummacker.geometry;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Unit tests for the Point class.
 */
public class PointTest {

    /**
     * Verifies the constructor and getters. Strictly speaking, this test is obsolete because this
     * functionality is implemented through the 'record' feature.
     */
    @Test
    public void testConstructAndGet() {
        var p = new Point(0.0, 0.0);
        Assert.assertEquals(p.x(), 0.0);
        Assert.assertEquals(p.y(), 0.0);
    }

    /**
     * Verifies the equals() method. Strictly speaking, this test is obsolete because this
     * functionality is implemented through the 'record' feature.
     */
    @Test
    public void testEqual() {
        var p = new Point(1.0, 2.0);
        var q = new Point(1.0, 2.0);
        Assert.assertEquals(p, q);
    }

    /**
     * Verifies that two different points are not equal. Strictly speaking, this test is obsolete
     * because this functionality is implemented through the 'record' feature.
     */
    @Test
    public void testDifferent() {
        var p = new Point(1.0, 2.0);
        var q = new Point(2.0, 1.0);
        Assert.assertNotEquals(p, q);
    }

    /**
     * Verifies that the findLeftmost() method can find the point with the lowest x coordinate with
     * trivial parameters.
     */
    @Test
    public void testFindLeftMostSimple() {
        var a = new Point(1.0, 2.0);
        var b = new Point(2.0, 1.0);
        var c = new Point(3.0, 5.0);
        var actual = Point.findLeftmost(Set.of(a, b, c));
        var expected = Set.of(a);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Verifies that the findLeftmost() method can find the points with the lowest x coordinates
     * with two points being the solution.
     */
    @Test
    public void testFindLeftMostTwoValues() {
        var a = new Point(-1.0, 2.0);
        var b = new Point(-1.0, 1.0);
        var c = new Point(3.0, 5.0);
        var actual = Point.findLeftmost(Set.of(a, b, c));
        var expected = Set.of(a, b);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Verifies that the findLeftmost() method can find the right solution if all points are
     * leftmost.
     */
    @Test
    public void testFindLeftMostAllValues() {
        var a = new Point(-42.0, 2.0);
        var b = new Point(-42.0, 12.0);
        var c = new Point(-42.0, 25423534.0);
        var d = new Point(-42.0, -534345.0);
        var actual = Point.findLeftmost(Set.of(a, b, c, d));
        var expected = Set.of(a, b, c, d);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Verifies that the findTopmost() method can find the point with the highest y coordinate with
     * trivial parameters.
     */
    @Test
    public void testFindTopMostSimple() {
        var a = new Point(1.0, 2.0);
        var b = new Point(2.0, 1.0);
        var c = new Point(3.0, 5.0);
        var actual = Point.findTopmost(Set.of(a, b, c));
        var expected = Set.of(c);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Verifies that the findTopmost() method can find the points with the highest y coordinates
     * with two points being the solution.
     */
    @Test
    public void testFindTopMostTwoValues() {
        var a = new Point(-1.0, 2.0);
        var b = new Point(-1.0, 5.0);
        var c = new Point(3.0, 5.0);
        var actual = Point.findTopmost(Set.of(a, b, c));
        var expected = Set.of(c, b);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Verifies that the findTopmost() method can find the right solution if all points are
     * topmost.
     */
    @Test
    public void testFindTopMostAllValues() {
        var a = new Point(2.0, -42.0);
        var b = new Point(12.0, -42.0);
        var c = new Point(25423534.0, -42.0);
        var d = new Point(-534345.0, -42.0);
        var actual = Point.findTopmost(Set.of(a, b, c, d));
        var expected = Set.of(a, b, c, d);
        Assert.assertEquals(actual, expected);
    }
}
