import java.util.Scanner;

public class Game {
    private final Map map = new Map();
    private final Score score = Score.of();
    private Vector direction; //Kell hogy legyen egy setter, és ezt fogja használni

    public Game() {
        MapHelper.mapInit(map);
    }

    public void setDirection(final Vector direction) {
        this.direction = direction;
    }

    public Map getMap() {
        return map;
    }

    public Score getScore() {
        return score;
    }

    public static void showScore(final Score score) {
        System.out.println("Your score now: " + score.getScore());
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
        MapHelper.drawMap(getMap(), getMap().getPlayerCoordinates());
        Game.showScore(getScore());
    }

    private void simulate() {
        map.setPlayerCoordinates(Move.moveProcess(map, map.getPlayerCoordinates(), direction, score));
    }

    private void processKeyboard() {
        final Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "w":
                setDirection(Vector.of(0, -1));
                break;
            case "a":
                setDirection(Vector.of(-1, 0));
                break;
            case "s":
                setDirection(Vector.of(0, 1));
                break;
            case "d":
                setDirection(Vector.of(1, 0));
                break;
            default:
                setDirection(Vector.of(0, 0));
                break;
        }
    }
}
