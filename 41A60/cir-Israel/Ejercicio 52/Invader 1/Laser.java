import java.awt.*;
import javax.swing.*;

public class Laser extends Sprite {

    private int stepSize;
    private ImageIcon laserImage;

    public Laser(int newX, int newY) {
        x = newX;
        y = newY;
        width = 5;
        height = 5;
        stepSize = 10;        
        laserImage = new ImageIcon("laser.jpg");
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        laserImage.paintIcon(panel, paper, x, y);
    }

    public void move() {
        y = y - stepSize;
    }
}
