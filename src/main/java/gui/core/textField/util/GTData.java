package gui.core.textField.util;

import gui.core.util.AddToPanel;
import gui.core.util.GData;
import gui.setup.util._Win;

import javax.swing.*;
import java.awt.*;

public class GTData extends GData implements AddToPanel {

    public JTextField textField;
    public String text;
    protected Font font;

    @Override
    public void add(JPanel jPanel, double X, double Y, double Width, double Height) {
        init(X-jPanel.getX(),Y-jPanel.getY(),Width,Height);
        font = new Font(_Win.getFont(), Font.PLAIN, scaleY(16));
        textField.setFont(font);
        textField.setText(text);
        textField.setBounds(x, y, width, height);
        jPanel.add(textField);
    }
}
