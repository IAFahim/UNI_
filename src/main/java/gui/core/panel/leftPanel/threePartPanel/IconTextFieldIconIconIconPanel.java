package gui.core.panel.leftPanel.threePartPanel;

import gui.Display;
import gui.core.effect.RoundedBorder;
import gui.util._Win;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
    public JPanel threeButtonPanel;

    public IconTextFieldIconIconIconPanel(String type, String text) {
        BorderLayout borderLayout = new BorderLayout();
        panel = new JPanel(borderLayout);

//        panel.setSize(new Dimension(310, 38));
        panel.setPreferredSize(new Dimension(452, 38));
        panel.setBackground(light_mode_color_panel_backGround);
        panel.addMouseListener(this);
        setType(type);
        setTextField(text);
        setThreeButtonPanel();
    }

    public void setThreeButtonPanel() {
        FlowLayout flowLayout = new FlowLayout();
        threeButtonPanel = new JPanel(flowLayout);

        selectForExport(threeButtonPanel);
        setDelete(threeButtonPanel);
        setDisable(threeButtonPanel);
        panel.add(threeButtonPanel, BorderLayout.EAST);
    }

    public void setType(String WhatType) {
        type = new JLabel();
        String foundTyp = switch (WhatType) {
            case "Keyboard" -> "ic_keyboard_16.png";
            case "Link" -> "ic_link_16.png";
            case "Text" -> "ic_text_16.png";
            case "All_link" -> "ic_all_link_16.png";
            case "Email" -> "ic_email_16.png";
            default -> "ic_unknown_16.png";
        };
        ImageIcon ii = new ImageIcon("src/main/resources/" + foundTyp);
        type.setIcon(ii);
        Border margin = new EmptyBorder(0, 0, 0, (5));
        type.setBorder(margin);
        type.setToolTipText("Rename (Right-mouse-click)");
        panel.add(type,BorderLayout.WEST);
    }

    public void setTextField(String text) {
        textField = new JTextField(text);
        textField.setPreferredSize(new Dimension(125, 40));
        textField.setBorder(null);
        textField.setBackground(light_mode_color_panel_backGround);
        textField.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
        textField.addMouseListener(this);
//        textField.setFocusable(false);
        panel.add(textField,BorderLayout.CENTER);
    }


    public void selectForExport(JPanel threeButtonPanel) {
        export = new JLabel();
        ImageIcon ii = new ImageIcon("src/main/resources/ic_export_16.png");
        export.setIcon(ii);
        Border margin = new EmptyBorder(0, (5), 0, 0);
        export.setBorder(margin);
        export.setToolTipText("Export (Left-mouse-click)");
        threeButtonPanel.add(export);
    }

    public void setDelete(JPanel threeButtonPanel) {
        delete = new JLabel();
        ImageIcon ii = new ImageIcon("src/main/resources/ic_delete_16.png");
        delete.setIcon(ii);
        Border margin = new EmptyBorder(0, (5), 0, 0);
        delete.setBorder(margin);
        delete.setToolTipText("Delete (Del)");
        delete.addMouseListener(this);
        threeButtonPanel.add(delete, BorderLayout.EAST);
    }

    public void setDisable(JPanel threeButtonPanel) {
        disable = new JLabel();
        ImageIcon ii = new ImageIcon("src/main/resources/ic_disable_16.png");
        disable.setIcon(ii);
        Border margin = new EmptyBorder(0, (5), 0, (20));
        disable.setBorder(margin);
        disable.setToolTipText("Disable (Ctrl + D)");
        threeButtonPanel.add(disable, BorderLayout.EAST);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().getClass() == delete.getClass()) {
            System.out.println("delete");
            Display.leftPanel.verticalFlowLayout.removeLayoutComponent(panel);
            panel.setVisible(false);
        }
    }

    public boolean selected = false;

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == textField && e.getButton() == MouseEvent.BUTTON1) {
            textField.selectAll();
        }
        if (e.getSource() == panel) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                textField.selectAll();
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                selected = !selected;
                if (selected) {
                    panel.setBackground(selected_color_for_button);
                    textField.setBackground(selected_color_for_button);
                } else {
                    panel.setBackground(light_mode_color_panel_backGround);
                    textField.setBackground(light_mode_color_panel_backGround);
                }
            }
        }
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
