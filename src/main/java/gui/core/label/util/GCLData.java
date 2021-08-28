package gui.core.label.util;

import javax.swing.*;
import java.awt.*;

public class GCLData extends GLData {
    protected String shortcutText;
    protected Color unSelectedColor;
    public boolean selected;
    public int order;

    public void add(JPanel jPanel) {
        label = new JLabel();
        unSelectedColor = new Color(119, 199, 199);
        shortcutText = "Data (Alt + " + order + ")";
        label.setToolTipText(shortcutText);
        label.setForeground(selected ? color : unSelectedColor);
        super.add(jPanel);
    }
}