package gui.core.panel.leftPanel;

import gui.core.layout.VerticalFlowLayout;
import gui.core.panel.leftPanel.threePartPanel.IconTextFieldIconPanel;
import gui.core.panel.leftPanel.threePartPanel.IconTextFieldIconIconIconPanel;
import gui.core.panel.leftPanel.tools.WebScrapperLabel;
import gui.util._Win;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeftPanel {
    public JPanel panel;
    public JPanel panel_left;
    public JPanel panel_right;
    public JPanel panel_right_down;
    public WebScrapperLabel webScrapperLabel;
    public IconTextFieldIconPanel threePartPanel;

    public LeftPanel() {
        panel=new JPanel();
        panel.setLayout(new BorderLayout());
        setPanel_left();
        setPanel_right();
        panel.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        panel.setPreferredSize(new Dimension(310, 1035));
        panel.setMinimumSize(new Dimension(190, 300));
        panel.setBackground(_Win.light_mode_color_frame_backGround);
    }

    private void setPanel_left() {
        webScrapperLabel = new WebScrapperLabel();
        panel_left = new JPanel(new BorderLayout());
        panel_left.setBackground(_Win.light_mode_color_panel_backGround);
        panel_left.add(webScrapperLabel, BorderLayout.PAGE_START);
        panel_left.setPreferredSize(new Dimension(50, 1036));
        panel.add(panel_left, BorderLayout.WEST);
    }

    private void setPanel_right() {
        panel_right = new JPanel(new BorderLayout());
        panel_right.setBackground(_Win.light_mode_color_panel_backGround);
        panel_right.setPreferredSize(new Dimension(310, 1035));
        panel_left.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 2));
        setPanel_right_up();
        setPanel_right_down();
        panel.add(panel_right, BorderLayout.CENTER);
    }

    private void setPanel_right_up() {
        threePartPanel = new IconTextFieldIconPanel();
        panel_right.add(threePartPanel.panel, BorderLayout.PAGE_START);
    }
    public ArrayList<IconTextFieldIconIconIconPanel> button;
    private void setPanel_right_down() {
        VerticalFlowLayout verticalFlowLayout=new VerticalFlowLayout();
        verticalFlowLayout.setVgap(2);
        verticalFlowLayout.setHgap(0);
        panel_right_down = new JPanel(verticalFlowLayout);
        button=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            IconTextFieldIconIconIconPanel iconTextFieldIconIconIconPanel=new IconTextFieldIconIconIconPanel();
            button.add(iconTextFieldIconIconIconPanel);
            panel_right_down.add(iconTextFieldIconIconIconPanel.panel);
        }
        JScrollPane jScrollPane=new JScrollPane(panel_right_down);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel_right.add(jScrollPane,BorderLayout.WEST);
    }
}
