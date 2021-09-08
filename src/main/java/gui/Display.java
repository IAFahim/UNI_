package gui;

import gui.core.panel.leftPanel.LeftPanel;
import gui.core.panel.CenterPanel;
import gui.core.panel.upperPanel.UpperPanel;
import gui.util._Win;

import javax.swing.*;
import java.awt.*;

public final class Display implements Runnable {
    public static JFrame frame;
    public static UpperPanel upperPanel;
    public static LeftPanel leftPanel;
    public static CenterPanel centerPanel;
    public static JPanel panel = new JPanel();

    public void setPanel() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.black);
        panel.setMinimumSize(panel.getMinimumSize());

        panel.setFocusable(true);
    }

    private void setLeft() {
        leftPanel = new LeftPanel();
        panel.add(leftPanel.panel, BorderLayout.WEST);
    }


    private void setCenter() {
        centerPanel = new CenterPanel();
        panel.add(centerPanel.panel, BorderLayout.EAST);
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

    public void setSplit(){
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                leftPanel.panel, centerPanel.panel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setBorder(null);
        panel.add(splitPane, BorderLayout.CENTER);
    }

    public void run() {
        setFrame();
        setPanel();
        tooltipSetup();
        setTop();
        setLeft();
        setCenter();
        setSplit();
        start();
    }

    private void tooltipSetup() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIManager.put("ToolTip.background", Color.white);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font(_Win.getFont(), Font.PLAIN, 12));
    }


    public void setFrame() {
        frame = new JFrame(_Win.getTitle());
        frame.setMinimumSize(_Win.getMinimumSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void start() {
        panel.setOpaque(true);
        frame.setContentPane(panel);
        if (_Win.isIsFullScreen()) {
            frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        } else {
            frame.setSize(new Dimension(_Win.getWidth(), _Win.getHeight()));
            frame.setPreferredSize(new Dimension(1280, 720));
            frame.setLocation(_Win.getX(), _Win.getY());

        }
        frame.setVisible(true);
        _Win.checkToSave(frame);
    }

}
