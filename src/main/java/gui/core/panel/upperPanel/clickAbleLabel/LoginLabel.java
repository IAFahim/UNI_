package gui.core.panel.upperPanel.clickAbleLabel;

import gui.util._Win;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginLabel {

    public JLabel label;
    public LoginLabel(boolean isLoggedIn){
        label=new JLabel("Login", SwingConstants.CENTER);
        label.setLayout(null);
        label.setText("Login");
        label.setForeground(isLoggedIn ? _Win.selected_color_for_label : _Win.unSelected_color_for_label);
        label.setToolTipText(label.getText() + " (Alt + " + 5 + ")");
    }
}
