package gui.core.label.clickAble;

import gui.core.label.util.GCLData;

import javax.swing.*;

public class DataLabel extends GCLData {
    public DataLabel() {
        text = "Data";
        order = 1;
        init(171, 8, 88, 24);

    }

    public void add(JPanel jPanel) {
        selected = true;
        super.add(jPanel);
    }
}