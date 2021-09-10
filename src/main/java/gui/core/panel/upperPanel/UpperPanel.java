package gui.core.panel.upperPanel;

import gui.Display;
import gui.core.panel.upperPanel.clickAbleLabel.DataLabel;
import gui.core.panel.upperPanel.clickAbleLabel.LoginLabel;
import gui.core.panel.upperPanel.clickAbleLabel.PlayGroundLabel;
import gui.core.panel.upperPanel.clickAbleLabel.ShareLabel;
import gui.util._Win;
import network.mail.ServerMailHandler;
import qrCode.QRCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutionException;

public class UpperPanel implements MouseListener {
    public JPanel panel;
    public JPanel panel_right;
    public JPanel panel_left;
    public DataLabel dataLabel;
    public PlayGroundLabel playGroundLabel;
    public ShareLabel shareLabel;

    public LoginLabel loginLabel;

    public UpperPanel() {
        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(1920, 43));
        panel.setBackground(_Win.light_mode_color_panel_backGround);

        panel_right = new JPanel();
        panel_left = new JPanel();

        loginLabel = new LoginLabel(false);
        loginLabel.label.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.label.setPreferredSize(new Dimension(100, 30));
        loginLabel.label.setFont(new Font(_Win.getFont(), Font.PLAIN, (18)));
        loginLabel.label.addMouseListener(this);

        panel_right.add(loginLabel.label);

        dataLabel = new DataLabel(true);
        playGroundLabel = new PlayGroundLabel(false);
        shareLabel = new ShareLabel(false);
        panel_left.setBackground(_Win.light_mode_color_panel_backGround);
        panel_left.add(dataLabel.label);
        dataLabel.label.setHorizontalAlignment(SwingConstants.CENTER);
        dataLabel.label.setPreferredSize(new Dimension(100, 30));
        dataLabel.label.setFont(new Font(_Win.getFont(), Font.PLAIN, (18)));
        dataLabel.label.addMouseListener(this);


        panel_left.add(playGroundLabel.label);
        playGroundLabel.label.setHorizontalAlignment(SwingConstants.CENTER);
        playGroundLabel.label.setPreferredSize(new Dimension(100, 30));
        playGroundLabel.label.setFont(new Font(_Win.getFont(), Font.PLAIN, (18)));
        playGroundLabel.label.addMouseListener(this);

        panel_left.add(shareLabel.label);
        shareLabel.label.setHorizontalAlignment(SwingConstants.CENTER);
        shareLabel.label.setPreferredSize(new Dimension(100, 30));
        shareLabel.label.setFont(new Font(_Win.getFont(), Font.PLAIN, (18)));
        shareLabel.label.addMouseListener(this);

        panel.add(panel_left, BorderLayout.WEST);
        panel.add(panel_right, BorderLayout.EAST);

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == dataLabel.label) {
            dataLabel.label.setForeground(_Win.selected_color_for_label);
            playGroundLabel.label.setForeground(_Win.unSelected_color_for_label);
            shareLabel.label.setForeground(_Win.unSelected_color_for_label);
        }

        if (e.getSource() == playGroundLabel.label) {
            playGroundLabel.label.setForeground(_Win.selected_color_for_label);
            dataLabel.label.setForeground(_Win.unSelected_color_for_label);
            shareLabel.label.setForeground(_Win.unSelected_color_for_label);
        }

        if (e.getSource() == shareLabel.label) {
            shareLabel.label.setForeground(_Win.selected_color_for_label);
            dataLabel.label.setForeground(_Win.unSelected_color_for_label);
            playGroundLabel.label.setForeground(_Win.unSelected_color_for_label);
        }

        if (e.getSource() == loginLabel.label) {
            jOptionPane = new JOptionPane();
            jOptionPane.setPreferredSize(new Dimension(300, 300));
            String str = jOptionPane.showInputDialog(Display.frame, "Enter your Email","Email");
            boolean valid = str != null && str.length() > 4 && str.contains("@");
            if (valid) {
                SwingWorker<Boolean, Void> swingWorker = new SwingWorker<>() {
                    @Override
                    protected Boolean doInBackground() throws Exception {
                        System.out.println(str);
                        ServerMailHandler serverMailHandler = new ServerMailHandler();
                        String password = QRCode.makePassword(8, true, true, true);
                        String path = "src/main/resources/" + _Win.getTitle()+".png";
                        QRCode.createQR(password, 200, 200, path);
                        ServerMailHandler.setAndSend(str, "UNI_ Your Encryption code: ","Here is your Encryption code:"+ password, path);
                        return true;
                    }

                    @Override
                    protected void done() {
                        try {
                            boolean get = get();
                            JOptionPane.showMessageDialog(Display.frame, "Your Encryption id is sent: Check your mail");
                            System.out.println("https://mail.google.com/mail/u/1/#inbox");
                        } catch (InterruptedException | ExecutionException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(Display.frame, "Invalid Mail", "Try Again please", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                };
                swingWorker.execute();
            }
        }
    }

    public JOptionPane jOptionPane;

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
