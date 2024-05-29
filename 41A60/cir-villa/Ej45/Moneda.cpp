#include "Moneda.h"

typedef std::string cadena;

Moneda::~Moneda(){}

Moneda::Moneda(){}

Moneda::Moneda(double val, int dat, cadena esc, cadena pai, cadena div) :
    valor(val), fecha (dat), escudo (esc), pais (pai), divisa (div){}

bool Moneda::setValor(double val){
    if (!(val >= 0)) return false;
    this->valor = val;
}

bool Moneda::setFecha(int dat){
    if (!(dat >= 0)) return false;
    this->valor = dat;
}

bool Moneda::setEscudo(cadena esc){
    if(!(val->isStr(esc))) return false;
    this->escudo = esc;
}

bool Moneda::setPais(cadena pai){
    if(!(val->isStr(pai))) return false;
    this->pais = pai;
}

bool Moneda::setDivisa(cadena div){
    if(!(val->isStr(div))) return false;
    this->divisa = div;
}

double Moneda::getValor() {    return this->valor;    }
int Moneda::getFecha()    {    return this->fecha;    }
cadena Moneda::getEscudo(){    return this->escudo;   }
cadena Moneda::getPais()  {    return this->pais;     }
cadena Moneda::getDivisa(){    return this->divisa;   }

cadena Moneda::toString(){
    cadena concat {
        "Valor: " + std::to_string(valor) + "\tAño: " + std::to_string(fecha)
        + "\t Escudo: " + escudo + "\tPais: " + pais + "\tDivisa :" + divisa 
    };
}
