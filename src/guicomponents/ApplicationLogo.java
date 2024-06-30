package guicomponents;

import javax.swing.*;
import java.awt.*;

public class ApplicationLogo {

    public static HeaderLabel getApplicationNameLabel() {
        return new HeaderLabel("SNAKE");
    }

    public static Image getApplicationImage() {
        return new ImageIcon("appIcon.png").getImage();
    }

    public static ImageIcon getImageIcon(String filename) {
        ImageIcon originalIcon = new ImageIcon(filename);
        int newWidth = originalIcon.getIconWidth() / 5;
        int newHeight = originalIcon.getIconHeight() / 5;
        Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
