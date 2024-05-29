#ifndef MONEDA
#define MONEDA

#include "../Validators/C++ API/CAPVAL/Validador.h"
#include <string>

class Moneda{
    typedef std::string cadena;
private:
    Validador* val = new Validador();
    double valor;
    int fecha;
    cadena escudo;
    cadena pais;
    cadena divisa;
public:
    Moneda();
    Moneda(double val, int dat, cadena esc, cadena pai, cadena div);
    ~Moneda();

    bool setValor(double val);
    bool setFecha(int dat);
    bool setEscudo(cadena esc);
    bool setPais(cadena pai);
    bool setDivisa(cadena div);

    double getValor();
    int getFecha();
    cadena getEscudo();
    cadena getPais();
    cadena getDivisa();

    cadena toString();
};

#endif
