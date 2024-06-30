package screens.gameover;

import guicomponents.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverView extends ColorPanel {

    private final RoundButton tryAgainButton;
    private final RoundButton returnButton;

    public GameOverView(long score) {
        super(new BorderLayout());

        ColorPanel centerPanel = new ColorPanel(new GridBagLayout());
        GridBagConstraints gbc = VerticalGridBagLayout.getGridBagConstraints();

        centerPanel.add(new HeaderLabel("Game over!"), gbc);
        gbc.gridy++;

        centerPanel.add(new HeaderLabel("Your score: " + score), gbc);
        gbc.gridy++;

        this.tryAgainButton = new RoundButton("Try again " + Icons.RELOAD_ICON);
        centerPanel.add(this.tryAgainButton, gbc);
        gbc.gridy++;

        this.returnButton = new RoundButton(Icons.LEFTWARDS_ARROW + " Return");
        centerPanel.add(this.returnButton, gbc);
        gbc.gridy++;

        this.add(centerPanel, BorderLayout.CENTER);

        this.add(new Footer(), BorderLayout.SOUTH);
    }

    public void addTryAgainButtonListener(ActionListener e) {
        this.tryAgainButton.addActionListener(e);
    }

    public void addReturnButtonListener(ActionListener e) {
        this.returnButton.addActionListener(e);
    }

}
