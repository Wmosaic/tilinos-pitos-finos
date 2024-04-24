# include <string>

# define ARTICULO_H
# ifdef ARTICULO_H

using namespace std;

class Articulo
{
private:
    string descripcion, unidad;
    double cantidad, precio;
public:
    Articulo();
    Articulo(string newDes, string newUni, double newCanti, double newPre);
    bool setDescripcion(string d);
    bool setUnidad(string u);
    bool setCantidad(double c);
    bool setPrecio(double p);
    string getDescripcion();
    string getUnidad();
    double getCantidad();
    double getPrecio();
    string toString();
};




# endif 