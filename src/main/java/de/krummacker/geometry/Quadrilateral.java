package de.krummacker.geometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * A quadrilateral is a four-sided polygon with 4 corners.
 *
 * @param a the first corner point
 * @param b the second corner point
 * @param c the third corner point
 * @param d the fourth corner point
 */
public record Quadrilateral(Point a, Point b, Point c, Point d) {

    /**
     * Creates a new quadrilateral. The corner points may not be null.
     */
    public Quadrilateral {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException("corner cannot be null");
        }
        if (a.equals(b) || a.equals(c) || a.equals(d)
                || b.equals(c) || b.equals(d) || c.equals(d)) {
            throw new IllegalArgumentException("duplicate corners");
        }
    }

    /**
     * Returns the line segments that are the borders of this quadrilateral. This implementation
     * ensures that line segments are not crossing each other.
     *
     * @return the borders
     */
    public List<LineSegment> getBorders() {
        var leftMost = Point.findLeftmost(Set.of(a, b, c, d));
        var topMost = Point.findTopmost(leftMost);
        var start = topMost.iterator().next();
        var corners = new ArrayList<>(List.of(a, b, c, d));
        corners.remove(start);

        var first = corners.stream()
                .map(corner -> new LineSegment(start, corner))
                .max(Comparator.comparingDouble(LineSegment::getSlope))
                .orElseThrow();
        corners.remove(first.b());

        var last = corners.stream()
                .map(corner -> new LineSegment(start, corner))
                .min(Comparator.comparingDouble(LineSegment::getSlope))
                .orElseThrow();
        corners.remove(last.b());

        var fourth = corners.getFirst();
        var second = new LineSegment(first.b(), fourth);
        var third = new LineSegment(fourth, last.b());
        var lastSwapped = new LineSegment(last.b(), last.a());

        return List.of(first, second, third, lastSwapped);
    }

    /**
     * Returns true if this quadrilateral is a parallelogram, i.e., if opposite borders are parallel
     * to each other.
     *
     * @return true if parallelogram
     */
    public boolean isParallelogram() {
        var borders = getBorders();
        return borders.get(0).isParallelTo(borders.get(2)) &&
                borders.get(1).isParallelTo(borders.get(3));
    }

    /**
     * Returns true if this quadrilateral is a rhombus, i.e., if all borders have the same length.
     *
     * @return true if rhombus
     */
    public boolean isRhombus() {
        var count = getBorders().stream()
                .map(LineSegment::getLength)
                .distinct()
                .count();
        return count == 1;
    }

    /**
     * Returns true if this quadrilateral is a rectangle, i.e., if the angles of all corners are
     * rectangular.
     *
     * @return true if rectangle
     */
    public boolean isRectangle() {
        var borders = getBorders();
        return borders.get(0).isOrthogonalTo(borders.get(1)) &&
                borders.get(1).isOrthogonalTo(borders.get(2)) &&
                borders.get(2).isOrthogonalTo(borders.get(3)) &&
                borders.get(3).isOrthogonalTo(borders.get(0));
    }

    /**
     * Returns true if this quadrilateral is a square, i.e., all four sides are of equal length, and
     * all four angles are right angles.
     *
     * @return true if square
     */
    public boolean isSquare() {
        return isRectangle() && isRhombus();
    }
}
