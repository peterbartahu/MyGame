public class Map {
    private final String[][] map;
    private Vector playerCoordinates;

    public Map() {
        map = new String[10][10];
        playerCoordinates = Vector.of(1, 1);
    }

    public String getCell(final Vector coordinates) {
        return map[coordinates.getX()][coordinates.getY()];
    }

    public void setCell(final int x, final int y, final String value) {
        map[x][y] = value;
    }

    public Vector getPlayerCoordinates() {
        return playerCoordinates;
    }

    public void setPlayerCoordinates(final Vector playerCoordinates) {
        this.playerCoordinates = playerCoordinates;
    }

    public int getWidth() {
        return map[0].length;
    }

    public int getHeight() {
        return map.length;
    }
}
