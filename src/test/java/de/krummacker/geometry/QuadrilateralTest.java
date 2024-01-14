package de.krummacker.geometry;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Unit tests for the Quadrilateral class.
 */
public class QuadrilateralTest {

    /**
     * Verifies the constructor.
     */
    @Test
    public void testConstructorValid() {
        new Quadrilateral(
                new Point(0.0, 0.0),
                new Point(1.0, 0.0),
                new Point(1.0, 1.0),
                new Point(0.0, 1.0));
    }

    /**
     * Verifies that we cannot provide null values to the constructor.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorNull() {
        new Quadrilateral(
                new Point(0.0, 0.0),
                null,
                new Point(1.0, 1.0),
                new Point(0.0, 1.0));
    }

    /**
     * Verifies that we cannot provide duplicate corner points to the constructor.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorDuplicateCorner() {
        new Quadrilateral(
                new Point(0.0, 0.0),
                new Point(1.0, 0.0),
                new Point(1.0, 1.0),
                new Point(1.0, 1.0));
    }

    /**
     * Provides test data for Quadrilateral methods.
     *
     * @return the test data as a table
     */
    @DataProvider
    public Object[][] testData() {

        record TestData(Point a, Point b, Point c, Point d,
                        LineSegment expected1, LineSegment expected2,
                        LineSegment expected3, LineSegment expected4,
                        boolean parallelogram, boolean rhombus,
                        boolean rectangle, boolean square) {
        }
        TestData[] testData = new TestData[]{
                new TestData(
                        new Point(0.0, 4.0),
                        new Point(4.0, 4.0),
                        new Point(4.0, 0.0),
                        new Point(0.0, 0.0),
                        new LineSegment(new Point(0.0, 4.0), new Point(4.0, 4.0)),
                        new LineSegment(new Point(4.0, 4.0), new Point(4.0, 0.0)),
                        new LineSegment(new Point(4.0, 0.0), new Point(0.0, 0.0)),
                        new LineSegment(new Point(0.0, 0.0), new Point(0.0, 4.0)),
                        true, true, true, true
                ),
                new TestData(
                        new Point(2.0, -1.0),
                        new Point(3.0, 2.0),
                        new Point(1.0, 3.0),
                        new Point(0.0, 0.0),
                        new LineSegment(new Point(0.0, 0.0), new Point(1.0, 3.0)),
                        new LineSegment(new Point(1.0, 3.0), new Point(3.0, 2.0)),
                        new LineSegment(new Point(3.0, 2.0), new Point(2.0, -1.0)),
                        new LineSegment(new Point(2.0, -1.0), new Point(0.0, 0.0)),
                        true, false, false, false
                ),
                new TestData(
                        new Point(-3.0, 0.0),
                        new Point(-1.0, 0.0),
                        new Point(1.0, 0.0),
                        new Point(3.0, 0.0),
                        new LineSegment(new Point(-3.0, 0.0), new Point(-1.0, 0.0)),
                        new LineSegment(new Point(-1.0, 0.0), new Point(3.0, 0.0)),
                        new LineSegment(new Point(3.0, 0.0), new Point(1.0, 0.0)),
                        new LineSegment(new Point(1.0, 0.0), new Point(-3.0, 0.0)),
                        true, false, false, false
                ),
                new TestData(
                        new Point(1.0, 0.0),
                        new Point(2.0, 0.0),
                        new Point(3.0, 0.0),
                        new Point(2.0, 1.0),
                        new LineSegment(new Point(1.0, 0.0), new Point(2.0, 1.0)),
                        new LineSegment(new Point(2.0, 1.0), new Point(3.0, 0.0)),
                        new LineSegment(new Point(3.0, 0.0), new Point(2.0, 0.0)),
                        new LineSegment(new Point(2.0, 0.0), new Point(1.0, 0.0)),
                        false, false, false, false
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 0.0),
                        new Point(1.0, 1.0),
                        new Point(0.0, 1.0),
                        new LineSegment(new Point(0.0, 1.0), new Point(1.0, 1.0)),
                        new LineSegment(new Point(1.0, 1.0), new Point(1.0, 0.0)),
                        new LineSegment(new Point(1.0, 0.0), new Point(0.0, 0.0)),
                        new LineSegment(new Point(0.0, 0.0), new Point(0.0, 1.0)),
                        true, true, true, true
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 1.0),
                        new Point(5.0, 1.0),
                        new Point(4.0, 0.0),
                        new LineSegment(new Point(0.0, 0.0), new Point(1.0, 1.0)),
                        new LineSegment(new Point(1.0, 1.0), new Point(5.0, 1.0)),
                        new LineSegment(new Point(5.0, 1.0), new Point(4.0, 0.0)),
                        new LineSegment(new Point(4.0, 0.0), new Point(0.0, 0.0)),
                        true, false, false, false
                ),
                new TestData(
                        new Point(0.0, 5.0),
                        new Point(0.0, -5.0),
                        new Point(10.0, 0.0),
                        new Point(-10.0, 0.0),
                        new LineSegment(new Point(-10.0, 0.0), new Point(0.0, 5.0)),
                        new LineSegment(new Point(0.0, 5.0), new Point(10.0, 0.0)),
                        new LineSegment(new Point(10.0, 0.0), new Point(0.0, -5.0)),
                        new LineSegment(new Point(0.0, -5.0), new Point(-10.0, 0.0)),
                        true, true, false, false
                ),
                new TestData(
                        new Point(0.0, 20.0),
                        new Point(0.0, -20.0),
                        new Point(20.0, 0.0),
                        new Point(-20.0, 0.0),
                        new LineSegment(new Point(-20.0, 0.0), new Point(0.0, 20.0)),
                        new LineSegment(new Point(0.0, 20.0), new Point(20.0, 0.0)),
                        new LineSegment(new Point(20.0, 0.0), new Point(0.0, -20.0)),
                        new LineSegment(new Point(0.0, -20.0), new Point(-20.0, 0.0)),
                        true, true, true, true
                ),
        };

        var result = new Object[testData.length][12];
        for (var i = 0; i < result.length; ++i) {
            result[i][0] = testData[i].a;
            result[i][1] = testData[i].b;
            result[i][2] = testData[i].c;
            result[i][3] = testData[i].d;
            result[i][4] = testData[i].expected1;
            result[i][5] = testData[i].expected2;
            result[i][6] = testData[i].expected3;
            result[i][7] = testData[i].expected4;
            result[i][8] = testData[i].parallelogram;
            result[i][9] = testData[i].rhombus;
            result[i][10] = testData[i].rectangle;
            result[i][11] = testData[i].square;
        }
        return result;
    }

    /**
     * Tests methods of the Quadrilateral class.
     */
    @Test(dataProvider = "testData")
    public void testTableDriven(Point a, Point b, Point c, Point d,
                                LineSegment expected1, LineSegment expected2,
                                LineSegment expected3, LineSegment expected4,
                                boolean parallelogram, boolean rhombus,
                                boolean rectangle, boolean square) {
        var q = new Quadrilateral(a, b, c, d);
        var expectedBorders = List.of(expected1, expected2, expected3, expected4);
        Assert.assertEquals(q.getBorders(), expectedBorders);
        Assert.assertEquals(q.isParallelogram(), parallelogram);
        Assert.assertEquals(q.isRhombus(), rhombus);
        Assert.assertEquals(q.isRectangle(), rectangle);
        Assert.assertEquals(q.isSquare(), square);
    }
}