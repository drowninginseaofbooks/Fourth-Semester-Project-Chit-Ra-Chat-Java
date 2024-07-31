
import java.awt.*;

public class ColorPoint {

    private Color color;
    private int xPos, yPos;

    public ColorPoint(int x, int y, Color color){
        xPos = x;
        yPos = y;
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
    
    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }
}
