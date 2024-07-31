import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

public class App extends JFrame{

    // private Image backgroundImage;
    
    App(){  
            LoginRegisterPanel first = new LoginRegisterPanel();
            dispose();
            add(first);
            
            
            setSize(1080, 720);
            setVisible(true);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}