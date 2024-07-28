import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ChatPanel extends JPanel {
    private Image backgroundImage;
    private float opacity;

    // Constructor to load the image
    public ChatPanel(float opacity) {
        super();
        setBackground(Color.WHITE);
        setBounds(0, 0, 400, 720);
        this.opacity = opacity;
        try {
            backgroundImage = ImageIO.read(new File("./lib/bobaBackground.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            // Set the opacity
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            // Draw the image to fit the size of the panel
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }
    }
}