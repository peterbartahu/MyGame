public class GameRun {
    public static void run() {

        Draw.mapInit(Map.getLevel(), Map.getBorderCell(), Map.getEmptyCell());


        Draw.placeRandom(Map.getLevel(), Characters.getDish());


        Draw.placeRandom(Map.getLevel(), Characters.getZombie());


        for (; ; ) {
            Utility.clearScreen();

            Draw.drawMap(Map.getLevel(), Map.getCoordinates(), Characters.getPlayer());

            Draw.showScore();

            Move.moveComplete();
        }
    }
}
