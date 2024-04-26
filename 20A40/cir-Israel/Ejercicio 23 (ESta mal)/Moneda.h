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
    // Métodos de configuración
    bool setValor(double Val);
    bool setDivisa(std::string Div);
    bool setEscudo(std::string Esc);
    bool setPais(std::string Pa);
    bool setAño(int A);

    // Métodos de obtención
    double getValor();
    std::string getDivisa();
    std::string getEscudo();
    std::string getPais();
    int getAño();

    std::string toString();
};

#endif // MONEDA_H