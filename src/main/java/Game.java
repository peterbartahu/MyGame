import java.util.Scanner;

public class Game {
    private final Map map = new Map();
    private final Score score = Score.of();
    private Coordinates direction;

    public Game() {
        MapHelper.mapInit(map);
    }

    public void run() {
        for (; ; ) {
            draw();
            processKeyboard();
            simulate();
        }
    }

    private void draw() {
        ConsoleHelper.clearScreen();
        MapHelper.drawMap(map, map.getPlayerCoordinates());
        showScore(score);
    }

    private static void showScore(final Score score) {
        System.out.println("Your score now: " + score.getScore());
    }

    private void simulate() {
        map.setPlayerCoordinates(MapHelper.moveProcess(map, map.getPlayerCoordinates(), direction, score));
    }

    private void processKeyboard() {
        final Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "w":
                setDirection(Coordinates.of(0, -1));
                break;
            case "a":
                setDirection(Coordinates.of(-1, 0));
                break;
            case "s":
                setDirection(Coordinates.of(0, 1));
                break;
            case "d":
                setDirection(Coordinates.of(1, 0));
                break;
            default:
                setDirection(Coordinates.of(0, 0));
                break;
        }
    }

    private void setDirection(final Coordinates direction) {
        this.direction = direction;
    }
}
