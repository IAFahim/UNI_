package gui.core.panel.rightPanel.textField;

import gui.util._Win;

import javax.swing.*;

public class AllItemsTextField extends JTextField {
    String text;
    public AllItemsTextField(){
        text="All items";
        setText("All items");
        setBorder(null);
        setPreferredSize(_Win.init(111.5,217.24));
    }
}
