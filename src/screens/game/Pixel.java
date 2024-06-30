package screens.game;

import java.awt.*;

public record Pixel(Color color) {

    public static int SIZE = 35;
    private static final int MAX_SIZE = 45;
    private static final int MIN_SIZE = 20;

    public static void increaseSize() {
        SIZE = Math.min(MAX_SIZE, SIZE + 1);
    }

    public static void decreaseSize() {
        SIZE = Math.max(MIN_SIZE, SIZE - 1);
    }

}
