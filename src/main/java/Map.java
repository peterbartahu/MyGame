public class Map {
    private final String[][] map;
    private Coordinates playerCoordinates;

    public Map() {
        map = new String[10][10];
        playerCoordinates = Coordinates.of(1, 1);
    }

    public String getCell(final Coordinates coordinates) {
        return map[coordinates.getX()][coordinates.getY()];
    }

    public void setCell(final int x, final int y, final String value) {
        map[x][y] = value;
    }

    public Coordinates getPlayerCoordinates() {
        return playerCoordinates;
    }

    public void setPlayerCoordinates(final Coordinates playerCoordinates) {
        this.playerCoordinates = playerCoordinates;
    }

    public int getWidth() {
        return map[0].length;
    }

    public int getHeight() {
        return map.length;
    }
}
