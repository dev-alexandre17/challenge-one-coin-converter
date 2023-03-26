package com.coin.converter.components;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class ProceedPanel extends JFrame {

    private JLabel text;
    private JButton yes;
    private JButton no;
    private JButton cancel;
    private JFrame frame;

    private MainMenuPanel previousMainMenu;
    private FinalizedProgram previousFinalized;

    public ProceedPanel() {
        super("Select an Option");

        text = new JLabel("Deseja continuar? ");

        Icon icon = new ImageIcon(getClass().getResource("/assets/img/exclamation.png"));
        Image image = ((ImageIcon) icon).getImage();
        Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Icon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);

        yes = new JButton("Yes");
        no = new JButton("No");
        cancel = new JButton("Cancel");

        yes.setPreferredSize(new Dimension(90, 25));
        no.setPreferredSize(new Dimension(90, 25));
        cancel.setPreferredSize(new Dimension(90, 25));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, -300, 0, 0);
        add(label, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(-30, -130, 0 ,0);
        add(text, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(15, -240, 10, 0);
        add(yes, c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(-45, -10, 0, 0);
        add(no, c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(-45, -80, 0, -300);
        add(cancel, c);

        frameBackToMain();

        frameFinalizedProgram();

        panelSettings();

    }

    public void panelSettings() {
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void frameBackToMain() {
        final JFrame frame = this;
        yes.addActionListener(e -> {
            if (previousMainMenu != null) {
                previousMainMenu.dispose();
            }
            MainMenuPanel mainMenuPanel = new MainMenuPanel();
            previousMainMenu = (MainMenuPanel) mainMenuPanel;
            frame.dispose();
        });
    }

    public void frameFinalizedProgram() {
        final JFrame frame = this;
        no.addActionListener(e -> {
            if (previousFinalized != null) {
                previousFinalized.dispose();
            }
            FinalizedProgram finalizedP = new FinalizedProgram();
            previousFinalized = (FinalizedProgram) finalizedP;
            frame.dispose();
        });
    }




}