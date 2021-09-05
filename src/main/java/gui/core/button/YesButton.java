package gui.core.button;

import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class YesButton{
    public JButton button;
    public YesButton(){
        button=new JButton("Yes");
        button.setPreferredSize( new Dimension(112,43));
        button.setBackground(new Color(42, 151, 238));
        button.setFont(_Win.mediumFont);
        button.setForeground(Color.WHITE);
    }
}
