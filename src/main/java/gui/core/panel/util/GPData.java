package gui.core.panel.util;

import gui.core.util.AddToFrame;
import gui.core.util.GData;

import javax.swing.*;

public class GPData extends GData implements AddToFrame {
    public JPanel panel;

    @Override
    public void add(JFrame jFrame) {
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        jFrame.add(panel);
    }
}
