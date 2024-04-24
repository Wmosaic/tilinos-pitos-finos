public class Point {
    private double x,y;

    Point(){}
    Point(double x_param, double y_param){
        this.x = x_param;
        this.y = y_param;
    }

    public void setX(double x_param){    this.x = x_param;    }
    public void setY(double y_param){    this.y =  y_param;   }

    public double setX(){    return this.x ;    }
    public double setY(){    return this.x ;    }

    public String toString(){   return "X: " + this.x + " Y: " + this.y;    }
}
