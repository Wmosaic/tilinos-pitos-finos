# include <string>
# include "Point.h"

using namespace std;
 
Point::Point(){}

Point::Point(double x,double y){
    this -> x = x;
    this -> y = y;
}

 void Point::setX(double newX){ x = newX;}
 void Point::setY(double newY){ y = newY;}
 double Point::getX(){  return x;  }
 double Point::getY(){  return y;  }

 std::string Point::toString(){ 
    string resul = "("+to_string(x)+","+to_string(y)+")";
    return resul;
}

Point::~Point()
{
    delete[] this;
}