import java.awt.*;
import javax.swing.*;

public class Bomb extends Sprite {

    private int stepSize;
    private ImageIcon bombImage;


    public Bomb(int initialX, int initialY) {
        x = initialX;
        y = initialY;
        width = 5;
        height = 10;
        stepSize = 10;        
        bombImage = new ImageIcon("bomb.jpg");
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        bombImage.paintIcon(panel, paper, x, y);

    }

    public void move() {
        y = y + stepSize;
    }
}
