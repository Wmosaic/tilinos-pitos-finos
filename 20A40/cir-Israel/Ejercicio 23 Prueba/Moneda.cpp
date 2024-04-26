#include "Moneda.h"
#include <string>

bool Moneda::setValor(double Val) {
    if (Val > 0) {
        Valor = Val;
        return true;
    } else return false;
}

bool Moneda::setDivisa(std::string Div) {
    if (!Div.empty()) {
        Divisa = Div;
        return true;
    } else return false;
}

bool Moneda::setEscudo(std::string Esc) {
    if (!Esc.empty()) {
        Escudo = Esc;
        return true;
    } else return false;
}

bool Moneda::setPais(std::string Pa) {
    if (!Pa.empty()) {
        Pais = Pa;
        return true;
    } else return false;
}

bool Moneda::setAño(int A) {
    if (A > 0) {
        Año = A;
        return true;
    } else return false;
}

double Moneda::getVal() { return Valor; }
std::string Moneda::getDiv() { return Divisa; }
std::string Moneda::getEsc() { return Escudo; }
std::string Moneda::getPa() { return Pais; }
int Moneda::getA() { return Año; }

std::string Moneda::toString() {
    std::string resultado = "Datos ";
    resultado += "Valor: " + std::to_string(Valor) + " ";
    resultado += "Divisa: " + Divisa + " ";
    resultado += "Escudo: " + Escudo + " ";
    resultado += "País: " + Pais + " ";
    resultado += "Año: " + std::to_string(Año) + " ";
    return resultado;
}