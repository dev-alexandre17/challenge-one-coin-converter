package com.coin.converter.components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FinalizedProgram extends JFrame {

    private JLabel text;
    private JButton ok;

    public FinalizedProgram() {
        super("Message");

        text = new JLabel("Programa finalizado");

        Icon icon = new ImageIcon(getClass().getResource("/assets/img/exclamation.png"));
        Image image = ((ImageIcon) icon).getImage();
        Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);

        ok = new JButton("Ok");
        ok.setPreferredSize(new Dimension(90, 25));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-20, -150, 0, 0);
        add(label, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-30, 15, 0, 0);
        add(text, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 0, -20, 0);
        add(ok, c);

        closeFrame();

        panelSettings();
    }

    private void panelSettings() {
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void closeFrame() {
        final JFrame frame = this;
        ok.addActionListener(e -> {
            frame.dispose();
        });
    }

}
