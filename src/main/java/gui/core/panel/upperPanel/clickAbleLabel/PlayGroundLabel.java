package gui.core.panel.upperPanel.clickAbleLabel;

import gui.util._Win;

import javax.swing.*;

public class PlayGroundLabel extends JLabel {
    public PlayGroundLabel(boolean selected) {
        setLayout(null);
        setText("Play Ground");
        setForeground(selected ? _Win.selected_color_for_label : _Win.unSelected_color_for_label);
        setToolTipText(getText() + " (Alt + " + 1 + ")");
    }
}