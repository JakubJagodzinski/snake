package screens.start;

import screens.game.*;
import viewmanager.ViewManager;
import viewmanager.ViewNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {

    private final StartView view;

    public StartController(StartView view) {
        this.view = view;
        this.view.addStartButtonListener(new SignInListener());
        this.view.addQuitButtonListener(new QuitListener());
    }

    public class SignInListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Snake snake = new Snake();
            Food food = new Food();
            GameModel gameModel = new GameModel(snake, food);
            GameBoard gameBoard = new GameBoard(snake, food);
            GameView gameView = new GameView(gameBoard);
            GameController gameController = new GameController(gameModel, gameView);
            ViewManager.add(gameView, ViewNames.GAME);
            ViewManager.show(ViewNames.GAME);
        }
    }

    public class QuitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
