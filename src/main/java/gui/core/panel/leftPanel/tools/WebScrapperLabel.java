package gui.core.panel.leftPanel.tools;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;

public final class WebScrapperLabel {
    public JLabel label;
    public WebScrapperLabel(){
        label=new JLabel();
        label.setIcon(new ImageIcon("src/main/resources/ic_WebScrapper.png"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Border margin = new EmptyBorder(10,5,0,0);
        label.setBorder(margin);
        label.setToolTipText(label.getText() + " (Ctrl + " + 0 + ")");
    }
}
