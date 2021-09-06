package gui.core.panel.leftPanel.threePartPanel;

import gui.Display;
import gui.core.panel.leftPanel.tools.WebScrapperLabel;
import gui.util._Win;
import webScraper.WebScraper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static gui.util._Win.*;

public class IconTextFieldIconIconIconPanel implements MouseListener {
    public JTextField textField;
    public JLabel type;
    public JLabel hide;
    public JLabel export;
    public JLabel delete;
    public JLabel disable;
    public JPanel panel;
    public IconTextFieldIconIconIconPanel() {
        panel=new JPanel(new FlowLayout());
        FlowLayout flowLayout=new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);

        panel.setSize(new Dimension(310,38));
//        panel.setPreferredSize(_Win.init(300,38));
        panel.setBackground(light_mode_color_panel_backGround);
        setType();
        setTextField();
        selectForExport();
        setDelete();
        setDisable();
    }

    public void setType() {
        type = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_keyboard_16.png");
        type.setIcon(ii);
        Border margin = new EmptyBorder(0, 0,0, (5));
        type.setBorder(margin);
        type.setToolTipText( "Rename (F2)");
        panel.add(type);
    }

    public void setTextField() {
        textField = new JTextField("None");
        textField.setPreferredSize(new Dimension(125,40));
        textField.setBorder(null);
        textField.setBackground(light_mode_color_panel_backGround);
        textField.setFont(new Font(_Win.getFont(), Font.PLAIN, (14)));
        textField.setFocusable(false);
        panel.add(textField);

    }

    public void selectForExport() {
        export = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_export_16.png");
        export.setIcon(ii);
        Border margin = new EmptyBorder(0, (5),0,0);
        export.setBorder(margin);
        export.setToolTipText( "Export (Left-mouse-click)");
        panel.add(export);
    }

    public void setDelete() {
        delete = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_delete_16.png");
        delete.setIcon(ii);
        Border margin = new EmptyBorder(0, (5),0,0);
        delete.setBorder(margin);
        delete.setToolTipText("Delete (Del)");
        delete.addMouseListener(this);
        panel.add(delete,BorderLayout.EAST);
    }

    public void setDisable() {
        disable = new JLabel();
        ImageIcon ii= new ImageIcon("src/main/resources/ic_disable_16.png");
        disable.setIcon(ii);
        Border margin = new EmptyBorder(0, (5),0,(20));
        disable.setBorder(margin);
        disable.setToolTipText("Disable (Ctrl + D)");
        panel.add(disable,BorderLayout.EAST);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().getClass()==delete.getClass()){
            System.out.println("delete");
            panel.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
