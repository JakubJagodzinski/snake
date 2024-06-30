package screens.gameover;

import screens.game.GameController;
import viewmanager.ViewManager;
import viewmanager.ViewNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverController {

    private final GameOverView view;
    private final GameController gameController;

    public GameOverController(GameOverView view, GameController gameController) {
        this.view = view;
        this.view.addReturnButtonListener(new ReturnListener());
        this.view.addTryAgainButtonListener(new TryAgainListener());
        this.gameController = gameController;
    }

    public class TryAgainListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameController.resetGame();
            ViewManager.show(ViewNames.GAME);
            ViewManager.remove(ViewNames.GAME_OVER);
            gameController.startGameLoop();
        }

    }

    public class ReturnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewManager.show(ViewNames.START);
            ViewManager.remove(ViewNames.GAME);
            ViewManager.remove(ViewNames.GAME_OVER);
        }

    }

}
