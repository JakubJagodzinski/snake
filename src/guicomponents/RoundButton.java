package guicomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends JButton {

    private Color backgroundColor;
    private Color hoverBackgroundColor;
    private Color pressBackgroundColor;
    private Color foregroundColor;
    private boolean isHovered;
    private boolean isPressed;

    public RoundButton(String text) {
        initializeButton(text);
        setPreferredSize(new Dimension(240, 60));
        setMinimumSize(new Dimension(240, 60));
        setMaximumSize(new Dimension(240, 60));
    }

    private void initializeButton(String text) {
        super.setText(text);
        this.setEnabled(true);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        this.backgroundColor = Colors.BUTTON_COLOR;
        this.hoverBackgroundColor = Colors.BUTTON_HOVER_COLOR;
        this.pressBackgroundColor = Colors.BUTTON_PRESS_COLOR;
        this.foregroundColor = Colors.FOREGROUND_COLOR;
        this.isHovered = false;
        this.isPressed = false;

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundRectangle = new RoundRectangle2D.Float(0, 0, width, height, 20, 20);
        if (this.isPressed) {
            g2.setColor(this.pressBackgroundColor);
            g2.fill(roundRectangle);
        } else {
            g2.setColor(this.isHovered ? this.hoverBackgroundColor : this.backgroundColor);
            g2.fill(roundRectangle);
        }

        g2.setColor(this.foregroundColor);
        FontMetrics metrics = g2.getFontMetrics();
        int x = (width - metrics.stringWidth(getText())) / 2;
        int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.drawString(getText(), x, y);

        g2.dispose();
    }

}
