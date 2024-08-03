import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Paint extends JFrame{

    private BufferedImage image;
    private Graphics2D g2d;


    public Paint(){
        
        JPanel canvasPanel = new JPanel();

        setTitle("Chit-Ra");

        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        //Create Canvas
        Canvas canvas = new Canvas(720, 700);
        add(canvas);

        image = new BufferedImage(720, 720, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 720, 720);

        //Color Pallet
        JButton chooseColorButton = new JButton("COLORS");
        // chooseColorButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        springLayout.putConstraint(SpringLayout.NORTH, canvas, 25, SpringLayout.NORTH, this);
        // springLayout.putConstraint(SpringLayout.WEST, canvas, 20, SpringLayout.WEST, this);

        chooseColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(null, "SELECT A COLOR", Color.BLACK);
                chooseColorButton.setBackground(c);
                canvas.setColor(c);
            }
        });

        this.add(chooseColorButton);

        //Clear Screen Button
        JButton clear = new JButton("CLEAR");
        // clear.putConstraint(SpringLayout.NORTH, canvas, 25, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, clear, 84, SpringLayout.WEST, canvasPanel);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.resetCanvas();
            }
        });

        this.add(clear);

        JButton save = new JButton("SAVE");
        springLayout.putConstraint(SpringLayout.WEST, save, 639, SpringLayout.WEST, canvasPanel);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.saveImage("drawing.png");
            }
        });

        this.add(save);


        setSize(720, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Paint();
    }
}
