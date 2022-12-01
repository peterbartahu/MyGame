public final class Score {
    private static int score = 0;

    private Score() {

    }

    public static int getScore() {
        return score;
    }

    public static void addPoint() {
        score++;
    }

    public static void zeroScore() {
        score = 0;
    }
}
