public class Game {
    public void run() {
        final Map map = new Map();
        final Score score = new Score();
        Draw.mapInit(map);
        Draw.placeRandom(map, Graphic.FOOD);
        Draw.placeRandom(map, Graphic.ZOMBIE);
        for (; ; ) {
            GraphicHelper.clearScreen();
            Draw.drawMap(map, map.getPlayerCoordinates());
            Draw.showScore(score);
            Move.processKeyboard(map,score);
        }
    }
}
