package de.krummacker.squarechecker;

import java.util.stream.Stream;

/**
 * Reads 4 Points and determines which type of shape they form.
 */
public class ShapeIdentifier {

    // Strategy:
    //
    // - pick an arbitrary point of the 4
    // - compare it against the other 3
    // - determine the most distant one
    // - the distances between the first point and the two closer ones must
    //   be the same as the distances between the most distant one and the other 2
    // - the resulting shape is a parallelogram
    // - if the distance of the most distant to the first point fulfils the
    //   Pythagorean theorem with respect to the other distances then this is
    //   a rectangle
    // - and if the other two distances are equal then this is a square

    public enum ShapeType {
        POINT,
        LINE_SEGMENT,
        TRIANGLE,
        QUADRILATERAL,
        PARALLELOGRAM,
        RECTANGLE,
        SQUARE
    }

    public ShapeType identify(Point a, Point b, Point c, Point d) {

        // Check arguments for basic sanity.
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }

        // Are all elements equal? Or are there only 2 distinct points?
        switch ((int) Stream.of(a, b, c, d).distinct().count()) {
            case 1:
                return ShapeType.POINT;
            case 2:
                return ShapeType.LINE_SEGMENT;
            case 3:
                return ShapeType.TRIANGLE; // this can also be a line segment!
        }

        // Pick a start point and determine the opposite.
        int distanceB = a.distanceSquared(b);
        int distanceC = a.distanceSquared(c);
        int distanceD = a.distanceSquared(d);
        Point opposite;
        Point between1;
        Point between2;
        if (distanceB > distanceC && distanceB > distanceD) {
            opposite = b;
            between1 = c;
            between2 = d;
        } else if (distanceC > distanceD) {
            opposite = c;
            between1 = b;
            between2 = d;
        } else {
            opposite = d;
            between1 = b;
            between2 = c;
        }

        int distanceStart1 = a.distanceSquared(between1);
        int distanceStart2 = a.distanceSquared(between2);
        int distanceStartOpposite = a.distanceSquared(opposite);
        int distanceOpposite1 = opposite.distanceSquared(between1);
        int distanceOpposite2 = opposite.distanceSquared(between2);
        boolean isRectangleOrSquare = (distanceStartOpposite == distanceStart1 + distanceStart2)
                && (distanceStartOpposite == distanceOpposite1 + distanceOpposite2);

        if (isRectangleOrSquare) {
            long distinctDistances = Stream.of(distanceStart1, distanceStart2, distanceOpposite1, distanceOpposite2)
                    .distinct()
                    .count();
        }

        // TODO: Finish

        return null;
    }
}
