package gui.core.panel.leftPanel.tools;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class WebScrapperLabel extends JLabel {
    public WebScrapperLabel(){
        setIcon(new ImageIcon("src/main/resources/ic_WebScrapper.png"));
        setHorizontalAlignment(SwingConstants.CENTER);
        Border margin = new EmptyBorder(10,0,0,0);
        setBorder(margin);
        setToolTipText(getText() + " (Ctrl + " + 0 + ")");
    }
}
