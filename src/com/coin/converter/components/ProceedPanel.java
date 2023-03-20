package com.coin.converter.components;

import javax.swing.*;

public class ProceedPanel extends JFrame {

    public ProceedPanel() {
        super("Select an Option");

        panelSettings();

    }

    public void panelSettings() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }




}