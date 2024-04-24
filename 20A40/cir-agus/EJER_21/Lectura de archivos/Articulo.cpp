# include <iostream>
# include <string>
# include "Articulo.h"

using namespace std;

Articulo::Articulo(){}

Articulo::Articulo(string newDes, string newUni, double newCanti, double newPre)
{
    this -> descripcion = newDes;
    this -> unidad = newUni;
    this -> cantidad = newCanti;
    this -> precio = newPre;
}

bool Articulo::setDescripcion(string d)
{
    if(d.length() > 0)
    {
        descripcion = d;
        return true;

    } else return false;
}

bool Articulo::setUnidad(string u)
{
    if(u.length() > 0)
    {
        unidad = u;
        return true;
    }else return false;
}

bool Articulo::setCantidad(double c)
{
    if(c > 0)
    {
        cantidad = c;
        return true;
    } else return false;
}

bool Articulo::setPrecio(double p)
{
    if(p > 0)
    {
        precio = p;
        return true;
    } else return false;
}

string Articulo::getDescripcion(){return descripcion;}
string Articulo::getUnidad(){return unidad;}
double Articulo::getCantidad(){return cantidad;}
double Articulo::getPrecio(){return precio;}

string Articulo::toString()
{
    string cadena = "Descripcio: "+descripcion;
    cadena += "\nUnidad: "+unidad;
    cadena += "\nCantidad: "+to_string(cantidad);
    cadena += "\nPrecio: "+to_string(precio);
    return cadena;
}