package de.krummacker.squarechecker;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Returns the square of the distance between this point and another using the Pythagorean theorem.
     */
    public int distanceSquared(Point other) {
        int a = x - other.getX();
        int b = y - other.getY();
        return a * a + b * b;
    }
}
