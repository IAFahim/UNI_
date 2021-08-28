package gui.core.label.clickAble;

import gui.core.label.util.GCLData;

import javax.swing.*;

public class ShareLabel extends GCLData {
    public ShareLabel() {
        text = "Share";
        order = 3;
        init(413, 8, 88, 24);
    }

    public void add(JPanel jPanel) {
        selected = false;
        super.add(jPanel);
    }
}