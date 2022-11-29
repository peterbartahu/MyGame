import java.util.Random;
import java.util.Scanner;

public class GameRun {
    public static void run() {


        int[] coordinates = new int[2];
        coordinates[0] = 1;
        coordinates[1] = 1;


        Draw.mapInit(Map.getLevel(), Map.getBorderCell(), Map.getEmptyCell());

        Random random = new Random();
        Draw.placeRandom(Map.getLevel(), Characters.getDish(), random);


        Draw.placeRandom(Map.getLevel(), Characters.getZombieMark(), random);


        for (; ; ) {

            Utility.clearScreen();
            Draw.draw(Map.getLevel(), coordinates[0], coordinates[1], Characters.getPlayerMark());


            System.out.println("Your score now: " + Score.getScore());

            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine().toLowerCase()) {
                case "w":
                    coordinates = Move.move(Map.getLevel(), coordinates[0], coordinates[1], Characters.getDish(), Map.getEmptyCell(), random, Score.getScore(), Characters.getZombieMark(), Map.getBorderCell(), -1, 0, Map.length() - 2, coordinates[1]);
                    break;

                case "a":
                    coordinates = Move.move(Map.getLevel(), coordinates[0], coordinates[1], Characters.getDish(), Map.getEmptyCell(), random, Score.getScore(), Characters.getZombieMark(), Map.getBorderCell(), 0, -1, coordinates[0], Map.length() - 2);
                    break;

                case "s":
                    coordinates = Move.move(Map.getLevel(), coordinates[0], coordinates[1], Characters.getDish(), Map.getEmptyCell(), random, Score.getScore(), Characters.getZombieMark(), Map.getBorderCell(), 1, 0, 1, coordinates[1]);
                    break;

                case "d":
                    coordinates = Move.move(Map.getLevel(), coordinates[0], coordinates[1], Characters.getDish(), Map.getEmptyCell(), random, Score.getScore(), Characters.getZombieMark(), Map.getBorderCell(), 0, 1, coordinates[0], 1);
                    break;
                default:
                    break;
            }
        }
    }
}
