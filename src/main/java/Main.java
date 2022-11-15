import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        final String[][] level = new String[10][10];
        int y = 1;
        int x = 1;

        boolean isCritical = false;

        int currentScore = 0;


        String borderCell = "'";
        String emptyCell = " ";

        mapInit(level, borderCell, emptyCell);


        String dish = "o";
        Random random = new Random();
        placeRandom(level, dish, random);


        String zombie = "Z";
        placeRandom(level, zombie, random);


        for (; ; ) {

            clearScreen();
            draw(level, y, x, "@");
            System.out.println("Your score now: " + currentScore);
            if (isCritical) {
                System.out.println("Oops, it's a ZOMBIE. You lost your points.");
                isCritical = false;
            }

            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine().toLowerCase()) {
                case "w":
                    move(level, x, y, dish, emptyCell, currentScore, zombie, borderCell, isCritical);

                    if (level[y - 1][x].equals(dish)) {
                        level[y - 1][x] = emptyCell;
                        placeRandom(level, dish, random);
                        ++currentScore;
                    } else if (level[y - 1][x].equals(zombie)) {
                        level[y - 1][x] = emptyCell;
                        isCritical = true;
                        placeRandom(level, zombie, random);
                        currentScore = 0;
                    } else if (level[y - 1][x].equals(emptyCell)) {
                        y--;
                    } else if (level[y - 1][x].equals(borderCell)) {
                        y--;

                    }
                    if (level[y][x].equals(borderCell)) {
                        y = level.length - 2;

                    }
                    break;

                case "a":
                    if (level[y][x - 1].equals(dish)) {
                        level[y][x - 1] = emptyCell;
                        placeRandom(level, dish, random);
                        ++currentScore;
                    } else if (level[y][x - 1].equals(zombie)) {
                        level[y][x - 1] = emptyCell;
                        isCritical = true;
                        placeRandom(level, zombie, random);
                        currentScore = 0;
                    } else if (level[y][x - 1].equals(emptyCell)) {
                        x--;
                    } else if (level[y][x - 1].equals(borderCell)) {
                        x--;
                    }
                    if (level[y][x].equals(borderCell)) {
                        x = level.length - 2;
                    }
                    break;

                case "s":
                    if (level[y + 1][x].equals(dish)) {
                        level[y + 1][x] = emptyCell;
                        placeRandom(level, dish, random);
                        ++currentScore;
                    } else if (level[y + 1][x].equals(zombie)) {
                        level[y + 1][x] = emptyCell;
                        isCritical = true;
                        placeRandom(level, zombie, random);
                        currentScore = 0;
                    } else if (level[y + 1][x].equals(emptyCell)) {
                        y++;
                    } else if (level[y + 1][x].equals(borderCell)) {
                        y++;
                    }
                    if (level[y][x].equals(borderCell)) {
                        y = 1;
                    }
                    break;

                case "d":
                    if (level[y][x + 1].equals(dish)) {
                        level[y][x + 1] = emptyCell;
                        placeRandom(level, dish, random);
                        ++currentScore;
                    } else if (level[y][x + 1].equals(zombie)) {
                        level[y][x + 1] = emptyCell;
                        isCritical = true;
                        placeRandom(level, zombie, random);
                        currentScore = 0;
                    } else if (level[y][x + 1].equals(emptyCell)) {
                        x++;
                    } else if (level[y][x + 1].equals(borderCell)) {
                        x++;
                    }
                    if (level[y][x].equals(borderCell)) {
                        x = 1;
                    }
                    break;
                default:
                    break;
            }
        }

    }

    private void move(String[][] level, int x, int y, String dish, String emptyCell, int currentScore, String zombie, String borderCell, boolean isCritical) {
        Random random = new Random();
        if (level[y - 1][x].equals(dish)) {
            level[y - 1][x] = emptyCell;
            placeRandom(level, dish, random);
            ++currentScore;
        } else if (level[y - 1][x].equals(zombie)) {
            level[y - 1][x] = emptyCell;
            isCritical = true;
            placeRandom(level, zombie, random);
            currentScore = 0;
        } else if (level[y - 1][x].equals(emptyCell)) {
            y--;
        } else if (level[y - 1][x].equals(borderCell)) {
            y--;

        }
        if (level[y][x].equals(borderCell)) {
            y = level.length - 2;

        }
    }

    private void draw(String[][] level, int y, int x, String playerMark) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                String position;
                if (i == y && j == x) {
                    position = playerMark;
                } else {
                    position = level[i][j];
                }
                System.out.print(position);
            }
            System.out.println();
        }
    }

    private void mapInit(String[][] level, String borderCell, String emptyCell) {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (i == 0 || j == 0 || i == level.length - 1 || j == level.length - 1) {
                    level[i][j] = borderCell;
                } else {
                    level[i][j] = emptyCell;
                }
            }
        }
    }

    private void placeRandom(String[][] level, String item, Random random) {
        level[random.nextInt((level.length - 1) - 1) + 1][random.nextInt((level.length - 1) - 1) + 1] = item;
    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
