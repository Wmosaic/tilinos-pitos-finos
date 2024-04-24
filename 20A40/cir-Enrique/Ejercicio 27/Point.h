#ifndef POINT
#define POINT

#include <string>

class Point{

double x,y;

public:
    Point();
    Point(double x_param, double y_param);
    ~Point();
    
    void setX(double x_param);
    void setY(double y_param);

    double getX();
    double getY();

    std::string toString();

};

#endif
