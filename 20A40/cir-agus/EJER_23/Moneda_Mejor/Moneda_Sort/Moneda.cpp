# include <iostream>
# include <string>
# include "Moneda.h"

using namespace std;

Moneda::Moneda(){}

Moneda::Moneda(double newVal, int newAño, string newDiv, string newPai, string newEsc)
{
    this -> divisa = newDiv;
    this -> valor = newVal;
    this -> escudo = newEsc;
    this -> año = newAño;
    this -> pais = newPai;
}

bool Moneda::setValor(double v)
{
    if (v > 0){
        valor = v;
        return true;
    } else return false;
}

bool Moneda::setDivisa(string d)
{
    if (d.length() > 0){
        divisa = d;
        return true;
    } else return false;
}

bool Moneda::setEscudo(string e)
{
    if (e.length() > 0){
        escudo = e;
        return true;
    } else return false;
}

bool Moneda::setPais(string p)
{
    if (p.length() > 0){
        pais = p;
        return true;
    } else return false;
}

bool Moneda::setAño(int a)
{
    if (a > 0){
        año = a;
        return true;
    } else return false;
}

double Moneda::getValor(){ return valor; }
string Moneda::getDivisa(){ return divisa;}
string Moneda::getEscudo(){ return escudo;}
string Moneda::getPais(){ return pais; }
int Moneda::getAño(){return año;}

string Moneda::toString()
{
    string cade = "La divisa "+divisa;
    cade += "El escudo: "+escudo;
    cade += "El pais: "+pais;
    cade += "El valor: "+to_string(valor);
    cade += "El año: "+to_string(año);
    return cade; 
}