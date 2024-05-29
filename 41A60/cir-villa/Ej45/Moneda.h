#ifndef MONEDA
#define MONEDA

#include "../Validators/C++ API/CAPVAL/Validador.h"
#include <string>

class Moneda{
    typedef std::string cadena;
private:
    Validador* val = new Validador();
    int valor;
    int fecha;
    cadena escudo;
    cadena pais;
    cadena divisa;
public:
    Moneda();
    Moneda(int val, int dat, cadena esc, cadena pai, cadena div);
    ~Moneda();

    bool setValor(int val);
    bool setFecha(int dat);
    bool setEscudo(cadena esc);
    bool setPais(cadena pai);
    bool setDivisa(cadena div);

    int getValor();
    int getFecha();
    cadena getEscudo();
    cadena getPais();
    cadena getDivisa();

    cadena toString();
};

#endif
