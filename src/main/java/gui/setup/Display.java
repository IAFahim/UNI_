package gui.setup;

import gui.core.label.clickAble.PlayGroundLabel;
import gui.core.label.clickAble.ShareLabel;
import gui.core.util.GData;
import gui.setup.util.GuiDataLoader;
import gui.setup.util._Win;
import gui.core.label.clickAble.DataLabel;
import gui.core.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display implements Runnable {
    private JFrame frame;

    private UpperPanel upperPanel;
    private SidePanel sidePanel;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private DescriptionPanel descriptionPanel;

    private DataLabel dataLabel;
    private PlayGroundLabel playGroundLabel;
    private ShareLabel shareLabel;

    public Display(GuiDataLoader win) {
        EventQueue.invokeLater(this);
    }

    @Override
    public void run() {
        inti();
        start();
    }

    public void inti() {
        frameSetup();

        upperPanel = new UpperPanel();
        sidePanel = new SidePanel();
        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();
        descriptionPanel=new DescriptionPanel();
        dataLabel=new DataLabel();
        playGroundLabel=new PlayGroundLabel();
        shareLabel=new ShareLabel();
    }

    public void start() {
        upperPanelDecoration();
        sidePanel.add(frame);
        leftPanel.add(frame);
        rightPanel.add(frame);
        descriptionPanel.add(frame);
        tooltipSetup();
        frame.setVisible(true);
    }

    public void upperPanelDecoration(){
        upperPanel.add(frame);
        dataLabel.add(upperPanel.panel);
        playGroundLabel.add(upperPanel.panel);
        shareLabel.add(upperPanel.panel);
    }

    private void frameSetup() {
        frame = new JFrame(_Win.getTitle());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(_Win.getWidth(), _Win.getHeight());
        if (_Win.isFullScreen()) { // if full screened
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        frame.getContentPane().setBackground(new Color(228, 228, 228));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
    }

    private void tooltipSetup(){
        UIManager.put("ToolTip.background", new Color(255,255,255));
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font("Segoe UI",Font.PLAIN, GData.scaleY(12)));
    }
}
