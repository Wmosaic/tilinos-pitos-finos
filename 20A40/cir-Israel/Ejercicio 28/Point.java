public class Point {
    private double x;
    private double y;

    // Constructor por defecto
    public Point() {}
    // Constructor sobrecargado
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p1 = new Point(); // Constructor por defecto
        Point p2 = new Point(3.5, 4.2); // Constructor sobrecargado

        System.out.println("Punto p1: " + p1);
        System.out.println("Punto p2: " + p2);
    }
}