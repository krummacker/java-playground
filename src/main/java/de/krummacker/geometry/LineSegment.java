package de.krummacker.geometry;

/**
 * A line segment is a straight line bounded by the end points 'a' and 'b'.
 *
 * @param a the beginning of the line segment
 * @param b the end of the line segment
 */
public record LineSegment(Point a, Point b) {

    /**
     * Creates a new line segment. The start or the end point may not be null.
     */
    public LineSegment {
        if (a == null || b == null) {
            throw new IllegalArgumentException("end point cannot be null");
        }
    }

    /**
     * Returns a value describing the slope of this line segment:
     * <ul>
     *   <li>positive infinity - if the line segment is parallel to the y axis and 'a' is lower than 'b'</li>
     *   <li>a positive value - if the line segment is directed to the top right</li>
     *   <li>zero - if the line segment is parallel to the x axis</li>
     *   <li>a negative value - if the line segment is directed to the bottom right</li>
     *   <li>negative infinity - if the line segment is parallel to the y axis and 'a' is higher than 'b'</li>
     * </ul>
     *
     * @return the slope
     */
    public double getSlope() {
        return (b.y() - a.y()) / (b.x() - a.x());
    }

    /**
     * Returns the distance between the two points of this line segment.
     *
     * @return the length of the line segment
     */
    public double getLength() {
        return Math.sqrt(Math.pow(b.y() - a.y(), 2) + Math.pow(b.x() - a.x(), 2));
    }

    /**
     * Returns true if the specified line segment is parallel to this line segment.
     *
     * @param other the line segment to compare with
     * @return true if parallel
     */
    public boolean isParallelTo(LineSegment other) {
        var thisSlope = getSlope();
        var otherSlope = other.getSlope();
        if (thisSlope == Double.POSITIVE_INFINITY || thisSlope == Double.NEGATIVE_INFINITY) {
            return otherSlope == Double.POSITIVE_INFINITY || otherSlope == Double.NEGATIVE_INFINITY;
        } else {
            return thisSlope == otherSlope;
        }
    }

    /**
     * Returns true if the specified line segment is orthogonal to this line segment, i.e., if there
     * is a right angle between both line segments.
     *
     * @param other the line segment to compare with
     * @return true if orthogonal
     */
    public boolean isOrthogonalTo(LineSegment other) {
        var thisSlope = getSlope();
        var otherSlope = other.getSlope();
        if (thisSlope == Double.POSITIVE_INFINITY || thisSlope == Double.NEGATIVE_INFINITY) {
            return otherSlope == 0.0;
        } else if (thisSlope == 0.0) {
            return otherSlope == Double.POSITIVE_INFINITY || otherSlope == Double.NEGATIVE_INFINITY;
        } else {
            return otherSlope == -1.0 / thisSlope;
        }
    }
}
