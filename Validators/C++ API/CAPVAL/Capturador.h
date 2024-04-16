#ifndef CAPTURADOR
#define CAPTURADOR

#include "Validador.h"

class Capturador {
private:
    Validador validator;

public:

    Capturador();
    Capturador(Validador val);
    ~Capturador();

    int capInt(std::string mensaje);

    int capInt(std::string mensaje, 
        int limite);

    int capInt(std::string mensaje, 
        int limiteInferior, int limiteSuperior);

    double capReal(std::string mensaje);

    double capReal(std::string mensaje, 
        int limite);

    double capReal(std::string mensaje, 
        int limiteInferior, int limiteSuperior);

    std::string capNom(std::string mensaje);

    std::string capNom(std::string mensaje, int limiteCaracteres);

    std::string capDate(std::string mensaje);

};

#endif
