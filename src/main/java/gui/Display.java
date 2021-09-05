package gui;

import gui.core.panel.leftPanel.LeftPanel;
import gui.core.panel.CenterPanel;
import gui.core.panel.rightPanel.RightPanel;
import gui.core.panel.upperPanel.UpperPanel;
import gui.util._Win;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Display implements Runnable {
    public static JFrame frame;
    public static UpperPanel upperPanel;
    public static LeftPanel leftPanel;
    public static CenterPanel centerPanel;
    public static RightPanel rightPanel;
    public static JPanel panel=new JPanel();

    public void setPanel() {
        panel=new JPanel(new BorderLayout());
        panel.setBackground(Color.black);
        panel.setMinimumSize(panel.getMinimumSize());

        panel.setFocusable(true);
    }

    private void setLeft() {
        leftPanel=new LeftPanel();
        panel.add(leftPanel.panel, BorderLayout.WEST);
    }

    private void setRight() {
        rightPanel = new RightPanel();
        panel.add(rightPanel, BorderLayout.EAST);
    }

    private void setCenter() {
        centerPanel = new CenterPanel();
        panel.add(centerPanel, BorderLayout.CENTER);
    }

    private void setTop() {
        upperPanel = new UpperPanel();
        panel.add(upperPanel.panel, BorderLayout.PAGE_START);
    }

    private void setBottom() {
        JCheckBox toggleDnD = new JCheckBox("Turn on Drag and Drop");
        panel.add(toggleDnD, BorderLayout.PAGE_END);
    }


    public Display() {
        EventQueue.invokeLater(this);
    }

    public void run() {
        setFrame();
        setPanel();
        tooltipSetup();
        setTop();
        setLeft();
        setCenter();
        setRight();
        start();
    }

    private void tooltipSetup() {
        UIManager.put("ToolTip.background", Color.white);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font(_Win.getFont(), Font.PLAIN, _Win.scaleY(12)));
    }


    public void setFrame() {
        frame = new JFrame(_Win.getTitle());
        frame.setMinimumSize(_Win.getMinimumSize());
        frame.setPreferredSize(_Win.init(800,800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
