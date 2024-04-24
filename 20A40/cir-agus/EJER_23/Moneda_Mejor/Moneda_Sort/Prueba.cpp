# include <iostream>
# include <string>
# include <stdlib.h>
# include <tuple>
# include <vector>
# include <algorithm>
# include <fstream>
# include <sstream>
# include "Moneda.h"
# include "Valida.h"

using namespace std;

Moneda M[50] = {};
int control[50];
Valida v = Valida("",0.0,0);

tuple<string*,int> confiDivisas(int lim);

void meta()
{
    cout<<"Capturar y desplegar una lista de monedas"<<endl;
    cout<<"Presentes dentro de un monedero totalizando"<<endl;
    cout<<"las monedas presentes dentro de cada divisas"<<endl;
    cout<<"Programa mejorado para que lea archivos CSV"<<endl;
    cout<<"----------------<<"<<endl;
}

int dataManual()
{
    int cuenta;
    //Moneda* monedero = new Moneda[50];
   
    
    for(cuenta = 0; cuenta < 50; cuenta++)
    {
        Moneda m = Moneda(0.0,0,"","","");
        M[cuenta] = m;
        string div = v.capCad("Capture el nombre de la divisa o fin: ");
        if (v.capCenti(div) == "fin") break;
        M[cuenta].setDivisa(div);
        M[cuenta].setValor(v.capReal("Valor de la moneda: "));
        M[cuenta].setPais(v.capCad("Pais de la moneda: "));
        control[cuenta] = v.capInte("Cuantas veces se repite la moneda?: ");
    }
    cout<<"----------------<<"<<endl;
    return cuenta;   
}

int dataFichero()
{
    int cuenta = 0;
    ifstream archivo("Monedas.csv",ios::in);
    string linea;

    if(!archivo.is_open()){cout << "Salio del programa"; exit(0);}

    getline(archivo,linea);

    while(getline(archivo,linea))
    {
        stringstream var(linea);
        string Divisa, Valor, Pais, Repeticion;
        getline(var,Divisa,',');
        getline(var,Valor,',');
        getline(var,Pais,',');
        getline(var,Repeticion,',');
        M[cuenta] = Moneda(0.0,0,"","","");
        M[cuenta].setDivisa(Divisa);
        M[cuenta].setValor(stod(Valor));
        M[cuenta].setPais(Pais);
        control[cuenta] = stoi(Repeticion);
        cuenta++;
    }

    archivo.close();
    return cuenta;
}

double* calc(string *setDivi,int limSet, int iter)
{
    int dinero = 0;
    double* control_valor = new double[50];

    for (int j = 0; j < limSet; j++)
    {
        dinero = 0;
        for (int i = 0; i < iter; i++)
            if(setDivi[j] == M[i].getDivisa())
                dinero += (control[i] * M[i].getValor());
        
        control_valor[j] = dinero;
    }

    return control_valor; 
}

void salida(int iter, double *con_val, string *SetD, int limS)
{
    for (int i = 0; i < iter; i++)
    {
        cout << "La divisa de la moneda: " << M[i].getDivisa()<<endl;
        cout << "El valor de la moneda: "<<M[i].getValor()<<endl;
        cout << "El pais de la moneda: "<<M[i].getPais()<<endl;
        cout << "Hubo un total de: "<< control[i]<<" Monedas"<<endl;
        cout <<"----------------<<"<<endl;
    }

    for(int j = 0; j < limS; j++ ) //La salida que sale en orden alfabetico por el vector previamente modificado con Sort
         cout << "La divisa "<<SetD[j]<<": "<<con_val[j]<<endl;
     
    delete[] SetD;
    delete[] con_val;
    cout<<"----------------<<"<<endl;
}

int main(int argc, char const *argv[])
{
    int opc , r = 0;
    char AFF = 's';
    
    //g++ Prueba.cpp Moneda.cpp Valida.cpp Moneda.h Valida.h
    while (AFF == 'S' || AFF == 's')
    {
        system("cls");
        meta();
        opc = v.capInte("Capture su opcion 1-Tradicional/ 2-Fichero: ");
        switch (opc)
        {
        case 1:
        {
        r = dataManual(); break;
        }
        case 2:
        {
         r = dataFichero(); break;
        }
        default: continue;  break;
        }
        tuple<string*, int>(divS) = confiDivisas(r);
        double *array_valo = calc(get<0>(divS), get<1>(divS), r);
        salida(r,array_valo,get<0>(divS),get<1>(divS));
        cout <<"Desea otra tirada de monedas[S/N]? ";
        cin >> AFF;
    } 
    return 0;

}

tuple<string*,int> confiDivisas(int lim){
    int limite_Set = 0;
    string* Setdivisas = new string[50];
    //Copias todos los elementos en un nuevo arreglo divisas
    for (int i = 0; i < lim; i++) 
        Setdivisas[i] = M[i].getDivisa();
    //Convierte el arrglo de tipo a string a un vector
    vector<string> Vec_divisa(Setdivisas, Setdivisas + lim);
    //Utiliza el metodo sort para ordenar
    sort(Vec_divisa.begin(), Vec_divisa.end()); 
    /*Regresa el iterador de los elementos repetidos ya previamente movidos hacia atras y con 
    erase borra esos elemntos con el segundo parametro indicando los elementos ya apartados
    */
    Vec_divisa.erase(unique(Vec_divisa.begin(),Vec_divisa.end()), Vec_divisa.end());
    
    for(const auto& Div: Vec_divisa)
    {
        Setdivisas[limite_Set] = Div;
        limite_Set++;
    }
    return make_tuple(Setdivisas,limite_Set);
}
