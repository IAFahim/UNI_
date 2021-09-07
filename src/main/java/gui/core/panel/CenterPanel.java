package gui.core.panel;


import gui.Display;
import gui.core.button.YesButton;
import gui.core.effect.DropShadowBorder;
import gui.core.layout.VerticalFlowLayout;
import gui.core.panel.leftPanel.threePartPanel.IconTextFieldIconIconIconPanel;
import gui.util._Win;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import webScraper.WebScraper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static gui.util._Win.light_mode_color_panel_backGround;
import static gui.util._Win.smallFont;

public class CenterPanel implements MouseListener {
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
        textField.setPreferredSize(new Dimension(720, 45));
//        textField.setBorder(new EmptyBorder(5, 5, 5, 5));
        textField.setBorder(new DropShadowBorder());
        textField.setBackground(Color.WHITE);
        textField.setFont(_Win.largeFont);


        textArea = new TextArea();
        panel.add(textArea, BorderLayout.CENTER);

        panel.add(textField, BorderLayout.PAGE_START);
    }

    public TextArea textArea;

    Map<String, HashSet<String>> map;

    public void UpdateText() {
        SwingWorker swingWorker = new SwingWorker<Boolean, String>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                String url = textField.getText();
                WebScraper.run(url);
                Map<String, LinkedHashSet<String>> map = WebScraper.map;
                boolean any = false;

                for (String s : map.keySet()) {
                    for (String x : map.get(s)) {
                        System.out.println(s+" "+x);
                        IconTextFieldIconIconIconPanel button = new IconTextFieldIconIconIconPanel(s,x);
                        Display.leftPanel.button.add(button);
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

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == textField) {
            UpdateText();
        }
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
