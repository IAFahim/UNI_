package gui.core.panel.upperPanel.clickAbleLabel;

import gui.util._Win;

import javax.swing.*;

public class ShareLabel extends JLabel {
    public ShareLabel(boolean selected) {
        setLayout(null);
        setText("Share");
        setForeground(selected ? _Win.selected_color_for_label : _Win.unSelected_color_for_label);
        setToolTipText(getText() + " (Alt + " + 2 + ")");
    }
}