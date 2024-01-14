package de.krummacker.geometry;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A point is a position in two-dimensional space.
 *
 * @param x the coordinate on the x-axis
 * @param y the coordinate on the y-axis
 */
public record Point(double x, double y) {

    /**
     * Finds the point or points in the specified list that have the smallest value of x, i.e., that
     * are leftmost on the coordinate system.
     *
     * @param toCheck the points to inspect
     * @return one or more points that have the smallest x coordinate
     */
    public static Set<Point> findLeftmost(Set<Point> toCheck) {
        var smallestX = toCheck.stream()
                .max((p1, p2) -> Double.compare(p2.x(), p1.x()))
                .orElseThrow()
                .x();
        var stream = toCheck.stream()
                .filter(p -> p.x() == smallestX);
        return stream.collect(Collectors.toSet());
    }

    /**
     * Finds the point or points in the specified list that have the highest value of y, i.e., that
     * are topmost on the coordinate system.
     *
     * @param toCheck the points to inspect
     * @return one or more points that have the highest y coordinate
     */
    public static Set<Point> findTopmost(Set<Point> toCheck) {
        var highestY = toCheck.stream()
                .max(Comparator.comparingDouble(Point::y))
                .orElseThrow()
                .y();
        var stream = toCheck.stream()
                .filter(p -> p.y() == highestY);
        return stream.collect(Collectors.toSet());
    }
}
