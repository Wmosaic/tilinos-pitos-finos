#include "Perro.h"
#include <string>

Perro::Perro(){}

Perro::Perro(
    int nPatas, std::string& colorP,std::string& nombreP, 
    std::string& especieP, int mordidosP, std::string& razaP) : 
        Mamifero(nPatas, colorP, nombreP, especieP),
        numDeMordidos(mordidosP), raza(razaP){}

Perro::~Perro(){}

bool Perro::setMordidos(int mordidosP){
    if(!(mordidosP >= 0)) return false;
    this->numDeMordidos = mordidosP;
}

bool Perro::setRaza(std::string& razaP){
    if(!(razaP.length() > 0)) return false;
    this->raza = razaP;
}

int Perro::getMordidos()    {    return numDeMordidos;    }
std::string Perro::getRaza(){    return raza;             }
