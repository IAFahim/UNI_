package gui.core.label.clickAble;

import gui.core.label.util.GCLData;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class PlayGroundLabel extends GCLData {
    public PlayGroundLabel() {
        label = new JLabel();
        text = "Play Ground";
        order = 2;
    }

    public void add(JPanel jPanel, MouseListener mouseListener) {
        selected = false;
        label.addMouseListener(mouseListener);
        super.add(jPanel,261, 8, 150, 24);
    }
}