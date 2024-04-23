#include "Mamifero.h"

Mamifero::Mamifero(){};
Mamifero::Mamifero(int nPatas, std::string col,
              std::string nom, std::string esp)
         : numeroDePatas(nPatas), color(col), nombre(nom), especie(esp){}

Mamifero::~Mamifero(){}

bool Mamifero::setPatas(int nPatas){
    if(!(nPatas >= 0))    return false;

    this->numeroDePatas = nPatas;
    return true;
}

bool Mamifero::setColor(std::string col){
    if(col.length() == 0)    return false;
    
    this->color = col;
    return true;
}

bool Mamifero::setNombre(std::string nom){
    if(nom.length() == 0)    return false;
    
    this->nombre = nom;
    return true;
}

bool Mamifero::setEspecie(std::string esp){
    if(esp.length() == 0)    return false;
    
    this->especie = esp;
    return true;
}


int Mamifero::getPatas()   {    return this->numeroDePatas;}
auto Mamifero::getColor()  {    return this->color;        }
auto Mamifero::getNombre() {    return this->nombre;       }
auto Mamifero::getEspecie(){    return this-> especie;     }

