/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chit.ra.chat;

import java.awt.Dimension;
import javax.swing.*;
/**
 *
 * @author hiros
 */
public class ChitRaChat extends JFrame{
    
    ChitRaChat(){
        
        this.setTitle("Chit-Ra Chat");
        
        LoginRegisterPanel lr = new LoginRegisterPanel();
        
        add(lr);
        
        
        setResizable(false);
        setSize(1080, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        new ChitRaChat(); 
    }
}
