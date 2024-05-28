import java.awt.Graphics;
public abstract class Shape {
    protected int x, y;
    protected int size = 20;
    public abstract void display(Graphics drawArea);
}