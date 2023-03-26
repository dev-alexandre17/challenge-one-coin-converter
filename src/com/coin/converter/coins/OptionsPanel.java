package com.coin.converter.coins;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinsOptions extends JFrame {

    private JLabel text;
    private JComboBox<String> comboBox;
    private JButton ok;
    private JButton cancel;
    private ConversionResultPanel previousFrame;
    private double valueInput;
    private double convertedValue;
    private String convertedCurrencyType;
    private String convertedCurrency;

    public CoinsOptions(double valueDecimal) {
        super("Moedas");

        this.valueInput = valueDecimal;

        text = new JLabel("Escolha a moeda para a qual você deseja girar seu dinheiro");

        String[] options = {"Converter de Reais a Dólar", "Converter de Reais a Euro",
                "Converter de Reais a Libras Esterlinas", "Converter de Reais a Peso Argentino",
                "Converter de Reais a Peso Chileno", "Converter de Dólar a Reais", "Converter de Euro a Reais",
                "Converter de Libras Esterlinas a Reais", "Converter de Peso Argentino a Reais",
                "Converter de Peso Chileno a Reais"};
        comboBox = new JComboBox<>(options);

        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        ok.setPreferredSize(new Dimension(90, 25));
        cancel.setPreferredSize(new Dimension(90, 25));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(3, 0, 0, 0);
        add(text, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(7, 0, 0, 0);
        add(comboBox, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(20, 80, 10, 100);
        add(ok, c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(-35, 185, 0, 0);
        add(cancel, c);

        panelSettings();

        changeFrame();

        comboBoxCalculator();

    }

    public CoinsOptions() {}

    public void panelSettings() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
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
            ConversionResultPanel conResultP = new ConversionResultPanel(convertedValue,
                    convertedCurrencyType, convertedCurrency);
            previousFrame = (ConversionResultPanel) conResultP;
            frame.dispose();
        });
    }

    public void comboBoxCalculator() {
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectOption = (String) comboBox.getSelectedItem();
                double result = 0.0;
                String currencyType = "";
                String currency = "";

                switch (selectOption) {
                    case "Converter de Reais a Dólar":
                        result = valueInput / 5.28;
                        currencyType = "$";
                        currency = "Dólares";
                        break;
                    case "Converter de Reais a Euro":
                        result = valueInput / 5.56;
                        currencyType = "Є";
                        currency = "Euros";
                        break;
                    case "Converter de Reais a Libras Esterlinas":
                        result = valueInput / 6.43;
                        currencyType = "£";
                        currency = "Libras Esterlinas";
                        break;
                    case "Converter de Reais a Peso Argentino":
                        result = valueInput / 0.026;
                        currencyType = "$";
                        currency = "Pesos Argentinos";
                        break;
                    case "Converter de Reais a Peso Chileno":
                        result = valueInput / 0.0064;
                        currencyType = "$";
                        currency = "Pesos Chilenos";
                        break;
                    case "Converter de Dólar a Reais":
                        result = valueInput * 5.28;
                        currencyType = "R$";
                        currency = "Reais";
                        break;
                    case "Converter de Euro a Reais":
                        result = valueInput * 5.56;
                        currencyType = "R$";
                        currency = "Reais";
                        break;
                    case "Converter de Libras Esterlinas a Reais":
                        result = valueInput * 6.43;
                        currencyType = "R$";
                        currency = "Reais";
                        break;
                    case "Converter de Peso Argentino a Reais":
                        result = valueInput * 0.026;
                        currencyType = "R$";
                        currency = "Reais";
                        break;
                    case "Converter de Peso Chileno a Reais":
                        result = valueInput * 0.0064;
                        currencyType = "R$";
                        currency = "Reais";
                        break;
                }

                convertedValue = result;
                convertedCurrencyType = currencyType;
                convertedCurrency = currency;

            }
        });
    }

}
