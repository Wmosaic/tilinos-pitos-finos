#ifndef MONEDA_H
#define MONEDA_H

#include <string>

class Moneda {
private:
    double Valor;
    std::string Divisa;
    std::string Escudo;
    std::string Pais;
    int Año;

public:
    bool setValor(double Val);
    bool setDivisa(std::string Div);
    bool setEscudo(std::string Esc);
    bool setPais(std::string Pa);
    bool setAño(int A);
    double getVal();
    std::string getDiv();
    std::string getEsc();
    std::string getPa();
    int getA();
    std::string toString();
};

#endif