package screens.game;

import guicomponents.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameView extends ColorPanel {

    private final RoundButton returnButton;
    private final GameBoard gameBoard;
    private final HeaderLabel pointsLabel;
    private final HeaderLabel pausedLabel;

    public GameView(GameBoard gameBoard) {
        super(new BorderLayout());

        ColorPanel leftPanel = new ColorPanel(new GridBagLayout());
        ColorPanel rightPanel = new ColorPanel(new GridBagLayout());
        ColorPanel middlePanel = new ColorPanel(new GridBagLayout());

        GridPanel centerPanel = new GridPanel(1, 3);
        centerPanel.add(leftPanel);
        centerPanel.add(middlePanel);
        centerPanel.add(rightPanel);

        GridBagConstraints middlePanelGbc = VerticalGridBagLayout.getGridBagConstraints();

        this.gameBoard = gameBoard;
        middlePanel.add(this.gameBoard, middlePanelGbc);
        middlePanelGbc.gridy++;

        GridBagConstraints leftPanelGbc = VerticalGridBagLayout.getGridBagConstraints();
        this.returnButton = new RoundButton(Icons.LEFTWARDS_ARROW + " Return");
        leftPanel.add(this.returnButton, leftPanelGbc);
        leftPanelGbc.gridy++;

        GridBagConstraints rightPanelGbc = VerticalGridBagLayout.getGridBagConstraints();

        this.pointsLabel = new HeaderLabel();
        rightPanel.add(this.pointsLabel, rightPanelGbc);
        rightPanelGbc.gridy++;

        this.pausedLabel = new HeaderLabel(" ");

        ColorPanel pausedLabelPanel = new ColorPanel();
        pausedLabelPanel.add(this.pausedLabel);
        rightPanel.add(pausedLabelPanel, rightPanelGbc);
        rightPanelGbc.gridy++;

        rightPanel.add(this.createHelpPanel(), rightPanelGbc);
        rightPanelGbc.gridy++;

        this.add(centerPanel, BorderLayout.CENTER);

        this.add(new Footer(), BorderLayout.SOUTH);
    }

    public ColorPanel createHelpPanel() {
        ColorPanel helpPanel = new ColorPanel(new GridBagLayout());
        GridBagConstraints gbc = VerticalGridBagLayout.getGridBagConstraints();
        helpPanel.add(new HeaderLabel("<html><b>Controls:</b></html>", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("KEY UP / W move up", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("KEY DOWN / S move down", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("KEY LEFT / A move left", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("KEY RIGHT / D move right", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("+ increase board size", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("- decrease board size", 20), gbc);
        gbc.gridy++;
        helpPanel.add(new HeaderLabel("SPACE - pause / resume game", 20), gbc);
        return helpPanel;
    }

    public void repaintSnakePanel() {
        this.gameBoard.revalidate();
        this.gameBoard.repaint();
    }

    public void updatePointsLabel(long points) {
        this.pointsLabel.setText("Score: " + points);
    }

    public void setPausedLabel(boolean paused) {
        if (paused) {
            this.pausedLabel.setText("Game paused");
        } else {
            this.pausedLabel.setText(" ");
        }
    }

    public void addReturnButtonListener(ActionListener e) {
        this.returnButton.addActionListener(e);
    }

}
