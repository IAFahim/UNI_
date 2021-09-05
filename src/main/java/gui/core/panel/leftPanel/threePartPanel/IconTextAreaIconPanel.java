package gui.core.panel.leftPanel.threePartPanel;

import gui.util._Win;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static gui.util._Win.*;

public class IconTextAreaIconPanel extends JPanel {
    public JTextField textField;
    public JLabel search;
    public JLabel close;
    public IconTextAreaIconPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(_Win.init(310,60));
        setBackground(light_mode_color_panel_backGround);
        Border margin = new EmptyBorder(_Win.scaleY(16), 0, _Win.scaleY(10), 0);
        setBorder(margin);
        setSearch();
        setTextField();
        setClose();
    }

    public void setSearch() {
        search = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_search_12.png");
        search.setIcon(ii);
        Border margin = new EmptyBorder(0, _Win.scaleX(10),0,_Win.scaleX(10));
        search.setBorder(margin);
        search.setToolTipText(search.getText() + " (Ctrl + F)");
        add(search,BorderLayout.WEST);
    }

    public String textFieldString;
    public void setTextField() {
        textFieldString ="All items";
        textField = new JTextField(textFieldString);
        textField.setPreferredSize(init(231,40));
        Border margin = new EmptyBorder(0, _Win.scaleX(10),0,0);
        textField.setBorder(margin);
        textField.setBorder(null);
        textField.setBackground(light_mode_color_panel_backGround);
        textField.setFont(new Font(_Win.getFont(), Font.PLAIN, scaleY(13)));
        add(textField,BorderLayout.CENTER);
    }

    public void setClose() {
        close = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_cancel_12.png");
        close.setIcon(ii);
        Border margin = new EmptyBorder(0, _Win.scaleX(10),0,_Win.scaleX(15));
        close.setBorder(margin);
        close.setToolTipText(close.getText() + " (Esc)");
        add(close,BorderLayout.EAST);
    }
}
