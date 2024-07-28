/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chit.ra.chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author hiros
 */
public class LoginRegisterPanel extends JPanel{
    LoginRegisterPanel(){
        super();
        
        this.setBackground(Color.BLACK);

        setLayout(new GridBagLayout());

        // Create GridBagConstraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // Create buttons
        JButton logIn = new JButton("LOGIN");
        JButton signUp = new JButton("REGISTER");
        
        logIn.setBackground(Color.WHITE);
        signUp.setBackground(Color.WHITE);

        // Set common constraints for both buttons
        gbc.insets = new Insets(10, 10, 10, 10); // Margin around buttons
        gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        gbc.gridy = 0; // Same row for both buttons

        // Add button1 with its constraints
        gbc.gridx = 0; // Column 0
        add(logIn, gbc);
        
        System.out.println(gbc);
        // Add button2 with its constraints
        gbc.gridx = 1; // Column 1
        add(signUp, gbc);
        
        logIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logIn.setBackground(Color.WHITE);
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logIn.setBackground(Color.WHITE);
            }
        });

        
    }
}
