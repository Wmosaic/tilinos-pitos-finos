import java.awt.Graphics;

public class Square extends Shape {
    
    public Square(){}
    public Square(int iniX, int iniY){
        x = iniX;
        y = iniY;
    }

    @Override
    public void display(Graphics drawArea) {
        drawArea.drawOval(x, y, size, size);
    }
}
