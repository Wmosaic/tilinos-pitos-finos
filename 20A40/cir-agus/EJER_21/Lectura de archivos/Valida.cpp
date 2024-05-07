# include <iostream>
# include <string>
# include "Valida.h"
//g++ Prueba_vali.cpp Valida.cpp Valida.h
using namespace std;

Valida::Valida(){}

Valida::Valida(string newCad, double newDeci, int newInte)
{    
    this -> cadena_general = newCad;
    this -> valor_decimal = newDeci;
    this ->  valor_entero = newInte;
}

bool Valida::isCad(string cad)
{
    bool vali_cad;
    for (char c: cad)
    {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == 165 || c == 164)
        {
            vali_cad = true;
            cadena_general = cad;
        }
        else
        {
            vali_cad = false;
            break;
        }
    }
    return vali_cad;
}

bool Valida::isNum(string cad)
{
    try
    {
        valor_entero = stoi(cad);
        valor_decimal = stod(cad);
        return true;
    }
    catch(const std::invalid_argument&)
    {
        return false;
       
    }
    catch(const std::exception&)
    {
        return false;
    }
}

string Valida::capCad(string arg)
{
    string aux;
    cout<<arg;
    cin>>aux;
    while (!(isCad(aux)))
    {
        cout<<"Solo se aceptan letras"<<endl;
        cin>>aux;
    }
    return cadena_general;
}

double Valida::capReal(string arg)
{
    string aux;
    cout << arg;
    cin >> aux;
    while (! (isNum(aux)))
    {
        cout<<"Solo se aceptan numeros"<<endl;
        cin >> aux;
    }
    return valor_decimal;
}

int Valida::capInte(string cad)
{
    string aux;
    cout << cad;
    cin >> aux;
    while(!(isNum(aux)))
    {
        cout<<"Solo se aceptan numeros"<<endl;
        cin >> aux;
    }
    return valor_entero;
}

string Valida::capCenti(string cad)
{
    string aux;
    for(char c: cad)
        aux += tolower(c);
    
    cadena_general = aux;

    if(isNum(cad))
        cadena_general = "fin";
    return cadena_general;
}

