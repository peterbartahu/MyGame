public final class Map {
    private static final String[][] level = new String[10][10];

    private static int[] coordinates = {1, 1};

    private static final String borderCell = "'";
    private static final String emptyCell = " ";


    private Map() {

    }

    public static String getCell(int y, int x) {
        return level[y][x];
    }

    public static int[] getCoordinates() {
        return coordinates;
    }

    public static void setCoordinates(int[] newCoordinates) {
        coordinates = newCoordinates;
    }

    public static int getYCoordinate() {
        return coordinates[0];
    }

    public static int getXCoordinate() {
        return coordinates[1];
    }

    public static String[][] getLevel() {
        return level;
    }


    public static String getBorderCell() {
        return borderCell;
    }


    public static String getEmptyCell() {
        return emptyCell;
    }

    public static int length() {
        return level.length;
    }

}
