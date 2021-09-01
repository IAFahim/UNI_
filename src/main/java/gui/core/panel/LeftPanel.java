package gui.core.panel;

import gui.core.panel.util.GPData;
import gui.core.util.GData;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends GPData {
    public LeftPanel() {
        panel = new JPanel(null);
        init(67, 91, 562, 990);
        color = new Color(255, 255, 255);
    }

    public void add(JFrame jFrame) {
        super.add(jFrame);
    }
}
