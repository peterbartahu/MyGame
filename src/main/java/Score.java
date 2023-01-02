public class Score {
    private int score = 0;

    private Score() {
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    public static Score of() {
        return new Score();
    }
}
