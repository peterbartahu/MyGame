public class Map {
    private final String[][] map;
    private Vector coordinates;

    public Map() {
        map = new String[10][10];
        coordinates = Vector.of(1, 1);
    }

    public String getCell(Vector coordinates) {
        return map[coordinates.getX()][coordinates.getY()];
    }

    public void setCell(int x, int y, String value) {
        map[x][y] = value;
    }

    public Vector getPlayerCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Vector coordinates) {
         this.coordinates = coordinates;
    }

    public int getWidth(){
        return map[0].length;
    }

    public int getHeight(){
        return map.length;
    }
}
