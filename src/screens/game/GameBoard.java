package screens.game;

import guicomponents.ColorPanel;

import java.awt.*;

public class GameBoard extends ColorPanel {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    private final Snake snake;
    private final Food food;

    public GameBoard(Snake snake, Food food) {
        this.snake = snake;
        this.food = food;
        this.setPreferredSize(new Dimension(WIDTH * Pixel.SIZE, HEIGHT * Pixel.SIZE));
        this.setSize(WIDTH * Pixel.SIZE, HEIGHT * Pixel.SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paintGameBoardBorder(g);
        this.paintGameBoard(g);
        this.paintSnake(g);
        this.paintFood(g);
    }

    private void paintGameBoardBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, WIDTH * Pixel.SIZE, HEIGHT * Pixel.SIZE);
    }

    private void paintRect(Graphics g, int x, int y, Color fillColor) {
        g.setColor(fillColor);
        g.fillRect(x, y, Pixel.SIZE, Pixel.SIZE);
    }

    private void paintCircle(Graphics g, int x, int y, int width, int height, Color fillColor, Color borderColor, int arcWidth, int arcHeight) {
        g.setColor(fillColor);
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
        g.setColor(borderColor);
        g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    private void paintGameBoard(Graphics g) {
        for (int row = 0; row < HEIGHT; ++row) {
            for (int column = 0; column < WIDTH; ++column) {
                this.paintRect(g, column * Pixel.SIZE, row * Pixel.SIZE, Color.BLACK);
            }
        }
    }

    private void paintSnake(Graphics g) {
        int counter = 0;
        int length = this.snake.getBodySegments().size();
        for (var segment : this.snake.getBodySegments()) {
            int segmentSizeDecrease = counter * 10 / length;
            int segmentX = segment.x() * Pixel.SIZE + segmentSizeDecrease / 2;
            int segmentY = segment.y() * Pixel.SIZE + segmentSizeDecrease / 2;
            this.paintCircle(g, segmentX, segmentY, Pixel.SIZE - segmentSizeDecrease, Pixel.SIZE - segmentSizeDecrease, Color.GREEN, Color.YELLOW, 20, 20);
            ++counter;
        }
        this.paintSnakeEye(g);
    }

    private void paintSnakeEye(Graphics g) {
        Point head = this.snake.getHead();
        this.paintCircle(g, head.x() * Pixel.SIZE + Pixel.SIZE / 2, head.y() * Pixel.SIZE + Pixel.SIZE / 2, Pixel.SIZE / 4, Pixel.SIZE / 4, Color.RED, Color.GRAY, 90, 90);
    }

    private void paintFood(Graphics g) {
        Point food = this.food.getCoordinates();
        this.paintCircle(g, food.x() * Pixel.SIZE + Pixel.SIZE / 2, food.y() * Pixel.SIZE + Pixel.SIZE / 2, Pixel.SIZE / 4, Pixel.SIZE / 4, Color.YELLOW, Color.GRAY, 90, 90);
    }

}
