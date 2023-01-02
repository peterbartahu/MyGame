import java.io.IOException;

public final class ConsoleHelper {
    private ConsoleHelper() {
        throw new UnsupportedOperationException();
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
