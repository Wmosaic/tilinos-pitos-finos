
# include <iostream>
# include <math.h>
# include <string.h>
# include <stdlib.h>
# include "Point.h"

using namespace std;
Point uno = Point(0.0,0.0);
Point dos = Point(0.0,0.0);
double d;
double capReal(string);

void META()
{
    cout<<"Programa que calcula la distancia entre dos puntos.";
    cout<<"\n-------------------------------------------------\n";
}

void DATA(string pos, Point *apuntador)
{
    cout<<"Captura de datos."<<endl;
    string VX = "Cordenada X "+pos+": ";
    string VY = "Cordenada Y "+pos+": ";

    apuntador -> setX(capReal(VX));
    apuntador -> setY(capReal(VY));
    cout<<"Los datos capturados son: "<<endl;
    cout<<"("<<apuntador -> getX()<<","<<apuntador -> getY()<<")";
    cout<<"\n-------------------------------------------------\n";
}

void CALCULOS()
{
    double x_1,y_1,x_2,y_2; 
    x_1 = uno.getX();
    y_1 = uno.getY();
    x_2 = dos.getX();
    y_2 = dos.getY();
    d = sqrt(pow((x_2-x_1),2) + pow((y_2-y_1),2));
}

void RESULTADOS()
{
    cout<<"Dado el punto 1: "<<uno.toString()<<endl;
    cout<<"Dado el punto 2: "<<dos.toString()<<endl;
    cout<<"La distancia entre ellos es de: "<<d;
    cout<<"\n-------------------------------------------------\n";
}

int main(int argc, char const *argv[])
{
    //g++ distancia.cpp Point.cpp Point.h valida.cpp
   char AFF = 'S'; 

    while(AFF == 'S' || AFF == 's')
    {
        system("cls");
        META();
        DATA("1",&uno);
        DATA("2",&dos);
        CALCULOS();
        RESULTADOS();
        cout<<"\n";
        cout<<"Desea capturar otros datos?[S/N] ";
        cin>>AFF;
    }    
    return 0;
}

