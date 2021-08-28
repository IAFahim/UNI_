package gui.core.label.util;

import gui.core.util.GData;
import gui.main.util._Win;

import javax.swing.*;
import java.awt.*;

public class GLData extends GData {
    protected JLabel label;
    protected String text;
    protected Font font;

    public void add(JPanel jPanel) {
        color = new Color(0, 0, 0);
        font = new Font(_Win.getFont(), Font.PLAIN, scaleY(18));
        label.setFont(font);
        label.setText(text);
        label.setBounds(x, y, width, height);
        jPanel.add(label);

    }
}