package gui.core.panel.rightPanel.textField;

import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public class AllItemsTextField extends JTextField {
    String text;
    public AllItemsTextField(){
        text="All items";
        setText("All items");
        setBorder(null);
        setPreferredSize(new Dimension(111,217));
    }
}
