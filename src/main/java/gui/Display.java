package gui;

import gui.core.panel.LeftPanel;
import gui.core.panel.CenterPanel;
import gui.core.panel.RightPanel;
import gui.core.panel.UpperPanel;
import gui.util._Win;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Display extends JPanel implements Runnable, MouseListener, ActionListener {
    private JFrame frame;
    private UpperPanel upperPanel;
    private LeftPanel leftPanel;
    private CenterPanel centerPanel;
    private RightPanel rightPanel;

    public void setPanel() {
        setLayout(new BorderLayout());
//        JPanel left_panel = createVerticalBoxPanel();
//        JPanel right_Panel = createVerticalBoxPanel();
//        left_panel.setBackground(Color.black);
//        left_panel.setPreferredSize(new Dimension(720,720));
//        right_Panel.setPreferredSize(new Dimension(720,720));
//        add(left_panel,BorderLayout.WEST);
//        add(right_Panel,BorderLayout.EAST);
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_panel, right_Panel);
//        splitPane.setOneTouchExpandable(true);
//        add(splitPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void setLeft() {
        leftPanel = new LeftPanel();
        leftPanel.setBackground(Color.PINK);
        add(leftPanel, BorderLayout.WEST);
    }

    private void setRight() {
        rightPanel = new RightPanel();
        rightPanel.setBackground(Color.black);
        add(rightPanel, BorderLayout.EAST);
    }

    private void setCenter() {
        centerPanel=new CenterPanel();
        add(centerPanel,BorderLayout.CENTER);
    }

    private void setTop() {
        upperPanel = new UpperPanel();
        add(upperPanel,BorderLayout.PAGE_START);
        JCheckBox toggleDnD = new JCheckBox("Turn on Drag and Drop");
        add(toggleDnD, BorderLayout.PAGE_END);
    }

    protected JPanel createVerticalBoxPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        return p;
    }

    private void displayDropLocation(final String string) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, string);
            }
        });
    }

    public Display() {
        EventQueue.invokeLater(this);
    }

    public void run() {
        setFrame();
        setPanel();
        setTop();
        setLeft();
        setCenter();
        setRight();
        start();
    }


    public void setFrame() {
        frame = new JFrame(_Win.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        this.setOpaque(true);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

    public void actionPerformed(ActionEvent e) {

    }
}
