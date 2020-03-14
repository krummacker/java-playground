package de.krummacker.squarechecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareCheckerTest {

    /**
     * Make sure that a simple square is recognized.
     */
    @Test
    void testSimple() {

        Point[] corners = {
                new Point(0, 10),
                new Point(10, 0),
                new Point(0, 0),
                new Point(10, 10)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertTrue(checker.isSquare(corners));
    }

    /**
     * Make sure that a square around the center of the graph is recognized.
     */
    @Test
    void testCenter() {

        Point[] corners = {
                new Point(-2, 0),
                new Point(2, 0),
                new Point(0, -2),
                new Point(0, 2)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertTrue(checker.isSquare(corners));
    }

    /**
     * Make sure that a rectangle is not recognized as a square.
     */
    @Test
    void testRectangle() {

        Point[] corners = {
                new Point(0, 20),
                new Point(10, 0),
                new Point(0, 0),
                new Point(10, 20)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertFalse(checker.isSquare(corners));
    }

    /**
     * Make sure that a point is recognized as a square.
     */
    @Test
    void testPoint() {

        Point[] corners = {
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2),
                new Point(1, 2)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertTrue(checker.isSquare(corners));
    }

    /**
     * Make sure that a point is not recognized as a square.
     */
    @Test
    void testTriangle() {

        Point[] corners = {
                new Point(10, 10),
                new Point(10, 10),
                new Point(0, 0),
                new Point(0, 20)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertFalse(checker.isSquare(corners));
    }

    /**
     * Make sure that a weird figure is not recognized as a square.
     */
    @Test
    void testWeird() {

        Point[] corners = {
                new Point(123, 456),
                new Point(789, 101112),
                new Point(131415, 161718),
                new Point(192021, 222324)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertFalse(checker.isSquare(corners));
    }

    /**
     * Make sure that null is recognized.
     */
    @Test
    void testNull() {
        SquareChecker checker = new SquareChecker();
        Assertions.assertFalse(checker.isSquare(null));
    }

    /**
     * Make sure that too many points are recognized.
     */
    @Test
    void testTooManyPoints() {

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

        SquareChecker checker = new SquareChecker();
        Assertions.assertFalse(checker.isSquare(corners));
    }

    /**
     * Make sure that not enough points are recognized.
     */
    @Test
    void testNotEnoughPoints() {

        Point[] corners = {
                new Point(10, 10),
                new Point(0, 0),
                new Point(0, 20)
        };

        SquareChecker checker = new SquareChecker();
        Assertions.assertFalse(checker.isSquare(corners));
    }
}
