import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel{
    
    private List<ColorPoint> currentPath;
    private Color color;
    private int xPos, yPos, STROKE_SIZE=8, width , height;

    public Canvas(int width, int height){
        super();

        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        MouseAdapter ma = new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseReleased(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                xPos = e.getX();
                yPos = e.getY();

                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(xPos, yPos, STROKE_SIZE, STROKE_SIZE);
                g.dispose();

                currentPath = new ArrayList<>(25);
                currentPath.add(new ColorPoint(xPos, yPos, color));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub
                xPos = e.getX();
                yPos = e.getY();

                //enables to draw a line
                Graphics2D g2D = (Graphics2D) getGraphics();
                g2D.setColor(color);

                if(!currentPath.isEmpty()){
                    ColorPoint prevPoint = currentPath.get(currentPath.size()-1);
                    g2D.setStroke(new BasicStroke(STROKE_SIZE));

                    //connect two points
                    g2D.drawLine(prevPoint.getX(), prevPoint.getY(), xPos, yPos);
                }
                g2D.dispose();

                ColorPoint nexPoint = new ColorPoint(e.getX(), e.getY(), color);
                currentPath.add(nexPoint);
            }
            
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void resetCanvas(){
        Graphics g = getGraphics();
        g.clearRect(0, 0, width, height);
        g.dispose();

        currentPath = null;

        repaint();
        revalidate();
    }

}
