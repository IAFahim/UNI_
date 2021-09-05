package gui.core.panel.upperPanel.clickAbleLabel;

import gui.util._Win;

import javax.swing.*;

public class DataLabel {
    public JLabel label;
    public DataLabel(boolean selected) {
        label=new JLabel();
        label.setLayout(null);
        label.setText("Data");
        label.setForeground(selected ? _Win.selected_color_for_label : _Win.unSelected_color_for_label);
        label.setToolTipText(label.getText() + " (Alt + " + 0 + ")");
    }
}