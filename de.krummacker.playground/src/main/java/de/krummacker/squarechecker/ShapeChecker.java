package de.krummacker.squarechecker;

import java.util.*;

/**
 * Consumes 4 Point instances upon construction and can decide if they form a rectangle, or a square.
 */
public class ShapeChecker {

    private Point start;
    private List<Point> others;

    /**
     * Allows sorting by the distance without losing the Point that the distance refers to.
     */
    private static class DistanceAndPoint implements Comparable<DistanceAndPoint> {

        private int distance;
        private Point point;

        public DistanceAndPoint(int distance, Point point) {
            this.distance = distance;
            this.point = point;
        }

        @Override
        public int compareTo(DistanceAndPoint o) {
            return Integer.compare(distance, o.distance);
        }
    }

    /**
     * Creates a ShapeChecker that can analyse the specified points.
     */
    public ShapeChecker(Point[] points) {

        // Check arguments for basic sanity.
        if (points == null || points.length != 4) {
            throw new IllegalArgumentException();
        }

        // We analyse the points by picking one randomly and looking at its distances to the others.
        start = points[0];
        others = List.of(points[1], points[2], points[3]);
    }

    /**
     * Returns true if this ShapeChecker's points are all the same, i.e. describe a point.
     */
    private boolean isPoint() {
        for (Point other : others) {
            if (!start.equals(other)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if this ShapeChecker's points are the corners of a rectangle. This also includes
     * squares.
     */
    public boolean isRectangle() {
        return checkIfRectangleInternal(false);
    }

    /**
     * Returns true if this ShapeChecker's points are the corners of a square (as opposed to a rectangle
     * or any other figure).
     */
    public boolean isSquare() {
        return checkIfRectangleInternal(true);
    }

    private boolean checkIfRectangleInternal(boolean checkIfSquare) {

        if (isPoint()) {
            return false;
        }

        // Now calculate the distances.
        List<DistanceAndPoint> distances = new ArrayList<>();
        for (Point other : others) {
            int distance = start.distanceSquared(other);
            distances.add(new DistanceAndPoint(distance, other));
        }
        Collections.sort(distances);

        int a = distances.get(0).distance;
        int b = distances.get(1).distance;
        int c = distances.get(2).distance;

        // If any distance is 0 then this is a line segment or triangle
        // and not a proper rectangle.
        if (a == 0 || b == 0 || c == 0) {
            return false;
        }

        // If we need to verify that this is a square then a and b must be equal.
        if (checkIfSquare && a != b) {
            return false;
        }

        // If the following is true then this is possibly a rectangle.
        if (a + b == c) {

            // But the most distant point can still be on the other side.
            Point mostDistant = distances.get(2).point;

            // Calculate distances between most distant and closer points.
            // If this is a square then the second element will overwrite the first,
            // but that does not matter.
            Set<Integer> otherDistances = new HashSet<>();
            otherDistances.add(mostDistant.distanceSquared(distances.get(0).point));
            otherDistances.add(mostDistant.distanceSquared(distances.get(1).point));

            // If both elements equal a and b then this is a rectangle.
            // If one or both are different then it is not.
            Set<Integer> initialDistances = new HashSet<>();
            initialDistances.add(a);
            initialDistances.add(b);

            return otherDistances.equals(initialDistances);
        } else {
            return false;
        }
    }
}
