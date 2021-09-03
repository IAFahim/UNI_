package gui.core.label.clickAble;

import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class DataLabel extends JLabel {
    protected String shortcutText;
    protected Color color;
    protected Color unSelectedColor;
    public boolean selected;
    public int order;


    public DataLabel() {
        setLayout(null);
        setText("Data");
        order = 1;
        setPreferredSize(_Win.init(88, 24));
        setBackground(color = new Color(119, 199, 199));
        shortcutText = "Data (Alt + " + order + ")";
        setToolTipText(shortcutText);
        setForeground(selected ? color : unSelectedColor);
    }
}