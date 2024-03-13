import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounterApp extends JFrame implements ActionListener {
    JLabel inputLabel, outputLabel;
    JTextArea inputTextArea;
    JButton countButton;

    public WordCounterApp() {
        setTitle("Word Counter");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputLabel = new JLabel("Enter your paragraph:");
        add(inputLabel);

        inputTextArea = new JTextArea(10, 30);
        add(new JScrollPane(inputTextArea));

        countButton = new JButton("Count Words");
        countButton.addActionListener(this);
        add(countButton);

        outputLabel = new JLabel("Number of words: 0");
        add(outputLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = inputTextArea.getText();
            String[] words = text.trim().split("\\s+");
            outputLabel.setText("Number of words: " + words.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCounterApp());
    }
}
