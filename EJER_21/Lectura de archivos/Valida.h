# include <string>
# ifndef VALIDA_H
# define VALIDA_H

using namespace std;

class Valida
{
private:
    string cadena_general;
    double valor_decimal;
    int valor_entero;
    bool isNum(string cad);
    bool isCad(string cad);
public:
    Valida();
    Valida(string newCad, double newDeci, int newInte);
    double capReal(string argumento);
    int capInte(string argumento);
    string capCad(string argumento);
     string capCenti(string cade);
};

# endif