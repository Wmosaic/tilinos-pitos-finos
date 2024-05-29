import java.awt.*;
import javax.swing.*;

public class Defender extends Sprite {

    private ImageIcon userImage;

    public Defender() {
        x = 0;
        y = 175;
        width = 20;
        height = 20;        
        userImage = new ImageIcon("defender.jpg");

    }

    public void move(int newX) {
        x = newX;
    }

    public void draw(JPanel panel) {
        Graphics paper = panel.getGraphics();
        userImage.paintIcon(panel, paper, x, y);
    }
}
