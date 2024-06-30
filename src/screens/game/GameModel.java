package screens.game;

public class GameModel {

    private final Snake snake;
    private final Food food;
    private int points;
    private final int minimalGameSpeed = 100;
    private final int initialGameSpeed = 250;
    private int gameSpeed;

    public GameModel(Snake snake, Food food) {
        this.snake = snake;
        this.food = food;
    }

    public void resetGame() {
        this.gameSpeed = this.initialGameSpeed;
        this.points = 0;
        this.snake.clear();
        this.food.generate();
    }

    public void generateFood() {
        this.food.generate();
    }

    public boolean isFoodEaten() {
        return this.snake.getHead().equals(this.food.getCoordinates());
    }

    public void setSnakeMoveDirection(Directions direction) {
        this.snake.setMoveDirection(direction);
    }

    public void lengthenSnake() {
        this.snake.lengthen(this.food.getCoordinates());
    }

    public void moveSnake() {
        this.snake.makeMove();
    }

    public int getGameSpeed() {
        return this.gameSpeed;
    }

    public void increaseGameSpeed() {
        this.gameSpeed = Math.max(this.minimalGameSpeed, this.gameSpeed - 5);
    }

    public boolean isGameOver() {
        return this.snake.collisionOccurs();
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints() {
        ++this.points;
    }

}
