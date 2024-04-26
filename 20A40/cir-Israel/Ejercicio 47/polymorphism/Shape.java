import java.awt.*;

public abstract class Shape {

    protected int x, y ;
    protected int size;

    public void moveRight() {
        x = x + 10;
    }

    public abstract void display(Graphics paper);

}


class Square extends Shape {

    public void display(Graphics paper) {
        paper.drawRect(x, y, size, size);
    }

}
