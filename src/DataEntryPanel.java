import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DataEntryPanel extends JFrame {

    public DataEntryPanel() {
        JFrame newFrame = new JFrame("Nova Janela");
        newFrame.setSize(400, 300);

        JPanel newPanel = new JPanel();
        JLabel newLabel = new JLabel("Nova Tela!");
        newPanel.add(newLabel);
        newFrame.add(newPanel);

        newFrame.setVisible(true);

    }

}