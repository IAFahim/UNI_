package gui.core.panel;

import gui.core.panel.util.GPData;

import javax.swing.*;
import java.awt.*;

public class DescriptionPanel extends GPData {
    public DescriptionPanel() {
        panel = new JPanel(null);
        init(636, 772, 1280, 310);
        color = new Color(255, 255, 255);
    }

    public void add(JFrame jFrame) {
        super.add(jFrame);
    }
}
