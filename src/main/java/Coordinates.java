public class Coordinates {
    private final int x;
    private final int y;

    private Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Coordinates of(final int x, final int y) {
        return new Coordinates(x, y);
    }

    public Coordinates add(final Coordinates move) {
        return Coordinates.of(x + move.getX(), y + move.getY());
    }
}
