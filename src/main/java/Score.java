public final class Score {
    public static int score = 0;

    public static int getScore() {
        return score;
    }

    public static void addPoint() {
        score++;
    }

    public static int zeroScore() {
        return score = 0;
    }

    private Score() {

    }
}
