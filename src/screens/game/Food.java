package screens.game;

import java.util.Random;

public class Food {

    private final Random random = new Random();
    private Point coordinates;

    public void generate() {
        this.coordinates = new Point(this.random.nextInt(GameBoard.WIDTH), this.random.nextInt(GameBoard.HEIGHT));
    }

    public Point getCoordinates() {
        return this.coordinates;
    }

}
