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

    public static void drawMap(String[][] level, int[] coordinates, String playerMark) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                String position;
                if (i == coordinates[0] && j == coordinates[1]) {
                    position = playerMark;
                } else {
                    position = level[i][j];
                }
                System.out.print(position);
            }
            System.out.println();
        }
    }

    public static void placeRandom(String[][] level, String item) {
        Random random = new Random();
        boolean searchEmpty = true;
        while (searchEmpty) {
            int y = random.nextInt((level.length - 1) - 1) + 1;
            int x = random.nextInt((level.length - 1) - 1) + 1;
            if (Map.getCell(y, x).equals(Map.getEmptyCell())) {
                level[y][x] = item;
                searchEmpty = false;
            }
        }
    }

    public static void showScore() {
        System.out.println("Your score now: " + Score.getScore());
    }
}
