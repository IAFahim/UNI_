package gui.core.panel;

import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class UpperPanel extends JPanel {
    public UpperPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setPreferredSize(_Win.init(1920,43));
        setBackground(new Color(255, 255, 255));
    }
}
