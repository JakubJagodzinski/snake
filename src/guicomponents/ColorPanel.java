package guicomponents;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {

    public ColorPanel() {
        super();

        this.setBackground(Colors.BACKGROUND_COLOR);
        this.setForeground(Colors.FOREGROUND_COLOR);
    }

    public ColorPanel(LayoutManager layout) {
        super(layout);

        this.setBackground(Colors.BACKGROUND_COLOR);
        this.setForeground(Colors.FOREGROUND_COLOR);
    }

}
