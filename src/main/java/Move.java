import java.util.Random;

public class Move {
    public static int[] move(String[][] level, int y, int x, String dish, String emptyCell, Random random, int currentScore, String zombie, String borderCell, int moveY, int moveX, int teleportOnY, int teleportOnX) {
        int[] coordinates = new int[2];
        if (level[y + moveY][x + moveX].equals(dish)) {
            level[y + moveY][x + moveX] = emptyCell;
            Draw.placeRandom(level, dish, random);
            Score.addPoint();
        } else if (level[y + moveY][x + moveX].equals(zombie)) {
            level[y + moveY][x + moveX] = emptyCell;
            Draw.placeRandom(level, zombie, random);
            Score.zeroScore();
        } else if (level[y + moveY][x + moveX].equals(emptyCell)) {
            y += moveY;
            x += moveX;
        } else if (level[y + moveY][x + moveX].equals(borderCell)) {
            y += moveY;
            x += moveX;
        }
        if (level[y][x].equals(borderCell)) {
            y = teleportOnY;
            x = teleportOnX;
        }
        coordinates[0] = y;
        coordinates[1] = x;
        return coordinates;
    }
}
