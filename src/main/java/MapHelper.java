import java.util.Random;

public class MapHelper {
    public static void mapInit(final Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (i == 0 || j == 0 || i == map.getHeight() - 1 || j == map.getWidth() - 1) {
                    map.setCell(j, i, Graphic.BORDERCELL);
                } else {
                    map.setCell(j, i, Graphic.EMPTYCELL);
                }
            }
        }
        placeRandom(map, Graphic.FOOD);
        placeRandom(map, Graphic.ZOMBIE);
    }

    public static void drawMap(final Map map, final Vector coordinates) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                final String position;
                if (i == coordinates.getY() && j == coordinates.getX()) {
                    position = Graphic.PLAYER;
                } else {
                    position = map.getCell(Vector.of(j, i));
                }
                System.out.print(position);
            }
            System.out.println();
        }
    }

    public static void placeRandom(final Map map, final String item) {
        final Random random = new Random();
        boolean searchEmpty = true;
        while (searchEmpty) {
            final int y = random.nextInt((map.getHeight() - 1) - 1) + 1;
            final int x = random.nextInt((map.getWidth() - 1) - 1) + 1;
            if (map.getCell(Vector.of(x, y)).equals(Graphic.EMPTYCELL) && !(map.getCell(Vector.of(x, y)).equals(Graphic.PLAYER))) {
                map.setCell(x, y, item);
                searchEmpty = false;
            }
        }
    }
}
