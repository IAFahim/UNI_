package gui.setup;

import actions.AllItems;
import gui.core.label.clickAble.PlayGroundLabel;
import gui.core.label.clickAble.ShareLabel;
import gui.core.layout.VerticalFlowLayout;
import gui.core.textField.AllItemsTextField;
import gui.core.util.GData;
import gui.setup.util.GuiDataLoader;
import gui.setup.util._Win;
import gui.core.label.clickAble.DataLabel;
import gui.core.panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Display implements Runnable, MouseListener {
    private JFrame frame;

    private UpperPanel upperPanel;
    private SidePanel sidePanel;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private DescriptionPanel descriptionPanel;

    private DataLabel dataLabel;
    private PlayGroundLabel playGroundLabel;
    private ShareLabel shareLabel;

    private AllItemsTextField allItemsTextField;

    public Display(GuiDataLoader win) {
        EventQueue.invokeLater(this);
    }

    @Override
    public void run() {
        inti();
        start();
        System.out.println(frame.getSize());
        System.out.println(_Win.getWidth());
        System.out.println(_Win.getHeight());
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

        allItemsTextField=new AllItemsTextField();

    }

    public void start() {
        upperPanelDecoration();
        leftPanelDecoration();
        sidePanel.add(frame);
        rightPanel.add(frame);
        descriptionPanel.add(frame);
        tooltipSetup();

        frame.setVisible(true);
    }

    public void upperPanelDecoration(){
        upperPanel.add(frame);
        dataLabel.add(upperPanel.panel,this);
        playGroundLabel.add(upperPanel.panel,this);
        shareLabel.add(upperPanel.panel,this);
    }

    public void leftPanelDecoration(){
        leftPanel.panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        leftPanel.add(frame);
        allItemsTextField.add(leftPanel.panel,this);
        for (int i = 0; i < 20; i++) {
            JButton jButton=new JButton("wow"+i);
            jButton.addMouseListener(this);
            jButton.setPreferredSize(new Dimension(leftPanel.panel.getWidth()-5, 40));
            leftPanel.panel.add(jButton);
        }
//        VerticalFlowLayout verticalFlowLayout=new VerticalFlowLayout();
//        verticalFlowLayout.setVgap(0);
//        verticalFlowLayout.setHgap(0);
//        leftPanel.panel.setLayout(verticalFlowLayout);
//        JScrollPane jScrollPane=new JScrollPane(leftPanel.panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        jScrollPane.setBounds(leftPanel.panel.getX(),leftPanel.panel.getX(),leftPanel.panel.getWidth(),leftPanel.panel.getHeight());
//        frame.add(jScrollPane);
        allItemsTextField.textField.setFocusable(true);
    }

    private void frameSetup() {
        frame = new JFrame(_Win.getTitle());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(_Win.getWidth(), _Win.getHeight());
        if (_Win.isIsFullScreen()) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        frame.getContentPane().setBackground(new Color(228, 228, 228));
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setLayout(null);
    }

    private void tooltipSetup(){
        UIManager.put("ToolTip.background", new Color(255,255,255));
        UIManager.put("ToolTip.foreground", Color.BLACK);
        UIManager.put("ToolTip.font", new Font(_Win.getFont(),Font.PLAIN, GData.scaleY(12)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==allItemsTextField.textField){
            allItemsTextField.textField.setText("");
        }else {
            System.out.println(e.getSource());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==allItemsTextField.textField){
            allItemsTextField.textField.setFocusable(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
