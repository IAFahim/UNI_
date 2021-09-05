/**
 * Demonstrate various aspects of Swing "data transfer".
 * @author Ian Darwin, http://www.darwinsys.com
 * @author Jonathan Fuerth, http://www.SQLPower.ca
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextDragHandler extends JFrame {
    public static void main(String[] args) {
        new TextDragHandler().setVisible(true);
    }

    private JTextField tf;

    private JLabel l;

    private JComboBox propertyComboBox;

    public TextDragHandler() {
        Container cp = new Box(BoxLayout.X_AXIS);
        setContentPane(cp);
        JPanel firstPanel = new JPanel();
        propertyComboBox = new JComboBox();
        propertyComboBox.addItem("text");
        propertyComboBox.addItem("font");
        propertyComboBox.addItem("background");
        propertyComboBox.addItem("foreground");
        firstPanel.add(propertyComboBox);
        cp.add(firstPanel);
        cp.add(Box.createGlue());

        tf = new JTextField("Hello");
        tf.setForeground(Color.RED);
        tf.setDragEnabled(true);
        cp.add(tf);

        cp.add(Box.createGlue());

        l = new JLabel("Hello");
        l.setBackground(Color.YELLOW);
        cp.add(l);

        cp.add(Box.createGlue());

        JSlider stryder = new JSlider(SwingConstants.VERTICAL);
        stryder.setMinimum(10);
        stryder.setValue(14);
        stryder.setMaximum(72);
        stryder.setMajorTickSpacing(10);
        stryder.setPaintTicks(true);

        cp.add(stryder);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        setMyTransferHandlers((String) propertyComboBox.getSelectedItem());

        MouseListener myDragListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JComponent c = (JComponent) e.getSource();
                TransferHandler handler = c.getTransferHandler();
                handler.exportAsDrag(c, e, TransferHandler.COPY);
            }
        };
        l.addMouseListener(myDragListener);

        propertyComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ce) {
                JComboBox bx = (JComboBox) ce.getSource();
                String prop = (String) bx.getSelectedItem();
                setMyTransferHandlers(prop);
            }
        });

        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JTextField jtf = (JTextField) evt.getSource();
                String fontName = jtf.getText();
                Font font = new Font(fontName, Font.BOLD, 18);
                tf.setFont(font);
            }
        });

        stryder.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                JSlider sl = (JSlider) evt.getSource();
                Font oldf = tf.getFont();
                Font newf = oldf.deriveFont((float) sl.getValue());
                tf.setFont(newf);
            }
        });
    }

    private void setMyTransferHandlers(String s) {
        TransferHandler th = new TransferHandler(s);
        tf.setTransferHandler(th);
        l.setTransferHandler(th);
    }
}

           