public class Map {
    private final String[][] map;
    private Coordinates coordinates;

    public Map() {
        map = new String[10][10];
        coordinates = new Coordinates(1, 1);
    }

    public String getCell(int x, int y) {
        return map[x][y];
    }

    public void setCell(int x, int y, String value) {
        map[x][y] = value;
    }

    public Coordinates getPlayerCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
         this.coordinates = coordinates;
    }

    public int getWidth(){
        return map[0].length;
    }

    public int getHeight(){
        return map.length;
    }
}
