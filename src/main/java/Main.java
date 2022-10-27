import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private String[][] level = new String[10][10];
    private final String playerMark = "@";
    //    private final String playerMark = "\uD83E\uDDD9";
//    private final String ZOMBIE = "\uD83E\uDDDF";
    private final String ZOMBIE = "Z";
    private final String DISH = "o";
    //    private final String DISH = "\uD83C\uDF4E";
    Random random = new Random();
    private int row = 8;
    private int column = 1;
    String message = "Your score now: ";
    private static int currentScore = 0;
    private final String BORDER = "'";

    private Scanner scanner = new Scanner(System.in);
    private final static String EMPTY = " ";


    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * This method delete previous maps if you run the program in Comman Line.
     */
    private void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method draw the map, empty cells and borders.
     */
    private void mapInit() {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (i == 0 || j == 0 || i == level.length - 1 || j == level.length - 1) {
                    level[i][j] = BORDER;
                } else {
                    level[i][j] = EMPTY;
                }
            }
        }
        dishOnMap();
        zombieOnMap();
    }


    /**
     * Place dish on random place
     */
    private void dishOnMap() {
        level[random.nextInt((level.length - 1) - 1) + 1][random.nextInt((level.length - 1) - 1) + 1] = DISH;
    }

    /**
     * Zombie on map
     */
    private void zombieOnMap() {
        level[random.nextInt((level.length - 1) - 1) + 1][random.nextInt((level.length - 1) - 1) + 1] = ZOMBIE;
    }

    private void draw() {
        clear();
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (i == row && j == column) {
                    System.out.print(playerMark);
                } else {
                    System.out.print(level[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println(message + currentScore);
    }

    /**
     * Player moving method
     */
    private void processInput() {
        System.out.println("Please press te direction");
        switch (scanner.nextLine().toLowerCase()) {
            case "w":
                if (level[row - 1][column].equals(DISH)) {
                    level[row - 1][column] = EMPTY;

                    dishOnMap();
//                    zombieOnMap();
                    ++currentScore;
                    break;
                }

                if (level[row - 1][column].equals(EMPTY)) {
                    row--;
                    break;
                }
                if (level[row - 1][column].equals(BORDER)) {
                    row = level.length - 2;
                    break;
                }

            case "a":

                if (level[row][column - 1].equals(DISH)) {
                    level[row][column - 1] = EMPTY;
                    dishOnMap();
//                    zombieOnMap();
                    ++currentScore;
                    break;
                }
                if (level[row][column - 1].equals(EMPTY)) {
                    column--;
                    break;
                }
                if (level[row][column - 1].equals(BORDER)) {
                    column = level.length-2;
                    break;
                }

            case "s":

                if (level[row + 1][column].equals(DISH)) {
                    level[row + 1][column] = EMPTY;

                    dishOnMap();
//                    zombieOnMap();
                    ++currentScore;
                    break;
                }

                if (level[row + 1][column].equals(EMPTY)) {
                    row++;
                    break;
                }
                if (level[row + 1][column].equals(BORDER)) {
                    row = 1;
                    break;
                }

            case "d":
                if (level[row][column + 1].equals(DISH)) {
                    level[row][column + 1] = EMPTY;

                    dishOnMap();
//                    zombieOnMap();
                    ++currentScore;
                    break;
                }
                if (level[row][column + 1].equals(EMPTY)) {
                    column++;
                    break;
                }
                if (level[row][column + 1].equals(BORDER)) {
                    column = 1;
                    break;
                }
        }
    }

    /**
     * Program run method.
     */
    private void run() {
        mapInit();

        for (; ; ) {

            draw();

            processInput();
        }
    }
}
