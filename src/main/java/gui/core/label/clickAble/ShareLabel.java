package gui.core.label.clickAble;

import gui.core.label.util.GCLData;

import javax.swing.*;
import java.awt.event.MouseListener;

public class ShareLabel extends GCLData {
    public ShareLabel() {
        label=new JLabel();
        text = "Share";
        order = 3;
    }

    public void add(JPanel jPanel, MouseListener mouseListener) {
        selected = false;
        label.addMouseListener(mouseListener);
        super.add(jPanel,413, 8, 88, 24);
    }
}