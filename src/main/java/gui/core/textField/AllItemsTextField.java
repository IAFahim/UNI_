package gui.core.textField;

import gui.core.textField.util.GTData;

import javax.swing.*;
import java.awt.event.MouseListener;

public class AllItemsTextField extends GTData {
    public AllItemsTextField(){
        textField=new JTextField();
        text="All items";
    }

    public void add(JPanel jPanel, MouseListener mouseListener) {
        textField.addMouseListener(mouseListener);
        textField.setBorder(null);
        textField.setFocusable(false);
        super.add(jPanel,150.5,111.5, 217,24);
    }
}
