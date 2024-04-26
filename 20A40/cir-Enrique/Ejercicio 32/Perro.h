#ifndef PERRO
#define PERRO

#include "Mamifero.h"
#include <string>

class Perro : public Mamifero {
int numDeMordidos;
std::string raza;

public:

Perro();
Perro(
    int nPatas, std::string& colorP,std::string& nombreP, 
    std::string& especieP, int mordidosP, std::string& razaP
);

~Perro();

bool setMordidos(int mordidosP);
bool setRaza(std::string& razaP);

int getMordidos();
std::string getRaza();

};

#endif
