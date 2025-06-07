
package javaapplication12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PasswordField extends JFrame {
    public PasswordField() {
        setTitle("Modern Password Field");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

       
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar((char) 0);
        passwordField.setText("Enter Password");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(passwordField, gbc);

        
        JToggleButton toggleButton = new JToggleButton("Show");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(toggleButton, gbc);

        
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Enter Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*'); 
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setEchoChar((char) 0); 
                    passwordField.setText("Enter Password");
                }
            }
        });

        
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                    toggleButton.setText("Hide");
                } else {
                    passwordField.setEchoChar('*');
                    toggleButton.setText("Show");
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordField());
    }
}