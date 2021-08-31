package gui.core.label.clickAble;

import gui.core.label.util.GCLData;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class DataLabel extends GCLData {
    public DataLabel() {
        label = new JLabel();
        text = "Data";
        order = 1;
    }

    public void add(JPanel jPanel, MouseListener mouseListener) {
        selected = true;
        label.addMouseListener(mouseListener);
        super.add(jPanel,171, 8, 88, 24);
    }
}