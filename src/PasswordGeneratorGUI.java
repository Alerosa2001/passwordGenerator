import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PasswordGeneratorGUI class provides a graphical interface to generate random passwords based on user-selected criteria.
 * The application allows users to specify password length and toggle options for uppercase letters, lowercase letters,
 * numbers, and special symbols. It inherits from JFrame to create a window-based GUI application.
 */
public class PasswordGeneratorGUI extends JFrame {

    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI() {
        super("Password Generator");
        setSize(540, 570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set a soft light gray background for the frame
        getContentPane().setBackground(new Color(0xF0F0F3));

        passwordGenerator = new PasswordGenerator();
        addGuiComponents();
    }

    private void addGuiComponents() {
        // Title label
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 40);
        titleLabel.setForeground(new Color(0x5D5D7E)); // Soft violet-gray for title text
        add(titleLabel);

        // Text area to display generated password
        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("SansSerif", Font.BOLD, 20));
        passwordOutput.setForeground(new Color(0x4A4A4A)); // Soft dark gray text
        passwordOutput.setBackground(new Color(0xE6E6FA)); // Lavender background for subtle contrast

        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 80, 490, 70);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0C1), 2)); // Light violet-gray border
        add(passwordOutputPane);

        // Label for password length input
        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        passwordLengthLabel.setBounds(25, 170, 270, 30);
        passwordLengthLabel.setForeground(new Color(0x5D5D7E));
        add(passwordLengthLabel);

        // Text area for user to enter password length
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0C1), 1));
        passwordLengthInputArea.setBounds(310, 170, 200, 40);
        passwordLengthInputArea.setBackground(new Color(0xEDEDF2)); // Light gray background for input area
        passwordLengthInputArea.setForeground(new Color(0x4A4A4A));
        add(passwordLengthInputArea);

        // Toggle buttons for each password character type
        JToggleButton uppercaseToggle = createToggleButton("Uppercase", 25, 230);
        JToggleButton lowercaseToggle = createToggleButton("Lowercase", 285, 230);
        JToggleButton numbersToggle = createToggleButton("Numbers", 25, 300);
        JToggleButton symbolsToggle = createToggleButton("Symbols", 285, 300);

        add(uppercaseToggle);
        add(lowercaseToggle);
        add(numbersToggle);
        add(symbolsToggle);

        // Generate button to create a password based on user input
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("SansSerif", Font.PLAIN, 28));
        generateButton.setBounds(155, 400, 220, 50);
        generateButton.setBackground(new Color(0x8A85D2)); // Soft violet for generate button
        generateButton.setForeground(Color.WHITE);
        generateButton.setFocusPainted(false);

        // Action listener to handle button click event
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordLengthInputArea.getText().length() <= 0) return;

                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected()
                        || numbersToggle.isSelected() || symbolsToggle.isSelected();

                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if (anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected()
                    );
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }

    private JToggleButton createToggleButton(String text, int x, int y) {
        JToggleButton toggleButton = new JToggleButton(text);
        toggleButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        toggleButton.setBounds(x, y, 225, 50);
        toggleButton.setBackground(new Color(0xDDDDE5)); // Soft light gray background
        toggleButton.setForeground(new Color(0x5D5D7E)); // Subtle violet-gray text color
        toggleButton.setFocusPainted(false);
        toggleButton.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0C1), 1)); // Light violet-gray border
        return toggleButton;
    }
}