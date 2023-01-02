import java.util.Set;

public class GameSimulation {
    private static final Set<String> graphicItems = Set.of(Graphic.EMPTYCELL, Graphic.FOOD, Graphic.ZOMBIE, Graphic.BORDERCELL);

    public static Vector mapMove(final Map map, final Vector move, final Score score, Vector newCoordinates) {
        final Vector v = newCoordinates.add(move);
        if (graphicItems.contains(map.getCell(v))) {
            newCoordinates = v;
            findItemProcess(map, newCoordinates, score);
        }
        return newCoordinates;
    }

    public static Vector borderMove(final Map map, final Score score, Vector newCoordinates) {
        if (map.getCell(newCoordinates).equals(Graphic.BORDERCELL)) {
            if (newCoordinates.getY() == 0) {
                newCoordinates = Vector.of(newCoordinates.getX(), map.getHeight() - 2);
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

    public static void findItemProcess(final Map iMap, final Vector iCoordinates, final Score iScore) {
        if (iMap.getCell(iCoordinates).equals(Graphic.FOOD)) {
            iMap.setCell(iCoordinates.getX(), iCoordinates.getY(), Graphic.EMPTYCELL);
            MapHelper.placeRandom(iMap, Graphic.FOOD);
            iScore.addPoint();
        }
        if (iMap.getCell(iCoordinates).equals(Graphic.ZOMBIE)) {
            iMap.setCell(iCoordinates.getX(), iCoordinates.getY(), Graphic.EMPTYCELL);
            MapHelper.placeRandom(iMap, Graphic.ZOMBIE);
            iScore.resetScore();
        }
    }
}
