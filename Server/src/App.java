import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{

    // private Image backgroundImage;
    
    App(){  
            // LoginRegisterPanel first = new LoginRegisterPanel();

            // add(first);

            Signup signup = new Signup();
            add(signup);

            setSize(1080, 720);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
       
    }
}