#include "Point.h"
#include "Splitter.h"
#include <regex>

using namespace std::string_literals; 

Point::Point(): x(0) , y(0){};
Point::Point(double x_param, double y_param)
    : x(x_param) , y(y_param){};

Point::~Point(){};

void Point::setX(double x_param){    this->x = x_param;    }
void Point::setY(double y_param){    this->y = y_param;    }

double Point::getX(){    return this->x;    };
double Point::getY(){    return this->y;    };

bool Point::setPoint(std::string point){
    std::basic_regex<char> patronRegex{
        "^(-?\\d+(\\.\\d+)?), (-?\\d+(\\.\\d+)?)$"};

    if(!std::regex_match(point, patronRegex))
        return false;
    
    auto nums = Splitter::Split(point, ',');
    this->x = stof(nums[0]);
    this->y = stof(nums[1]);
    return true;
}

std::string Point::toString(){
    std::string coordX {std::to_string(x)};
    std::string coordY {std::to_string(y)};
    std::string concat {"X: "s + coordX +  " Y: "s + coordY  + "\n"};

    return concat;
}
