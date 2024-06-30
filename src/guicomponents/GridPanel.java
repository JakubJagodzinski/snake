package guicomponents;

import java.awt.*;

public class GridPanel extends ColorPanel {

    public GridPanel(int rows, int cols) {
        this.setLayout(new GridLayout(rows, cols));
    }

}
