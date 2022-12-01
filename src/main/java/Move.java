import java.util.Random;
import java.util.Scanner;

public class Move {
    public static int[] move(String[][] level, int[] coordinates, String dish, String emptyCell, Random random, String zombie, String borderCell, int moveY, int moveX, int teleportOnY, int teleportOnX) {
        if (level[coordinates[0] + moveY][coordinates[1] + moveX].equals(dish)) {
            level[coordinates[0] + moveY][coordinates[1] + moveX] = emptyCell;
            Draw.placeRandom(level, dish);
            Score.addPoint();
        } else if (level[coordinates[0] + moveY][coordinates[1] + moveX].equals(zombie)) {
            level[coordinates[0] + moveY][coordinates[1] + moveX] = emptyCell;
            Draw.placeRandom(level, zombie);
            Score.zeroScore();
        } else if (level[coordinates[0] + moveY][coordinates[1] + moveX].equals(emptyCell)) {
            coordinates[0] += moveY;
            coordinates[1] += moveX;
        } else if (level[coordinates[0] + moveY][coordinates[1] + moveX].equals(borderCell)) {
            coordinates[0] += moveY;
            coordinates[1] += moveX;
        }
        if (level[coordinates[0]][coordinates[1]].equals(borderCell)) {
            coordinates[0] = teleportOnY;
            coordinates[1] = teleportOnX;
        }
        return coordinates;
    }

    public static void moveComplete() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "w":
                Map.setCoordinates(Move.move(Map.getLevel(), Map.getCoordinates(), Characters.getDish(), Map.getEmptyCell(), random, Characters.getZombie(), Map.getBorderCell(), -1, 0, Map.length() - 2, Map.getXCoordinate()));
                break;
            case "a":
                Map.setCoordinates(Move.move(Map.getLevel(), Map.getCoordinates(), Characters.getDish(), Map.getEmptyCell(), random, Characters.getZombie(), Map.getBorderCell(), 0, -1, Map.getYCoordinate(), Map.length() - 2));
                break;
            case "s":
                Map.setCoordinates(Move.move(Map.getLevel(), Map.getCoordinates(), Characters.getDish(), Map.getEmptyCell(), random, Characters.getZombie(), Map.getBorderCell(), 1, 0, 1, Map.getXCoordinate()));
                break;
            case "d":
                Map.setCoordinates(Move.move(Map.getLevel(), Map.getCoordinates(), Characters.getDish(), Map.getEmptyCell(), random, Characters.getZombie(), Map.getBorderCell(), 0, 1, Map.getYCoordinate(), 1));
                break;
            default:
                break;
        }
    }
}
