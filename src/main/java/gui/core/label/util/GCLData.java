package gui.core.label.util;

import gui.core.util.AddToFrame;
import gui.core.util.AddToPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class GCLData extends GLData implements AddToPanel {
    protected String shortcutText;
    protected Color unSelectedColor;
    public boolean selected;
    public int order;

    @Override
    public void add(JPanel jPanel, double X, double Y, double Width, double Height) {
        init(X-jPanel.getX(),Y-jPanel.getY(),Width,Height);
        unSelectedColor = new Color(119, 199, 199);
        shortcutText = "Data (Alt + " + order + ")";
        label.setToolTipText(shortcutText);
        label.setForeground(selected ? color : unSelectedColor);
        super.add(jPanel);
    }
}