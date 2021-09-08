package gui.core.panel;


import gui.Display;
import gui.core.button.YesButton;
import gui.core.effect.DropShadowBorder;
import gui.core.panel.leftPanel.threePartPanel.IconTextFieldIconIconIconPanel;
import gui.util._Win;
import webScraper.WebScraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class CenterPanel implements MouseListener, ActionListener {
    public JTextField textField;
    public JPanel panel;
    public String textFieldString;
    public YesButton yesButton;

    public CenterPanel() {
        panel = new MainPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(new Dimension(1272, 1035));
        panel.setBackground(_Win.light_mode_color_frame_backGround);

        textFieldString = "https://";
        textField = new JTextField();
        textField = new JTextField(textFieldString);
        textField.setForeground(Color.GRAY);
        textField.addMouseListener(this);
        textField.addActionListener(this);
        textField.setPreferredSize(new Dimension(720, 45));
//        textField.setBorder(new EmptyBorder(5, 5, 5, 5));
        textField.setBorder(new DropShadowBorder());
        textField.setBackground(Color.WHITE);
        textField.setFont(_Win.largeFont);


        textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);

        panel.add(textField, BorderLayout.PAGE_START);
    }

    public JTextArea textArea;

    Map<String, HashSet<String>> map;

    public void updateText() {
        SwingWorker swingWorker = new SwingWorker<Boolean, String>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                String url = textField.getText();
                Map<String, LinkedHashSet<String>> map =WebScraper.run(url);
                boolean any = false;
                if(WebScraper.getDocument()!=null){
                    String str=(WebScraper.getAllText(WebScraper.getDocument()));
                    if(str.length()>0){
                        IconTextFieldIconIconIconPanel button = new IconTextFieldIconIconIconPanel("Text",str);
                        Display.leftPanel.panel_right_down.add(button.panel);
                    }
                }
                for (String s : map.keySet()) {
                    for (String x : map.get(s)) {
                        System.out.println(s+" "+x);
                        IconTextFieldIconIconIconPanel button = new IconTextFieldIconIconIconPanel(s,x);
                        Display.leftPanel.panel_right_down.add(button.panel);
                    }
                    any = true;
                }
                if (any) {
                    Display.leftPanel.panel_right_down.revalidate();
                    Display.leftPanel.jScrollPane.revalidate();
                }
                return true;
            }

            @Override
            protected void done() {
                try {
                    boolean status = get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

                textField.setText("");
            }
        };
        try {
            if (textField.getText().length() > 9) {
                URL url = new URL(textField.getText());
                swingWorker.execute();
            }
        } catch (MalformedURLException ignored) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == textField) {
            textField.selectAll();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == textField) {
            textField.selectAll();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == textField) {
            textField.selectAll();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateText();
    }


    public class MainPanel extends JPanel {

        private float scale = 1;

        public MainPanel() {

            addMouseWheelListener(new MouseAdapter() {

                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    double delta = 0.05f * e.getPreciseWheelRotation();
                    scale += delta;
                    revalidate();
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = new Dimension(200, 200);
            size.width = Math.round(size.width * scale);
            size.height = Math.round(size.height * scale);
            return size;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }
}
