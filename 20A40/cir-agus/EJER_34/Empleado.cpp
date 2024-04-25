# include <iostream>
# include <string>
# include "Empleado.h"

Empleado::Empleado(){}

Empleado::Empleado(std::string newNombre,double newSalario,std::string newFecha){
    this -> nombre = newNombre;
    this -> salario = newSalario;
    this -> fecha = newFecha;
}

bool Empleado::setNombre(std::string nom){
    if(nom.length() > 0){
        nombre = nom;
        return true;
    } else return false;    
}

bool Empleado::setSalario(double sal){
    if(sal > 0){
        salario = sal;
        return true;
    }else return false;
}

bool Empleado::setFecha(std::string fecha){
    if(fecha.length() > 0){
        fecha = fecha;
        return true;
    } else return false;
}

std::string Empleado::getNombre(){ return nombre; }
double Empleado::getSalario(){ return salario; }
std::string Empleado::getFecha() {return fecha;}

std::string Empleado::toString(){
    std::string cadena = "Nombre: "+nombre;
    cadena += "Salario: "+std::to_string(salario);
    cadena += "Fecha: "+fecha;
    return cadena;
}



