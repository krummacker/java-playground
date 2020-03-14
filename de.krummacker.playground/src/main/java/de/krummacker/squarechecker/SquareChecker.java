package de.krummacker.squarechecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareChecker {

    /**
     * Returns true if the specified points are the corners of a square (as opposed to a rectangle
     * or any other figure).
     */
    public boolean isSquare(Point[] points) {

        if (points == null || points.length != 4) {
            return false;
        }

        Point start = points[0];
        List<Point> others = new ArrayList<>();
        others.add(points[1]);
        others.add(points[2]);
        others.add(points[3]);

        List<Integer> distances = new ArrayList<>();
        for (Point other : others) {
            distances.add(start.distanceSquared(other));
        }
        Collections.sort(distances);

        int a = distances.get(0);
        int b = distances.get(1);
        int c = distances.get(2);

        // If the following is true then this is possibly a square.
        if (a == b && a + b == c) {

            // But the most distant point can still be on the other side.
            // First find it.
            Point mostDistant = null;
            List<Point> closerPoints = new ArrayList<>();
            for (Point candidate : others) {
                if (start.distanceSquared(candidate) == c) {
                    mostDistant = candidate;
                } else {
                    closerPoints.add(candidate);
                }
            }
            assert mostDistant != null;

            // Calculate distances between most distant and closer points.
            List<Integer> otherDistances = new ArrayList<>();
            for (Point closerPoint : closerPoints) {
                otherDistances.add(mostDistant.distanceSquared(closerPoint));
            }

            // If both elements equal a (or b) then this is a square.
            // If one or both are different then it is not.
            for (int otherDistance : otherDistances) {
                if (otherDistance != a) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
