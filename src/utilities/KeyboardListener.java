package utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private static int pressedKey;
    public static final int INPUT_DELAY = 30;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKey = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static int getPressedKey() {
        return pressedKey;
    }

    public static void clearPressedKey() {
        pressedKey = 0;
    }

}
