package com.coin.converter.main;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DataEntryPanel extends JFrame {

    private JLabel text;
    private JButton ok;
    private JButton cancel;

    public DataEntryPanel() {
        super("Input");

        text =  new JLabel("Insira um valor: ");

        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        Icon icon = new ImageIcon(getClass().getResource("/assets/img/icon.png"));
        Image image = ((ImageIcon) icon).getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Icon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        JTextField textField = new JTextField(10);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-15, -200, -50, 0);
        add(label, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(-7, 0, 0, 0);
        add(text, c);

        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 0, 0, 0);
        add(textField, c);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

}