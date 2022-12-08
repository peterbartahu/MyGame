import java.util.Random;

public class Draw {
    public static void mapInit(Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (i == 0 || j == 0 || i == map.getHeight() - 1 || j == map.getWidth() - 1) {
                    map.setCell(j, i, Graphic.BORDERCELL);
                } else {
                    map.setCell(j, i, Graphic.EMPTYCELL);
                }
            }
        }
    }

    public static void drawMap(Map map, Coordinates coordinates) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                String position;
                if (i == coordinates.getY() && j == coordinates.getX()) {
                    position = Graphic.PLAYER;
                } else {
                    position = map.getCell(j, i);
                }
                System.out.print(position);
            }
            System.out.println();
        }
    }

    public static void placeRandom(Map map, String item) {
        Random random = new Random();
        boolean searchEmpty = true;
        while (searchEmpty) {
            int y = random.nextInt((map.getHeight() - 1) - 1) + 1;
            int x = random.nextInt((map.getWidth() - 1) - 1) + 1;
            if (map.getCell(x, y).equals(Graphic.EMPTYCELL)) {
                map.setCell(x, y, item);
                searchEmpty = false;
            }
        }
    }

    public static void showScore(Score score) {
        System.out.println("Your score now: " + score.getScore());
    }
}
