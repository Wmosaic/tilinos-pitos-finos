import java.awt.Graphics;
public class Circle extends Shape {
    public Circle(int initX, int initY) {
        x = initX;
        y = initY;
    }
    public void display(Graphics drawArea) {
        drawArea.drawOval(x, y, size, size);
    }
}
