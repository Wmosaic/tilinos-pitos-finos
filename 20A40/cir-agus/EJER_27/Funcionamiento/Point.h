# include <string>
#ifndef POINT_H
#define POINT_H

class Point
{
private:
    double x,y;
public:
    Point(); // Constructor por omision
    Point(double newX, double newY); //Cosntructor por sobre cargo
    void setX(double newX);
    void setY(double newY);
    double getX();
    double getY();
    std::string toString();
    ~Point();
};

#endif
