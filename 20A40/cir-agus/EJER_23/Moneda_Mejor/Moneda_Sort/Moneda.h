# include <string>
# ifndef MONEDA_H
# define MONEDA_H

using namespace std;

class Moneda
{
private:
    double valor;
    int año;
    string divisa,pais,escudo;
public:
   Moneda();
   Moneda(double newVal, int newAño, string newDiv, string newPai, string newEsc);
   bool setValor(double v);
   bool setDivisa(string d);
   bool setEscudo(string e);
   bool setPais(string p);
   bool setAño(int a);
   //Inicio de los getteres
   double getValor();
   string getDivisa();
   string getEscudo();
   string getPais();
   int getAño();
   string toString();
};
# endif



