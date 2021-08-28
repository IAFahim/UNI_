package gui.core.panel;

import gui.core.panel.util.GPData;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends GPData {
    public SidePanel() {
        panel = new JPanel(null);
        init(0, 46, 50, 1036);
        color = new Color(255, 255, 255);
    }

    public void add(JFrame jFrame) {
        super.add(jFrame);
    }
}
