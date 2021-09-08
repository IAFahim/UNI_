import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class orderedItems extends JFrame implements ActionListener {


    Container wind = getContentPane();

    JLabel rstrntLabel = new JLabel("RADHUNI RANNAGHOR");
    JLabel choose = new JLabel("Select Items :");
    JLabel Items = new JLabel("Item Name");
    JLabel Qnt = new JLabel("Quantity");
    JLabel price = new JLabel("Price");
    JLabel biryaniPrice = new JLabel("150");
    JLabel mCurryPrice = new JLabel("250");
    JLabel bRezalaPrice = new JLabel("250");
    JLabel ChickRoastPrice = new JLabel("180");
    JLabel borhaniPrice = new JLabel("80");
    JLabel billPrint = new JLabel("Total Order:");


    JCheckBox biryani = new JCheckBox("Biryani");
    JCheckBox mCurry = new JCheckBox("Mutton Curry");
    JCheckBox bRezala = new JCheckBox("Beef Rezala");
    JCheckBox ChickRoast = new JCheckBox("Chicken Roast");
    JCheckBox borhani = new JCheckBox("Borhani");

    JTextField biryaniQnt = new JTextField();
    JTextField mCurryQnt = new JTextField();
    JTextField bRezalaQnt = new JTextField();
    JTextField ChickRoastQnt = new JTextField();
    JTextField borhaniQnt = new JTextField();

    JTextArea billArea = new JTextArea();

//    ImageIcon ordbgimage=new ImageIcon("C:\\Users\\noorr\\OneDrive\\Desktop\\cse215\\LoginFrame\\background image\\login.jpg");
//    JLabel ordimg=new JLabel(ordbgimage);


    JButton finish = new JButton("Bill");

    orderedItems() {
        this.setTitle("Radhuni Rannaghor");
        this.setBounds(500, 100, 600, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);

//        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\noorr\\OneDrive\\Desktop\\cse215\\LoginFrame\\icon image\\r logo.png"));

        orderWindow();
        addActionEvent();
    }


    public void orderWindow() {
        wind.setLayout(null);
        wind.setBackground(Color.WHITE);

        rstrntLabel = new JLabel("RADHUNI RANNAGHOR");
        rstrntLabel.setBounds(130, 82, 400, 100);
        rstrntLabel.setForeground(new Color(11, 60, 219));
        rstrntLabel.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC, 30));
        rstrntLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        wind.add(rstrntLabel);

        choose = new JLabel("Select Items :");
        choose.setBounds(20, 230, 180, 37);
        choose.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC, 24));
        choose.setForeground(Color.orange);
        wind.add(choose);

        Items = new JLabel("Item Name");
        Items.setBounds(50, 270, 120, 30);
        Items.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        Items.setForeground(Color.BLACK);
        wind.add(Items);

        Qnt = new JLabel("Quantity");
        Qnt.setBounds(250, 270, 80, 30);
        Qnt.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        Qnt.setForeground(Color.BLACK);
        wind.add(Qnt);

        price = new JLabel("Price(tk)");
        price.setBounds(430, 270, 80, 30);
        price.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        price.setForeground(Color.BLACK);
        wind.add(price);

        biryani = new JCheckBox("Biryani");
        biryani.setBounds(30, 320, 200, 25);
        biryani.setFont(new Font("San Francisco", Font.ITALIC + Font.CENTER_BASELINE, 12));
        wind.add(biryani);

        biryaniQnt = new JTextField();
        biryaniQnt.setBounds(250, 320, 80, 30);
        biryaniQnt.setToolTipText("Quantity");
        biryaniQnt.setFont(new Font("San Francisco", Font.BOLD, 16));
        wind.add(biryaniQnt);

        biryaniPrice = new JLabel("150");
        biryaniPrice.setBounds(430, 320, 80, 30);
        biryaniPrice.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        wind.add(biryaniPrice);

        mCurry = new JCheckBox("Mutton curry");
        mCurry.setBounds(30, 360, 200, 25);
        mCurry.setFont(new Font("San Francisco", Font.ITALIC + Font.CENTER_BASELINE, 12));
        wind.add(mCurry);

        mCurryQnt = new JTextField();
        mCurryQnt.setBounds(250, 360, 80, 30);
        mCurryQnt.setFont(new Font("San Francisco", Font.BOLD, 16));
        mCurryQnt.setToolTipText("Quantity");
        wind.add(mCurryQnt);

        mCurryPrice = new JLabel("250");
        mCurryPrice.setBounds(430, 360, 80, 30);
        mCurryPrice.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        wind.add(mCurryPrice);

        bRezala = new JCheckBox("Beef Rezala");
        bRezala.setBounds(30, 400, 200, 25);
        bRezala.setFont(new Font("San Francisco", Font.ITALIC + Font.CENTER_BASELINE, 12));
        wind.add(bRezala);

        bRezalaQnt = new JTextField();
        bRezalaQnt.setBounds(250, 400, 80, 30);
        bRezalaQnt.setFont(new Font("San Francisco", Font.BOLD, 16));
        bRezalaQnt.setToolTipText("Quantity");
        wind.add(bRezalaQnt);

        bRezalaPrice = new JLabel("250");
        bRezalaPrice.setBounds(430, 400, 80, 30);
        bRezalaPrice.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        wind.add(bRezalaPrice);

        ChickRoast = new JCheckBox("Chicken Roast");
        ChickRoast.setBounds(30, 440, 200, 30);
        ChickRoast.setFont(new Font("San Francisco", Font.ITALIC + Font.CENTER_BASELINE, 12));
        wind.add(ChickRoast);

        ChickRoastQnt = new JTextField();
        ChickRoastQnt.setBounds(250, 440, 80, 30);
        ChickRoastQnt.setFont(new Font("San Francisco", Font.BOLD, 16));
        ChickRoastQnt.setToolTipText("Quantity");
        wind.add(ChickRoastQnt);

        ChickRoastPrice = new JLabel("180");
        ChickRoastPrice.setBounds(430, 440, 80, 30);
        ChickRoastPrice.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        wind.add(ChickRoastPrice);

        borhani = new JCheckBox("Borhani");
        borhani.setBounds(30, 480, 200, 30);
        borhani.setFont(new Font("San Francisco", Font.ITALIC + Font.CENTER_BASELINE, 12));
        wind.add(borhani);

        borhaniQnt = new JTextField();
        borhaniQnt.setBounds(250, 480, 80, 30);
        borhaniQnt.setFont(new Font("San Francisco", Font.BOLD, 16));
        ChickRoastQnt.setToolTipText("Quantity");
        wind.add(borhaniQnt);

        borhaniPrice = new JLabel("80");
        borhaniPrice.setBounds(434, 480, 80, 30);
        borhaniPrice.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        wind.add(borhaniPrice);

        finish = new JButton("BILL");
        finish.setBounds(245, 550, 100, 30);
        finish.addActionListener(this);
        wind.add(finish);

        billPrint = new JLabel("Total Order:");
        billPrint.setBounds(20, 570, 180, 37);
        billPrint.setFont(new Font("San Francisco", Font.BOLD + Font.ITALIC, 24));
        billPrint.setForeground(Color.orange);
        wind.add(billPrint);

        billArea = new JTextArea();
        billArea.setBounds(30, 620, 520, 90);
        billArea.setFont(new Font("serif", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 18));
        wind.add(billArea);

//        ordimg.setBounds(0, 0, 600, 800);
//        wind.add(ordimg);


    }


    public void addActionEvent() {
        //biryani.addActionListener(this);
        //mCurry.addActionListener(this);
        //bRezala.addActionListener(this);
        //ChickRoast.addActionListener(this);
        //borhani.addActionListener(this);
        finish.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double price = 0;
        String s1 = biryaniQnt.getText();
        int birqnt = fahimValidate(s1);
        String s2 = mCurryQnt.getText();
        int mCurQnt = fahimValidate(s2);
        String s3 = bRezalaQnt.getText();
        int bRezQnt = fahimValidate(s3);
        String s4 = ChickRoastQnt.getText();
        int CRQnt = fahimValidate(s4);
        String s5 = borhaniQnt.getText();
        int borQnt = fahimValidate(s5);


        //	String print="";
        if (biryani.isSelected()) {
            price += (double) 150 * birqnt;
            //print+="Biryani=150 tk\n";
        }
        if (mCurry.isSelected()) {
            price += (double) 250 * mCurQnt;
            //print+="Mutton Curry=250 tk\n";
        }
        if (bRezala.isSelected()) {
            price += (double) 250 * bRezQnt;
            //print+="Beef Rezala=250 tk\n";
        }
        if (ChickRoast.isSelected()) {
            price += (double) 180 * CRQnt;
            //print+="Chicken Roast=180 tk\n";
        }
        if (borhani.isSelected()) {
            price += (double) 80 * borQnt;
            //print+="Borhani=80 tk\n";
        }


        if (e.getSource() == finish) {
            //	print+="---------------\n";

            billPrint.setText("\n Total:" + price);
            //JOptionPane.showMessageDialog(this,print+"Total: "+price);
            //this.setVisible(false);

            //billing bill=new billing();
            //bill.setVisible(true);
        }

    }


    public int fahimValidate(String str) {
        if (str != null && str.length() != 0) {
            return Integer.parseInt(str);
        }
        return 0;
    }
}


public class Order {
    public static void main(String[] args) {
        orderedItems ot = new orderedItems();
        ot.setVisible(true);

    }


}