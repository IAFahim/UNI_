package gui.core.panel;

import gui.core.panel.util.GPData;
import gui.core.util.GData;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends GPData {
    public RightPanel() {
        panel = new JPanel(null);
        init(636, 48, 1280, 720);
        color = new Color(255, 255, 255);
    }

    public void add(JFrame jFrame) {
        super.add(jFrame);
    }
}
