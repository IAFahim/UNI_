package gui.core.panel.upperPanel;

import gui.core.panel.upperPanel.clickAbleLabel.DataLabel;
import gui.core.panel.upperPanel.clickAbleLabel.LoginLabel;
import gui.core.panel.upperPanel.clickAbleLabel.PlayGroundLabel;
import gui.core.panel.upperPanel.clickAbleLabel.ShareLabel;
import gui.util._Win;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpperPanel implements MouseListener {
    public JPanel panel;
    public JPanel panel_right;
    public JPanel panel_left;
    public DataLabel dataLabel;
    public PlayGroundLabel playGroundLabel;
    public ShareLabel shareLabel;

    public LoginLabel loginLabel;

    public UpperPanel() {
        panel=new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(1920, 43));
        panel.setBackground(_Win.light_mode_color_panel_backGround);

        panel_right=new JPanel();
        panel_left = new JPanel();

        loginLabel=new LoginLabel(false);
        inti(loginLabel.label);
        panel_right.add(loginLabel.label);

        dataLabel = new DataLabel(true);
        playGroundLabel = new PlayGroundLabel(false);
        shareLabel = new ShareLabel(false);
        panel_left.setBackground(_Win.light_mode_color_panel_backGround);
        addToPanel(dataLabel.label, playGroundLabel.label, shareLabel.label);
        panel.add(panel_left, BorderLayout.WEST);
        panel.add(panel_right,BorderLayout.EAST);
    }

    private void addToPanel(JLabel... jLabels) {
        for (int i = 0; i < jLabels.length; i++) {
            inti(jLabels[i]);
            panel_left.add(jLabels[i]);
        }
    }

    public void inti(JLabel jLabel) {
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setPreferredSize(new Dimension(100, 30));
        jLabel.setFont(new Font(_Win.getFont(), Font.PLAIN, (18)));
        jLabel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().getClass()==dataLabel.label.getClass()){
            dataLabel.label.setForeground(_Win.selected_color_for_label);
        }else{
            dataLabel.label.setForeground(_Win.unSelected_color_for_label);
        }

        if(e.getSource().getClass()==playGroundLabel.getClass()){
            playGroundLabel.label.setForeground(_Win.selected_color_for_label);
        }else{
            playGroundLabel.label.setForeground(_Win.unSelected_color_for_label);
        }

        if(e.getSource().getClass()==shareLabel.getClass()){
            shareLabel.label.setForeground(_Win.selected_color_for_label);

        }else {
            shareLabel.label.setForeground(_Win.unSelected_color_for_label);

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
