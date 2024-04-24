#include "Gato.h"
#include <string>

Gato::Gato(){}

Gato::Gato(
    int nPatas, std::string& colorP,std::string& nombreP, 
    std::string& especieP, int ratAtrap, int araña) : 
        Mamifero(nPatas, colorP, nombreP, especieP),
        ratonesAtrapados(ratAtrap), arañados(araña){}
Gato::~Gato(){}

bool Gato::setRatones(int ratones){
    if(!(ratones >= 0)) return false;
    this->ratonesAtrapados = ratones;
}

bool Gato::setArañados(int arañadosP){
    if(!(arañadosP >= 0)) return false;
    this->arañados = arañadosP;
}

int Gato::getRatones() {    return ratonesAtrapados;    }
int Gato::getArañados(){    return arañados;            }
