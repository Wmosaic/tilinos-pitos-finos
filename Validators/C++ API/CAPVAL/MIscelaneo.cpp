#include "Miscelaneo.h"
#include <iostream>

Miscelaneo::Miscelaneo(){
    Validador val;
    this -> validator = val; 
}

Miscelaneo::Miscelaneo(Validador val){
    this -> validator = val;
}

Miscelaneo::~Miscelaneo(){    delete this;    }

std::string Miscelaneo::stringInverter(std::string cadena){
    std::string aux;
    if(!validator.isStr(cadena))
        std::cout << "Cadena no valida";
        return aux;
    for(int i = cadena.length() - 1; i >= 0; i--){
        aux += cadena[i];
    }
    return aux;

}
