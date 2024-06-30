package guicomponents;

import javax.swing.*;
import java.awt.*;

public class HeaderLabel extends JLabel {

    public HeaderLabel(String text) {
        super(text);

        this.setForeground(Colors.FOREGROUND_COLOR);
        this.setSize(500, 500);
        this.setFont(new Font("ARCADECLASSIC", Font.BOLD, 40));
    }

    public HeaderLabel() {
        super();

        this.setForeground(Colors.FOREGROUND_COLOR);
        this.setSize(500, 500);
        this.setFont(new Font("ARCADECLASSIC", Font.BOLD, 40));
    }

    public HeaderLabel(String text, int size) {
        super(text);

        this.setForeground(Colors.FOREGROUND_COLOR);
        this.setSize(500, 500);
        this.setFont(new Font("ARCADECLASSIC", Font.BOLD, size));
    }

}
