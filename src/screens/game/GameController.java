package screens.game;

import screens.gameover.GameOverController;
import screens.gameover.GameOverView;
import utilities.KeyboardListener;
import viewmanager.ViewManager;
import viewmanager.ViewNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameController {

    private final GameModel model;
    private final GameView view;
    private Thread gameLoop;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.view.addReturnButtonListener(new ReturnListener());
        this.view.updatePointsLabel(this.model.getPoints());
        this.startGameLoop();
    }

    public void startGameLoop() {
        this.gameLoop = new Thread(this::run);
        this.gameLoop.start();
    }

    public void resetGame() {
        this.model.resetGame();
    }

    public void run() {
        long tick = 1;
        this.resetGame();
        while (true) {
            if (tick % KeyboardListener.INPUT_DELAY == 0) {
                this.handlePressedKey();
            }
            if (tick % this.model.getGameSpeed() == 0) {
                this.model.moveSnake();
                if (this.model.isGameOver()) {
                    this.displayGameOverScreen();
                    return;
                }
                if (this.model.isFoodEaten()) {
                    this.model.lengthenSnake();
                    this.model.addPoints();
                    this.model.increaseGameSpeed();
                    this.view.updatePointsLabel(this.model.getPoints());
                    this.model.generateFood();
                }
                this.view.repaintSnakePanel();
            }
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                return;
            }
            ++tick;
        }
    }

    public void handlePressedKey() {
        switch (KeyboardListener.getPressedKey()) {
            case KeyEvent.VK_SPACE:
                this.pauseGame();
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                this.model.setSnakeMoveDirection(Directions.UP);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                this.model.setSnakeMoveDirection(Directions.DOWN);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                this.model.setSnakeMoveDirection(Directions.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                this.model.setSnakeMoveDirection(Directions.RIGHT);
                break;
            case KeyEvent.VK_ADD:
                Pixel.increaseSize();
                this.view.repaintSnakePanel();
                break;
            case KeyEvent.VK_SUBTRACT:
                Pixel.decreaseSize();
                this.view.repaintSnakePanel();
                break;
        }
        KeyboardListener.clearPressedKey();
    }

    public void pauseGame() {
        this.view.setPausedLabel(true);
        KeyboardListener.clearPressedKey();
        while (KeyboardListener.getPressedKey() != KeyEvent.VK_SPACE) {
            try {
                Thread.sleep(KeyboardListener.INPUT_DELAY);
            } catch (Exception ignore) {
            }
        }
        this.view.setPausedLabel(false);
    }

    public void displayGameOverScreen() {
        GameOverView gameOverView = new GameOverView(this.model.getPoints());
        GameOverController gameOverController = new GameOverController(gameOverView, this);
        ViewManager.add(gameOverView, ViewNames.GAME_OVER);
        ViewManager.show(ViewNames.GAME_OVER);
    }

    public class ReturnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewManager.show(ViewNames.START);
            ViewManager.remove(ViewNames.GAME);
        }

    }

}
