import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<ColorPoint> currentPath;
    private Color color;
    private int xPos, yPos, STROKE_SIZE = 8, width, height;
    private BufferedImage image;
    private Graphics2D g2d;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Create a BufferedImage and get its Graphics2D context
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        MouseAdapter ma = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                xPos = e.getX();
                yPos = e.getY();

                g2d.setColor(color);
                g2d.fillRect(xPos, yPos, STROKE_SIZE, STROKE_SIZE);

                currentPath = new ArrayList<>(25);
                currentPath.add(new ColorPoint(xPos, yPos, color));
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                xPos = e.getX();
                yPos = e.getY();

                g2d.setColor(color);
                if (!currentPath.isEmpty()) {
                    ColorPoint prevPoint = currentPath.get(currentPath.size() - 1);
                    g2d.setStroke(new BasicStroke(STROKE_SIZE));

                    g2d.drawLine(prevPoint.getX(), prevPoint.getY(), xPos, yPos);
                }

                currentPath.add(new ColorPoint(xPos, yPos, color));
                repaint();
            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void saveImage(String filePath) {
        try {
            File file = new File(filePath);
            ImageIO.write(image, "png", file);
            JOptionPane.showMessageDialog(this, "IMAGE SAVED: " + filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "FAILED TO SAVE IMAGE!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void resetCanvas() {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        repaint();
    }

    public BufferedImage getImage() {
        return image;
    }
}
