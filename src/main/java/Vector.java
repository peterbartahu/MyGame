public class Vector {
    private final int x;
    private final int y;

    private Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Vector of(int x, int y) {
        return new Vector(x, y);
    }

    public Vector add(Vector move) {
        return Vector.of(this.x + move.getX(), this.y + move.getY());
    }
}
