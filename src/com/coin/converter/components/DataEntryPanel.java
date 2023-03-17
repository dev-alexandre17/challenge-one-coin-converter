package com.coin.converter.components;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DataEntryPanel extends JFrame {

    private JLabel text;
    private JButton ok;
    private JButton cancel;
    private JFrame frame;
    private CoinsOptionsPanel previousFrame;

    public DataEntryPanel() {
        super("Input");

        text =  new JLabel("Insira um valor: ");

        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        ok.setPreferredSize(new Dimension(90, 25));
        cancel.setPreferredSize(new Dimension(90, 25));

        Icon icon = new ImageIcon(getClass().getResource("/assets/img/icon.png"));
        Image image = ((ImageIcon) icon).getImage();
        Image scaledImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Icon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat("#,##0.00", symbols);
        JFormattedTextField textField = new JFormattedTextField(format);
        textField.setValue(0.0);
        textField.setColumns(10);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(-70, -110, -18, 0);
        add(label, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-80, -30, 0, -100);
        add(text, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(-20, -4, 0, -100);
        add(textField, c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 0, -90, 100);
        add(ok, c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0, -80, -90, -200);
        add(cancel, c);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueFieldText = textField.getText();
                valueFieldText = valueFieldText.replace(",",".");
                double valueDecimal = Double.parseDouble(valueFieldText);
                System.out.println("Valor digitado: " + valueDecimal);
            }
        });

        panelSettings();

        changeFrame();

    }

    public void changeFrame() {
        final JFrame frame = this;
        ok.addActionListener(e -> {
            if (previousFrame != null) {
                previousFrame.dispose();
            }
            CoinsOptionsPanel coinsOptionPanel = new CoinsOptionsPanel();
            previousFrame = (CoinsOptionsPanel) coinsOptionPanel;
            frame.dispose();
        });
    }

    public void panelSettings() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}