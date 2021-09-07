package gui.core.button;

import gui.core.effect.DropShadowBorder;
import gui.util._Win;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YesButton implements ActionListener {
    public JButton button;
    public YesButton(String str){
        button=new JButton(str);
        button.setPreferredSize( new Dimension(112,43));
        button.setMinimumSize( new Dimension(112,43));
        button.setBackground(new Color(42, 151, 238));
        button.setFont(_Win.mediumFont);
        button.setBorder(null);
        button.setForeground(Color.WHITE);
        button.setBorder(null);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("wow");
    }
}
