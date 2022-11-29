import java.util.Random;

public class Draw {

    public static void mapInit(String[][] level, String borderCell, String emptyCell) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (i == 0 || j == 0 || i == level.length - 1 || j == level.length - 1) {
                    level[i][j] = borderCell;
                } else {
                    level[i][j] = emptyCell;
                }
            }
        }
    }


    public static void draw(String[][] level, int y, int x, String playerMark) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                String position;
                if (i == y && j == x) {
                    position = playerMark;
                } else {
                    position = level[i][j];
                }
                System.out.print(position);
            }
            System.out.println();
        }
    }

    public static void placeRandom(String[][] level, String item, Random random) {
        level[random.nextInt((level.length - 1) - 1) + 1][random.nextInt((level.length - 1) - 1) + 1] = item;
    }
}
