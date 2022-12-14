import java.util.Scanner;

public class Move {

    public static void processKeyboard(Map map, Score score) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "w":
                map.setCoordinates(playerMove(map, map.getPlayerCoordinates(), Vector.of(0, -1), score));
                break;
            case "a":
                map.setCoordinates(playerMove(map, map.getPlayerCoordinates(), Vector.of(-1, 0), score));
                break;
            case "s":
                map.setCoordinates(playerMove(map, map.getPlayerCoordinates(), Vector.of(0, 1), score));
                break;
            case "d":
                map.setCoordinates(playerMove(map, map.getPlayerCoordinates(), Vector.of(1, 0), score));
                break;
            default:
                break;
        }
    }


    private static Vector playerMove(Map map, Vector playerCoordinates, Vector move, Score score) {

        Vector newCoordinates = playerCoordinates;

        newCoordinates = mapMove(map, move, score, newCoordinates);

        newCoordinates = borderMove(map, score, newCoordinates);

        return newCoordinates;
    }


    private static Vector mapMove(Map map, Vector move, Score score, Vector newCoordinates) {
        if ((map.getCell(newCoordinates.add(move)).equals(Graphic.EMPTYCELL))
                || (map.getCell(newCoordinates.add(move)).equals(Graphic.FOOD))
                || (map.getCell(newCoordinates.add(move)).equals(Graphic.ZOMBIE))
                || (map.getCell(newCoordinates.add(move)).equals(Graphic.BORDERCELL))) {
            newCoordinates =  newCoordinates.add(move);
            findItemProcess(map, newCoordinates, score);
        }
        return newCoordinates;
    }

    private static Vector borderMove(Map map, Score score, Vector newCoordinates) {
        if (map.getCell(newCoordinates).equals(Graphic.BORDERCELL)) {
            if (newCoordinates.getY() == 0) {
                newCoordinates =  Vector.of(newCoordinates.getX(), map.getHeight() - 2);
                findItemProcess(map, newCoordinates, score);
            } else if (newCoordinates.getX() == 0) {
                newCoordinates = Vector.of(map.getWidth() - 2, newCoordinates.getY());
                findItemProcess(map, newCoordinates, score);
            } else if (newCoordinates.getY() == map.getHeight() - 1) {
                newCoordinates = Vector.of(newCoordinates.getX(), 1);
                findItemProcess(map, newCoordinates, score);
            } else if (newCoordinates.getX() == map.getWidth() - 1) {
                newCoordinates = Vector.of(1, newCoordinates.getY());
                findItemProcess(map, newCoordinates, score);
            }
        }
        return newCoordinates;
    }

    private static void findItemProcess(Map iMap, Vector iCoordinates, Score iScore) {
        if (iMap.getCell(iCoordinates).equals(Graphic.FOOD)) {
            iMap.setCell(iCoordinates.getX(), iCoordinates.getY(), Graphic.EMPTYCELL);
            Draw.placeRandom(iMap, Graphic.FOOD);
            iScore.addPoint();
        }
        if (iMap.getCell(iCoordinates).equals(Graphic.ZOMBIE)) {
            iMap.setCell(iCoordinates.getX(), iCoordinates.getY(), Graphic.EMPTYCELL);
            Draw.placeRandom(iMap, Graphic.ZOMBIE);
            iScore.resetScore();
        }
    }
}
