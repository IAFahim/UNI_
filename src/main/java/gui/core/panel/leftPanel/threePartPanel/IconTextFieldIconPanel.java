package gui.core.panel.leftPanel.threePartPanel;

import gui.Display;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static gui.util._Win.*;

public class IconTextFieldIconPanel implements DocumentListener {
    public JTextField textField;
    public JLabel search;
    public JLabel close;
    public JPanel panel;
    public IconTextFieldIconPanel() {
        panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(310,60));
        panel.setBackground(light_mode_color_panel_backGround);
        Border margin = new EmptyBorder((16), 0,(10), 0);
        panel.setBorder(margin);
        setSearch();
        setTextField();
        setClose();
    }

    public void setSearch() {
        search = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_search_12.png");
        search.setIcon(ii);
        Border margin = new EmptyBorder(0, (10),0,(10));
        search.setBorder(margin);
        search.setToolTipText(search.getText() + " (Ctrl + F)");
        panel.add(search,BorderLayout.WEST);
    }

    public String textFieldString;
    public void setTextField() {
        textFieldString ="All items";
        textField = new JTextField(textFieldString);
        textField.getDocument().addDocumentListener(this);
        textField.setPreferredSize(new Dimension(231,40));
        textField.setBorder(null);
        textField.setBackground(light_mode_color_panel_backGround);
        textField.setFont(smallFont);
        panel.add(textField,BorderLayout.CENTER);
    }

    public void setClose() {
        close = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_cancel_12.png");
        close.setIcon(ii);
        Border margin = new EmptyBorder(0, (10),0,(15));
        close.setBorder(margin);
        close.setToolTipText(close.getText() + " (Esc)");
        panel.add(close,BorderLayout.EAST);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        deleteButton();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        deleteButton();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        deleteButton();
    }
    void deleteButton(){
        textField.getText();
    }
}
