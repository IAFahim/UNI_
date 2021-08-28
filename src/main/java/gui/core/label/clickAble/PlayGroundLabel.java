package gui.core.label.clickAble;

import gui.core.label.util.GCLData;

import javax.swing.*;

public class PlayGroundLabel extends GCLData {
    public PlayGroundLabel() {
        text = "Play Ground";
        order = 2;
        init(261, 8, 150, 24);
    }

    public void add(JPanel jPanel) {
        selected = false;
        super.add(jPanel);
    }
}