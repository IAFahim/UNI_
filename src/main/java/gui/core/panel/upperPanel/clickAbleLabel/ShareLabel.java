package gui.core.panel.upperPanel.clickAbleLabel;

import gui.util._Win;

import javax.swing.*;

public class ShareLabel {
    public JLabel label;
    public ShareLabel(boolean selected) {
        label=new JLabel("Share");
        label.setLayout(null);
        label.setForeground(selected ? _Win.selected_color_for_label : _Win.unSelected_color_for_label);
        label.setToolTipText(label.getText() + " (Alt + " + 2 + ")");
    }
}