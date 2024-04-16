#ifndef MISCELANEO
#define MISCELANEO  

#include"Validador.h"

class Miscelaneo{
private:
    Validador validator;

public:
    Miscelaneo();
    Miscelaneo(Validador val);
    ~Miscelaneo();

    std::string stringInverter(std::string cadena); 
     
};


#endif
