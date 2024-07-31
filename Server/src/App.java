import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

public class App extends JFrame{

    // private Image backgroundImage;
    
    App(){  
            LoginRegisterPanel first = new LoginRegisterPanel();
            add(first);
            
            
            setSize(1080, 720);
            setVisible(true);
            setLayout(null);
            setLocationRelativeTo(null);
            
    }
    public static void main(String[] args) throws Exception {
        new App();
       
    }
}