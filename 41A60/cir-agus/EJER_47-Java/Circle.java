import java.awt.Graphics;

public class Circle extends Shape{
    public Circle(){}
    public Circle(int initX,int initY){
        x = initX;
        y = initY;
    }
    
    @Override
    public void display(Graphics drawArea){
        drawArea.drawRect(x, y, size, size);
    }
}
