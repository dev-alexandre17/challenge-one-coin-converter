package com.coin.converter.components;

import javax.swing.JFrame;

public class ConversionResultPanel extends JFrame {

    public ConversionResultPanel() {
        super("Message");

        panelSettings();

    }

    private void panelSettings() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
