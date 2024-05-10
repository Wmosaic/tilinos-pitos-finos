import java.awt.*;
import javax.swing.*;

public class Alien extends Sprite { 

    private int stepSize;
    private ImageIcon alienImage;

    public Alien() {
        x = 0;
        y = 25;
        width = 20;
        height = 10;
        stepSize = 10;        
        alienImage = new ImageIcon("alien.jpg");
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        alienImage.paintIcon(panel, paper, x, y);
    }

    public void move() {
        if (x > 200 || x < 0) {
            stepSize = -stepSize;
        }
        x = x + stepSize;
    }
}
