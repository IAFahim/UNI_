package gui.core.panel;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    public SidePanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setBackground(new Color(255, 255, 255));
    }
}
