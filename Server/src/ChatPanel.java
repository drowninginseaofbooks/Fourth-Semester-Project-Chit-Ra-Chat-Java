import java.awt.Color;
import javax.swing.JPanel;

public class ChatPanel extends JPanel{

    // private Image backgroundImage;

    ChatPanel(){
        super();
        // Color customColor = new Color(135, 206, 250);
        setBackground(Color.WHITE);
        setBounds(0, 0, 400, 720);

        

    // Constructor to load the image
        
    
    }
    // protected void paintComponent(Graphics g) {
    //     try {
    //         backgroundImage = ImageIO.read(new File("./lib/bobaBackground.jpeg"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     super.paintComponent(g);
    //     if (backgroundImage != null) {
    //         // Draw the image to fit the size of the panel
    //         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    //     }
    // }
}
