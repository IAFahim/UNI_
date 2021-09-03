package gui.core.button;

import gui.util._Win;

import javax.swing.*;
import java.awt.*;

import static gui.util._Win.scaleY;

public class YesButton extends JButton {

    public YesButton(){
        setText("Yes");
        _Win.init(112,43);
        setBackground(new Color(42, 151, 238));
        setFont(new Font(_Win.getFont(),Font.BOLD,scaleY(24)));
        setForeground(Color.WHITE);
    }
}
