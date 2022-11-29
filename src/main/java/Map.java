public final class Map{
    private static final String[][] level = new String[10][10];
//    private static int y = 1;
//    private static int x = 1;

    private static int [] coordinates = {1,1};
    static int y = coordinates[0];
    static int x = coordinates[1];


    private static String borderCell = "'";
    private static String emptyCell = " ";


    private Map(){

    }

    public static int getY() {
        return y;
    }

    public static int getX() {
        return x;
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
