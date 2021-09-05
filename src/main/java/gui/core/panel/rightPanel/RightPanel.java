package gui.core.panel.rightPanel;


import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class RightPanel {
    public JPanel panel;
    public RightPanel() {
        panel=new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 0));
        panel.setPreferredSize(new Dimension(271,1135));
        panel.setMinimumSize(new Dimension(200,300));
        panel.setBackground(_Win.light_mode_color_panel_backGround);
    }

}
