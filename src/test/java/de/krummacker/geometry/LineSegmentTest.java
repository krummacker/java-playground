package de.krummacker.geometry;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit tests for the LineSegment class.
 */
public class LineSegmentTest {

    /**
     * Verifies that the start and end point may not be null.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorNull() {
        new LineSegment(
                new Point(0.0, 0.0),
                null);
    }

    /**
     * Provides test data for methods that require one line segment instance.
     *
     * @return the test data as a table
     */
    @DataProvider
    public Object[][] testDataSingleLineSegment() {

        record TestData(Point a, Point b, double expectedSlope, double expectedLength) {
        }
        TestData[] testData = new TestData[]{
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 1.0),
                        1.0,
                        Math.sqrt(2)
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, -1.0),
                        -1.0,
                        Math.sqrt(2)
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(-1.0, 1.0),
                        -1.0,
                        Math.sqrt(2)
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(0.0, 1.0),
                        Double.POSITIVE_INFINITY,
                        1.0
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(0.0, -1.0),
                        Double.NEGATIVE_INFINITY,
                        1.0
                ),
                new TestData(
                        new Point(-1.0, 2.0),
                        new Point(1.0, 2.0),
                        0.0,
                        2.0
                ),
                new TestData(
                        new Point(1.0, 2.0),
                        new Point(-1.0, 2.0),
                        0.0,
                        2.0
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 0.0),
                        0.0,
                        1.0
                ),
                new TestData(
                        new Point(1.0, -2.0),
                        new Point(1.0, 2.0),
                        Double.POSITIVE_INFINITY,
                        4.0
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(3.0, 4.0),
                        1.3333333333333333,
                        5.0
                ),
                new TestData(
                        new Point(-1.0, -1.0),
                        new Point(3.0, 2.0),
                        0.75,
                        5.0
                ),
        };

        var result = new Object[testData.length][4];
        for (var i = 0; i < result.length; ++i) {
            result[i][0] = testData[i].a;
            result[i][1] = testData[i].b;
            result[i][2] = testData[i].expectedSlope;
            result[i][3] = testData[i].expectedLength;
        }
        return result;
    }

    /**
     * Tests methods that require one line segment instance.
     */
    @Test(dataProvider = "testDataSingleLineSegment")
    public void testTableDrivenSingleLineSegment(Point p1, Point p2,
                                                 double expectedSlope, double expectedLength) {
        var l = new LineSegment(p1, p2);
        Assert.assertEquals(l.getSlope(), expectedSlope);
        Assert.assertEquals(l.getLength(), expectedLength);
    }

    /**
     * Provides test data for methods that require two line segment instances.
     *
     * @return the test data as a table
     */
    @DataProvider
    public Object[][] testDataTwoLineSegments() {

        record TestData(Point a, Point b, Point c, Point d,
                        boolean parallel, boolean orthogonal) {
        }
        TestData[] testData = new TestData[]{
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 1.0),
                        new Point(0.0, 1.0),
                        new Point(1.0, 2.0),
                        true,
                        false
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(10.0, 10.0),
                        new Point(0.0, 20.0),
                        new Point(10.0, 30.0),
                        true,
                        false
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 1.0),
                        new Point(1.0, 2.0),
                        new Point(0.0, 1.0),
                        true,
                        false
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(1.0, 1.0),
                        new Point(0.0, 1.0),
                        new Point(1.0, 0.0),
                        false,
                        true
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(0.0, 1.0),
                        new Point(0.0, 0.0),
                        new Point(1.0, 0.0),
                        false,
                        true
                ),
                new TestData(
                        new Point(0.0, 0.0),
                        new Point(2.0, 1.0),
                        new Point(0.0, 0.0),
                        new Point(-1.0, 2.0),
                        false,
                        true
                ),
                new TestData(
                        new Point(1.0, 1.0),
                        new Point(1.0, 11.0),
                        new Point(2.0, 1.0),
                        new Point(2.0, 11.0),
                        true,
                        false
                ),
                new TestData(
                        new Point(1.0, 1.0),
                        new Point(1.0, 11.0),
                        new Point(2.0, 11.0),
                        new Point(2.0, 1.0),
                        true,
                        false
                ),
                new TestData(
                        new Point(345.0, 12342.0),
                        new Point(-346.0, 54.0),
                        new Point(4.45645, 3234.54234),
                        new Point(-2.0, -1.0),
                        false,
                        false
                ),
        };

        var result = new Object[testData.length][6];
        for (var i = 0; i < result.length; ++i) {
            result[i][0] = testData[i].a;
            result[i][1] = testData[i].b;
            result[i][2] = testData[i].c;
            result[i][3] = testData[i].d;
            result[i][4] = testData[i].parallel;
            result[i][5] = testData[i].orthogonal;
        }
        return result;
    }

    /**
     * Tests methods that require two line segment instances.
     */
    @Test(dataProvider = "testDataTwoLineSegments")
    public void testTableDrivenTwoLineSegments(Point a, Point b, Point c, Point d,
                                               boolean parallel, boolean orthogonal) {
        var l = new LineSegment(a, b);
        var m = new LineSegment(c, d);
        Assert.assertEquals(l.isParallelTo(m), parallel);
        Assert.assertEquals(m.isParallelTo(l), parallel);
        Assert.assertEquals(l.isOrthogonalTo(m), orthogonal);
        Assert.assertEquals(m.isOrthogonalTo(l), orthogonal);
    }
}
