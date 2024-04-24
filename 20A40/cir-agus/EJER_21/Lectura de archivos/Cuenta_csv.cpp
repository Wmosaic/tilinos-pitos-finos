# include <iostream>
# include <stdlib.h>
# include <string>
# include <tuple>
# include <fstream>
# include <sstream>
# include "Articulo.h"
# include "Valida.h"

using namespace std;

Articulo lisArti[50] = {};
Valida v = Valida("",0.0,0);

void meta()
{
    cout << "Capturar y desplegar en pantalla la lista del mandado" <<endl;
    cout << "Permitir al usuario abrir archivos de tipo CSV" <<endl;
    cout << "La lista del mandado puede contener n articulos" <<endl;
    cout << "--------------------" <<endl;
}

int data_Tradicional()
{
    int cuenta;
   
    for (cuenta = 0; cuenta < 50; cuenta++ )
    {
        Articulo a = Articulo("","",0.0,0.0);
        lisArti[cuenta] = a;
        string des = v.capCad("Descripcion/fin: ");
        if (v.capCenti(des) == "fin") break;
        lisArti[cuenta].setDescripcion(des);
        lisArti[cuenta].setUnidad(v.capCad("Unidad: "));
        lisArti[cuenta].setCantidad(v.capReal("Cantidad: "));
        lisArti[cuenta].setPrecio(v.capReal("Precio: "));
    }
     cout << "--------------------" <<endl;
    return  cuenta;
}

int leerCSV()
{
    int cuenta = 0;
    ifstream archivo("Lista.txt",ios::in);
    string linea;

    if(!archivo.is_open()){ cout <<"Salio"; exit(0); }
    getline(archivo,linea);

    while(getline(archivo,linea))
    {
        stringstream var(linea);
        string Descripcion, Unidad, Cantidad, Precio;
        getline(var,Descripcion,',');
        getline(var,Unidad,',');
        getline(var,Cantidad,',');
        getline(var,Precio,',');
        lisArti[cuenta] = Articulo("","",0.0,0.0);
        lisArti[cuenta].setDescripcion(Descripcion);
        lisArti[cuenta].setUnidad(Unidad);
        lisArti[cuenta].setCantidad(stod(Cantidad)); //stod metodo que str lo convierte a double
        lisArti[cuenta].setPrecio(stod(Precio));
        cuenta++;
    }
    archivo.close(); 
    return cuenta;   
}

tuple<double*,double,double> calculos(int limite)
{
    double* monto = new double[50];
    double  subtotal = 0,total = 0;

    for (int i = 0; i < limite; i++)
    {
        monto[i] = (lisArti[i].getCantidad() * lisArti[i].getPrecio());
        subtotal += monto[i];
    }
    total = subtotal + (subtotal * 0.16);

    return make_tuple(monto,subtotal,total);
}

void salida(int limite,double *monto, double subtotal, double total)
{
    cout<<"Su compras son: "<<endl;
    cout <<"---------------"<<endl;
    for(int i = 0; i < limite; i++)
    {
        cout << lisArti[i].toString() << endl;
        cout <<"El monto de su compra: "<<monto[i] <<endl;
        cout << "--------------------" <<endl;
    }
    cout << "El subtotal de su compra es: "<<subtotal<<endl;
    cout << "El total de su compra(%IVA) es: "<<total<<endl;
    delete[] monto;
}

int main(int argc, char const *argv[])
{
    //g++ Cuenta_csv.cpp Valida.h Valida.cpp Articulo.h Articulo.cpp -o Prueba
    
    int opc, cap;
    
    char AFF = 'S';
    while(AFF == 'S' || AFF == 's')
    {
        system("cls");
        meta();
        opc = v.capInte("Eliga su opcion 1-Manual / 2-Por CSV: ");
        switch (opc)
        {
            case 1: cap = data_Tradicional(); break;
            case 2: cap = leerCSV(); break;
            default: cout << "Seleccione una opcion valida"; continue; break;
        }
        tuple<double*,double,double> resul = calculos(cap);
        salida(cap,get<0>(resul),get<1>(resul),get<2>(resul));
        cout << "Otras capturas [S/N]: ";
        cin >> AFF;
    }
    return 0;
    
}




