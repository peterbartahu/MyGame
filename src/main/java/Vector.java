public class Vector {
    private final int x;
    private final int y;

    private Vector(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Vector of(final int x, final int y) {
        return new Vector(x, y);
    }

    public Vector add(final Vector move) {
        return Vector.of(x + move.getX(), y + move.getY());
    }
}
