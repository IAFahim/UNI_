package gui.core.panel.rightPanel;


import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    public RightPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(2, 4, 0, 0));
        setPreferredSize(_Win.init(306,1135));
        setMinimumSize(_Win.init(200,300));
        setBackground(_Win.light_mode_color_panel_backGround);
    }

}
