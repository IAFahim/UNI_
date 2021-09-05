package gui.core.panel;


import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    public CenterPanel() {
        setBackground(_Win.light_mode_color_frame_backGround);
        setPreferredSize(_Win.init(1240,1035));
    }

}
