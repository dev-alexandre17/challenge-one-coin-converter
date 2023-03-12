import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class MainMenuPanel extends JFrame {

    private JLabel text;
    private JComboBox<String> comboBox;
    private JButton ok;
    private JButton cancel;
    private JFrame frame;
    private DataEntryPanel previousFrame;

    public MainMenuPanel() {
        super("Menu");

        text = new JLabel("Escolha uma opção: ");

        String[] options = {"Conversor de Moeda"};
        comboBox = new JComboBox<>(options);

        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        ok.setPreferredSize(new Dimension(90, 25));
        cancel.setPreferredSize(new Dimension(90, 25));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(-20, 0, 0, 0);
        add(text, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 0, 0, 0);
        add(comboBox, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 0, 0, 0);
        add(ok, c);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 0, 0, 0);
        add(cancel, c);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        ChangeFrame();

    }

    public void ChangeFrame() {
        final JFrame frame = this;
        ok.addActionListener(e -> {
            if (previousFrame != null) {
                previousFrame.dispose();
            }
            DataEntryPanel dataEntryPanel = new DataEntryPanel();
            previousFrame = (DataEntryPanel) dataEntryPanel;
            frame.dispose();
        });
    }

}

