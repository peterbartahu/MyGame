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

    //TODO

    private static Coordinates move(Map map, Coordinates coordinates, int moveX, int moveY, Score score) {

        Coordinates newCoordinates = coordinates;

        newCoordinates = emptyCellMove(map, moveX, moveY, newCoordinates);

        findItem(map, newCoordinates, moveX, moveY, score);

        newCoordinates = borderCellMove(map, moveX, moveY, score, newCoordinates);


        return newCoordinates;
    }

    private static Coordinates borderCellMove(Map map, int moveX, int moveY, Score score, Coordinates newCoordinates) {
        if (map.getCell(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY).equals(Graphic.BORDERCELL)) {
            newCoordinates = new Coordinates(newCoordinates.getX() + moveX, newCoordinates.getY() + moveY);
        }
        if (map.getCell(newCoordinates.getX(), newCoordinates.getY()).equals(Graphic.BORDERCELL)) {
            if (newCoordinates.getY() == 0) {
                newCoordinates = new Coordinates(newCoordinates.getX(), map.getHeight() - 2);
                findBorderItem(map, newCoordinates, score);
            } else if (newCoordinates.getX() == 0) {
                newCoordinates = new Coordinates(map.getWidth() - 2, newCoordinates.getY());
                findBorderItem(map, newCoordinates, score);
            } else if (newCoordinates.getY() == map.getHeight() - 1) {
                newCoordinates = new Coordinates(newCoordinates.getX(), 1);
                findBorderItem(map, newCoordinates, score);
            } else if (newCoordinates.getX() == map.getWidth() - 1) {
                newCoordinates = new Coordinates(1, newCoordinates.getY());
                findBorderItem(map, newCoordinates, score);
            }
        }
        return newCoordinates;
    }

    private static Coordinates emptyCellMove(Map imap, int iMoveX, int iMoveY, Coordinates iNewCoordinates) {
        if (imap.getCell(iNewCoordinates.getX() + iMoveX, iNewCoordinates.getY() + iMoveY).equals(Graphic.EMPTYCELL)) {
            iNewCoordinates = new Coordinates(iNewCoordinates.getX() + iMoveX, iNewCoordinates.getY() + iMoveY);
        }
        return iNewCoordinates;
    }



    //TODO
    public static void findBorderItem(Map iMap, Coordinates iCoordinates, Score iScore) {
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

    public static void findItem(Map iMap, Coordinates iCoordinates, int iMoveX, int iMoveY, Score iScore) {
        if (iMap.getCell(iCoordinates.getX() + iMoveX, iCoordinates.getY() + iMoveY).equals(Graphic.FOOD)) {
            iMap.setCell(iCoordinates.getX() + iMoveX, iCoordinates.getY() + iMoveY, Graphic.EMPTYCELL);
            Draw.placeRandom(iMap, Graphic.FOOD);
            iScore.addPoint();
        }
        if (iMap.getCell(iCoordinates.getX() + iMoveX, iCoordinates.getY() + iMoveY).equals(Graphic.ZOMBIE)) {
            iMap.setCell(iCoordinates.getX() + iMoveX, iCoordinates.getY() + iMoveY, Graphic.EMPTYCELL);
            Draw.placeRandom(iMap, Graphic.ZOMBIE);
            iScore.resetScore();
        }
    }
}
