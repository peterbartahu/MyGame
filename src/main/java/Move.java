public class Move {
    public static Vector moveProcess(final Map map, final Vector playerCoordinates, final Vector move, final Score score) {
        Vector newCoordinates = playerCoordinates;
        newCoordinates = GameSimulation.mapMove(map, move, score, newCoordinates);
        newCoordinates = GameSimulation.borderMove(map, score, newCoordinates);
        return newCoordinates;
    }
}
