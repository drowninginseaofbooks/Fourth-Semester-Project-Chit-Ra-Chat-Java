import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SaveDrawingPanel extends JPanel {

    private BufferedImage image;
    private Graphics2D g2d;

    public SaveDrawingPanel() {
        // Create an image and get its Graphics2D object
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 800, 600); // Fill the background with white

        // Set up mouse listeners for drawing
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                g2d.setColor(Color.BLACK); // Draw in black
                g2d.fillOval(e.getX(), e.getY(), 5, 5); // Draw a small dot
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                g2d.fillOval(e.getX(), e.getY(), 5, 5); // Draw a small dot
                repaint();
            }
        });
    }

    // Override paintComponent to draw the image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    // Method to save the image to a file
    public void saveImage(String filePath) {
        try {
            File file = new File(filePath);
            ImageIO.write(image, "png", file);
            JOptionPane.showMessageDialog(this, "Image saved: " + filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save image!");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw and Save Example");
        SaveDrawingPanel drawingPanel = new SaveDrawingPanel();
        
        frame.setLayout(new BorderLayout());
        frame.add(drawingPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Drawing");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.saveImage("drawing.png");
            }
        });

        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
