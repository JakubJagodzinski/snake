import guicomponents.ApplicationLogo;
import guicomponents.ColorPanel;
import screens.start.StartController;
import screens.start.StartView;
import utilities.KeyboardListener;
import viewmanager.ViewManager;
import viewmanager.ViewNames;

import javax.swing.*;
import java.awt.*;

public class ApplicationMainController extends JFrame {

    public ApplicationMainController() {
        super("Snake");

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.setLayout(cardLayout);
        this.getContentPane().add(cardPanel, BorderLayout.CENTER);

        ViewManager.initialize(cardLayout, cardPanel);
        ViewManager.add(new ColorPanel(), ViewNames.LOADING);
        ViewManager.show(ViewNames.LOADING);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        this.setIconImage(ApplicationLogo.getApplicationImage());

        this.addKeyListener(new KeyboardListener());
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.setVisible(true);
    }

    public void run() {
        SwingUtilities.invokeLater(() -> {
            StartView startView = new StartView();
            StartController startController = new StartController(startView);
            ViewManager.add(startView, ViewNames.START);
            ViewManager.show(ViewNames.START);
        });
    }

}
