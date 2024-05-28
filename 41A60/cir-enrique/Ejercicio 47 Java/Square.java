import java.awt.Graphics;
public class Square extends Shape {
    public Square(int initX, int initY) {
        x = initX;
        y = initY;
    }
    public void display(Graphics drawArea) {
        drawArea.drawRect(x, y, size, size);
    }
}