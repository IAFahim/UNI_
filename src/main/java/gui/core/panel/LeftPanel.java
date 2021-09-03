package gui.core.panel;

import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setPreferredSize(_Win.init(454,1036));
        setBackground(new Color(255, 255, 255));
    }
}
