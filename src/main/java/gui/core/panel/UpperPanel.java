package gui.core.panel;

import gui.core.panel.util.GPData;

import javax.swing.*;
import java.awt.*;

public class UpperPanel extends GPData {
    public UpperPanel() {
        panel = new JPanel(null);
        init(0, 0, 1920, 43);
        color = new Color(255, 255, 255);
    }

    public void add(JFrame jFrame) {
        super.add(jFrame);
    }
}
