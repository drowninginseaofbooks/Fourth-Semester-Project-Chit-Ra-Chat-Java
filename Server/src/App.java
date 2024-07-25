import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{

    // private Image backgroundImage;
    
    App(){
            Color customColor = new Color(135, 206, 250);

            JButton search = new JButton("Search");
            search.setBounds(260, 10, 100, 20);

            JTextField searchField = new JTextField();
            searchField.setBounds(50, 10, 200, 20);
            
            ChatPanel cp = new ChatPanel();
            // Color customColor = new Color(135, 206, 250);

            // JPanel top = new JPanel();
            // top.setBounds(0, 0, 1080, 150);
            // top.setBackground(customColor);
            // add(top);

            //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(getName()));
            
            add(searchField);
            add(search);
            add(cp);

            setSize(1080, 720);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            getContentPane().setBackground(customColor);
            getContentPane().setBounds(0, 100, 400, 720);

            setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}