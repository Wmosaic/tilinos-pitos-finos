#ifndef GATO
#define GATO

#include "Mamifero.h"

class Gato : public Mamifero {
int ratonesAtrapados;
int arañados;

public:

Gato();
Gato(
    int nPatas, std::string& colorP, std::string& nombreP,
    std::string& especieP, int ratAtrap, int araña
);

~Gato();

bool setRatones(int ratones);
bool setArañados(int arañados);

int getRatones();
int getArañados();

};
#endif
