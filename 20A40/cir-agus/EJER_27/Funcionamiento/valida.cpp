#include <iostream>
#include <string.h>

using namespace std;

bool isNum(string cad) 
{  try 
   {  double d = stod(cad);
      return true;
   } catch(...) 
     {  cout <<endl<<"Solo se admiten numeros"<<endl;
        return false;
     }
}

double capReal(string prompt) 
{  char aux[20];
   //validacion de formato
   do 
   {  cout << prompt;
      cin >> aux;
      //gets(aux, sizeof(aux), stdin);
   } while(!isNum(aux));
   return atof(aux);
}

