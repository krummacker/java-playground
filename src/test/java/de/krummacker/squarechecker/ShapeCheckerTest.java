package de.krummacker.squarechecker;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShapeCheckerTest {

    /**
     * Make sure that null is recognized.
     */
    @Test
    public void testConstructorNull() {
        Assert.expectThrows(IllegalArgumentException.class, () -> new ShapeChecker(null));
    }

    /**
     * Make sure that too many points are recognized.
     */
    @Test
    public void testConstructorTooManyPoints() {

        Point[] corners = {
                new Point(-2, 0),
                new Point(2, 0),
                new Point(0, -2),
                new Point(0, 2),
                new Point(-2, 0),
                new Point(2, 0),
                new Point(0, -2),
                new Point(0, 2)
        };

        Assert.expectThrows(IllegalArgumentException.class, () -> new ShapeChecker(corners));
    }

    /**
     * Make sure that not enough points are recognized.
     */
    @Test
    public void testConstructorNotEnoughPoints() {

        Point[] corners = {
                new Point(10, 10),
                new Point(0, 0),
                new Point(0, 20)
        };

        Assert.expectThrows(IllegalArgumentException.class, () -> new ShapeChecker(corners));
    }

    /**
     * Make sure that a simple square is recognized.
     */
    @Test
    public void testSquareSimple() {

        Point[] corners = {
                new Point(0, 10),
                new Point(10, 0),
                new Point(0, 0),
                new Point(10, 10)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertTrue(checker.isSquare());
    }

    /**
     * Make sure that a square around the center of the graph is recognized.
     */
    @Test
    public void testSquareCenter() {

        Point[] corners = {
                new Point(-2, 0),
                new Point(2, 0),
                new Point(0, -2),
                new Point(0, 2)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertTrue(checker.isSquare());
    }

    /**
     * Make sure that a rectangle is not recognized as a square.
     */
    @Test
    public void testSquareRectangle() {

        Point[] corners = {
                new Point(0, 20),
                new Point(10, 0),
                new Point(0, 0),
                new Point(10, 20)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isSquare());
    }

    /**
     * Make sure that a point is not recognized as a square.
     */
    @Test
    public void testSquarePoint() {

        Point[] corners = {
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isSquare());
    }

    /**
     * Make sure that a line segment is not recognized as a square.
     */
    @Test
    public void testSquareLineSegment() {

        Point[] corners = {
                new Point(1, 2),
                new Point(10, 2),
                new Point(1, 2),
                new Point(10, 2)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isSquare());
    }

    /**
     * Make sure that a triangle is not recognized as a square.
     */
    @Test
    public void testSquareTriangle() {

        Point[] corners = {
                new Point(10, 10),
                new Point(10, 10),
                new Point(0, 0),
                new Point(0, 20)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isSquare());
    }

    /**
     * Make sure that a weird figure is not recognized as a square.
     */
    @Test
    public void testSquareWeird() {

        Point[] corners = {
                new Point(123, 456),
                new Point(789, 101112),
                new Point(131415, 161718),
                new Point(192021, 222324)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isSquare());
    }

    /**
     * Make sure that a simple rectangle is recognized.
     */
    @Test
    public void testRectangleSimple() {

        Point[] corners = {
                new Point(0, 20),
                new Point(10, 0),
                new Point(0, 0),
                new Point(10, 20)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertTrue(checker.isRectangle());
    }

    /**
     * Make sure that a more complex rectangle whose sides are not parallel
     * to the axes is recognized.
     */
    @Test
    public void testRectangleComplex() {

        Point[] corners = {
                new Point(-2, -3),
                new Point(2, 1),
                new Point(1, 2),
                new Point(-3, -2)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertTrue(checker.isRectangle());
    }

    /**
     * Make sure that a point is not recognized as a rectangle.
     */
    @Test
    public void testRectanglePoint() {

        Point[] corners = {
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isRectangle());
    }

    /**
     * Make sure that a line segment is not recognized as a rectangle.
     */
    @Test
    public void testRectangleLineSegment() {

        Point[] corners = {
                new Point(1, 2),
                new Point(10, 2),
                new Point(1, 2),
                new Point(10, 2)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isRectangle());
    }

    /**
     * Make sure that a triangle is not recognized as a rectangle.
     */
    @Test
    public void testRectangleTriangle() {

        Point[] corners = {
                new Point(10, 10),
                new Point(10, 10),
                new Point(0, 0),
                new Point(0, 20)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isRectangle());
    }

    /**
     * Make sure that a weird figure is not recognized as a rectangle.
     */
    @Test
    public void testRectangleWeird() {

        Point[] corners = {
                new Point(123, 456),
                new Point(789, 101112),
                new Point(131415, 161718),
                new Point(192021, 222324)
        };

        ShapeChecker checker = new ShapeChecker(corners);
        Assert.assertFalse(checker.isRectangle());
    }
}
