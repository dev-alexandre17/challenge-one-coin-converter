package com.coin.converter.coins;

import javax.swing.*;
import java.awt.*;

public class ConversionResultPanel extends JFrame {

    private JLabel text;
    private JButton ok;

    private double valueConversion;
    private String currencyTP;
    private String currency;
    private ProceedPanel previousFrame;

    public ConversionResultPanel(double convertedValue, String currencyType, String currency) {
        super("Message");

        this.valueConversion = convertedValue;
        this.currencyTP = currencyType;
        this.currency = currency;

        text = new JLabel("O valor da conversão é " + currencyTP + " " +
                String.format("%.2f", convertedValue) + " " + currency);

        Icon icon = new ImageIcon(getClass().getResource("/assets/img/exclamation.png"));
        Image image = ((ImageIcon) icon).getImage();
        Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);

        ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(90, 25));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-50, 0, 0, 0);
        add(label, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(30, 0, 0, 0);
        add(text, c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, 0, 0, 0);
        add(ok, c);

        changeFrame();

        panelSettings();

    }

    private void panelSettings() {
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void changeFrame() {
        final JFrame frame = this;
        ok.addActionListener(e -> {
            if (previousFrame != null) {
                previousFrame.dispose();
            }
            ProceedPanel proceedP = new ProceedPanel();
            previousFrame = (ProceedPanel) proceedP;
            frame.dispose();
        });
    }


}
