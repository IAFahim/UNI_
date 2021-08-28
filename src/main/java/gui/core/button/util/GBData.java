package gui.core.button.util;

import gui.core.util.AddToFrame;
import gui.core.util.GData;

import javax.swing.*;
import java.awt.*;

public class GBData extends GData implements AddToFrame {
    protected JButton button;
    protected String text;
    protected Font font;
    protected Color fontColor;

    @Override
    public void add(JFrame jFrame){
        button=new JButton();
        button.setFont(font);
        button.setText(text);

        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.setBackground(color);
        button.setForeground(fontColor);
        button.setBounds(x,y,width,height);
        jFrame.add(button);
    }

}
