package gui.core.panel;


import gui.core.layout.VerticalFlowLayout;
import gui.util._Win;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import static gui.util._Win.light_mode_color_panel_backGround;
import static gui.util._Win.smallFont;

public class CenterPanel implements DocumentListener {
    public JTextField textField;
    public JPanel panel;
    public String textFieldString;
    public CenterPanel() {
        panel=new MainPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(new Dimension(1272,1035));
        panel.setBackground(_Win.light_mode_color_frame_backGround);

        textFieldString ="url://";
        textField = new JTextField();
        textField = new JTextField(textFieldString);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(textFieldString)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText("Search");
                }
            }
        });
        textField.getDocument().addDocumentListener(this);
        textField.setSize(new Dimension(720,45));
        textField.setBorder(new EmptyBorder(5,5,5,5));
        textField.setBackground(Color.WHITE);
        textField.setFont(_Win.largeFont);
        panel.add(textField,BorderLayout.PAGE_START);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

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
