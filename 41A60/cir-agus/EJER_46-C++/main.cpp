# include "Moneda.h"
# include "ValCap.h"
# include <iostream>
# include <string>
# include <cctype>
# include <stdlib.h>
# include <vector>
# include <tuple>
# include <fstream>
# include <sstream>
# include <filesystem>

//Liberar espacio reservado de los apuntadores
const std::string myDir = "ParaClaseMoneda";
Moneda* Monedas = new Moneda[100];
int* Repeticion = new int[100];
ValCap* Cap = new ValCap();

string aLower(const std::string& str);

void meta()
{
    std::cout<<"Capturar y desplegar una lista de monedas"<<std::endl;
    std::cout<<"Presentes dentro de un monedero totalizando"<<std::endl;
    std::cout<<"las monedas presentes dentro de cada divisas"<<std::endl;
    std::cout<<"Programa mejorado para que lea archivos CSV"<<std::endl;
    std::cout<<"Guardando los datos y le reporte generado en un archivo"<<std::endl;
    std::cout<<"----------------<<"<<std::endl;
}

int dataManual()
{
    std::string div,esc,pai;
    double val;
    int cuenta = 0,año,rep;
    std::cout<<"Capture los datos de la moneda"<<std::endl;

    div = Cap ->capNom("Deme el nombre de la divisa o fin: ",40);
    while(!(aLower(div)=="fin") || cuenta < 100)
    {
        val = Cap ->capDouble("Deme el valor: ",1.0);
        esc = Cap ->capNom("Deme el nombre del escudo: ",40);
        año = Cap ->capInt("Deme el año: ",1);
        pai = Cap ->capNom("Deme el pais al que pertenece: ",40);
        rep = Cap ->capInt("Cuantas monedas son?: ",1);
        Monedas[cuenta] = Moneda(val,año,div,pai,esc);
        Repeticion[cuenta] = rep;
        cuenta++;
        div = Cap ->capNom("Deme el nombre de la divisa o fin: ",40);
    }
     
    return cuenta;   
}

int dataFichero()
{
    std::string linea;
    std::vector<filesystem::path> misDir;
    int cuenta = 0,ind;
    
    misDir = Cap ->getDirs(myDir);
    if(misDir.size() == 0){ cout << "No vales madre"<<endl; exit(0); }
    for(size_t i = 0; i < misDir.size(); i++) cout << i+1<<misDir[i] << endl;
    
    ind = Cap ->capInt("Seleccione su archivo por numero: ",1,myDir.size());
    
    std::ifstream archivo(misDir[ind-1],ios::in);
    if(!archivo.is_open()){cout << "Salio del programa"; exit(0);}

    getline(archivo,linea);

    while(getline(archivo,linea))
    {
        std::stringstream var(linea);
        std::string Divisa, Valor, Pais, Repeticion;
        getline(var,Divisa,',');
        getline(var,Valor,',');
        getline(var,Pais,',');
        getline(var,Repeticion,',');
        Monedas[cuenta] = Moneda(0.0,0,"","","");
        Monedas[cuenta].setDivisa(Divisa);
        Monedas[cuenta].setValor(stod(Valor));
        Monedas[cuenta].setPais(Pais);
        Repeticion[cuenta] = stoi(Repeticion);
        cuenta++;
    }
    delete[] Monedas;
    delete[] Repeticion;
    delete[] Cap;
    archivo.close();
    return cuenta;
}
/*
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
*/

int main(int argc, char const *argv[])
{
    //g++ main.cpp Moneda.cpp ValCap.cpp Moneda.h ValCap.h
    int sexo = dataFichero();
    cout << sexo;
    return 0;
}

string aLower(const std::string& str)
{
    std::string miMinuscula = str;
    for(char& c: miMinuscula){
        c = tolower(static_cast<unsigned char>(c));
    }
    return miMinuscula;
}