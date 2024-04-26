#include <iostream>
#include <sstream>
#include <regex>

class Point {
private:
    double x;
    double y;

public:
    // Constructor por defecto
    Point() : x(0.0), y(0.0) {}

    // Constructor sobrecargado
    Point(double x, double y) : x(x), y(y) {}

    // Destructor
    ~Point() {}

    void setX(double newX) { x = newX; }
    void setY(double newY) { y = newY; }
    double getX() const { return x; }
    double getY() const { return y; }

    void setPoint(const std::string& p) {
        std::regex pattern(R"((-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?))");
        std::smatch matches;

        if (std::regex_search(p, matches, pattern)) {
            x = std::stod(matches[1]);
            y = std::stod(matches[3]);
        } else {
            std::cerr << "Formato incorrecto." << std::endl;
        }
    }

    std::string toString() const {
        std::stringstream ss;
        ss << "(" << x << ", " << y << ")";
        return ss.str();
    }
};

int main() {
    Point p1; // Constructor por defecto
    Point p2(3.5, 4.2); // Constructor sobrecargado

    std::cout << "Punto p1: " << p1.toString() << std::endl;
    std::cout << "Punto p2: " << p2.toString() << std::endl;

    // Usar setPoint para asignar coordenadas desde una cadena
    p1.setPoint("13.5, -14.5");
    std::cout << "Punto p1 (desde cadena): " << p1.toString() << std::endl;

    return 0;
}