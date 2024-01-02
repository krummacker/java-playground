package de.krummacker.squarechecker;

public record Point(int x, int y) {

    /**
     * Returns the square of the distance between this point and another using the Pythagorean theorem.
     */
    public int distanceSquared(Point other) {
        int a = x - other.x();
        int b = y - other.y();
        return a * a + b * b;
    }
}
