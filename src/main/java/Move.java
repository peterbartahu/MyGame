import java.util.Scanner;

public class Move {

    public static void processKeyboard(Map map, Score score) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "w":
                map.setCoordinates(move(map, map.getPlayerCoordinates(), 0, -1, score));
                break;
            case "a":
                map.setCoordinates(move(map, map.getPlayerCoordinates(), -1, 0, score));
                break;
            case "s":
                map.setCoordinates(move(map, map.getPlayerCoordinates(), 0, 1, score));
                break;
            case "d":
                map.setCoordinates(move(map, map.getPlayerCoordinates(), 1, 0, score));
                break;
            default:
                break;
        }
    }


    private static Coordinates move(Map map, Coordinates coordinates, int moveX, int moveY, Score score) {

        Coordinates newCoordinates = coordinates;

        newCoordinates = mapMove(map, moveX, moveY, score, newCoordinates);

        newCoordinates = borderMove(map, score, newCoordinates);

        return newCoordinates;
    }


    private static Coordinates mapMove(Map map, int moveX, int moveY, Score score, Coordinates newCoordinates) {
        if ((map.getCell(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY).equals(Graphic.EMPTYCELL))
                || (map.getCell(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY).equals(Graphic.FOOD))
                || (map.getCell(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY).equals(Graphic.ZOMBIE))
                || (map.getCell(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY).equals(Graphic.BORDERCELL))) {
            newCoordinates = new Coordinates(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY);
            findItemProcess(map, newCoordinates, score);
        }
        return newCoordinates;
    }

    private static Coordinates borderMove(Map map, Score score, Coordinates newCoordinates) {
        if (map.getCell(newCoordinates.getX(), newCoordinates.getY()).equals(Graphic.BORDERCELL)) {
            if (newCoordinates.getY() == 0) {
                newCoordinates = new Coordinates(newCoordinates.getX(), map.getHeight() - 2);
                findItemProcess(map, newCoordinates, score);
            } else if (newCoordinates.getX() == 0) {
                newCoordinates = new Coordinates(map.getWidth() - 2, newCoordinates.getY());
                findItemProcess(map, newCoordinates, score);
            } else if (newCoordinates.getY() == map.getHeight() - 1) {
                newCoordinates = new Coordinates(newCoordinates.getX(), 1);
                findItemProcess(map, newCoordinates, score);
            } else if (newCoordinates.getX() == map.getWidth() - 1) {
                newCoordinates = new Coordinates(1, newCoordinates.getY());
                findItemProcess(map, newCoordinates, score);
            }
        }
        return newCoordinates;
    }

    private static void findItemProcess(Map iMap, Coordinates iCoordinates, Score iScore) {
        if (iMap.getCell(iCoordinates.getX(), iCoordinates.getY()).equals(Graphic.FOOD)) {
            iMap.setCell(iCoordinates.getX(), iCoordinates.getY(), Graphic.EMPTYCELL);
            Draw.placeRandom(iMap, Graphic.FOOD);
            iScore.addPoint();
        }
        if (iMap.getCell(iCoordinates.getX(), iCoordinates.getY()).equals(Graphic.ZOMBIE)) {
            iMap.setCell(iCoordinates.getX(), iCoordinates.getY(), Graphic.EMPTYCELL);
            Draw.placeRandom(iMap, Graphic.ZOMBIE);
            iScore.resetScore();
        }
    }
}
