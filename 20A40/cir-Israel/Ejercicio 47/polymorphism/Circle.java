import java.awt.*;

public class Circle extends Shape {

    public void display(Graphics paper) {
        paper.drawOval(x, y, size, size);
    }

}

