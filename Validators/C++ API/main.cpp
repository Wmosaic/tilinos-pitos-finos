#include <iostream>
#include <filesystem>
#include <vector>
#include "CCap.h"
namespace fs = std::filesystem;
using namespace std;

int main() {
    CCap Cap;

    int n;
    string p;
    string fecha;
    string d;
    string l;
    fs::path f;

    const int aux = 7;

    switch (aux){
        case 1:
            n = Cap.capInt("Ingrese un numero: ", 2);
            cout << "El numero capturado es: " << n << endl;
            break;
        case 2:
            p = Cap.capNom("Ingresa una palabra en el formato dd/mm/yyyy: ");
            cout << "La palabra ingresada es: " << p << endl;
            break;
        case 3:
            fecha = Cap.capDate("Ingrese una fecha: ");
            cout << "La fecha ingresada es: " << fecha << endl;
            break;
        case 4:
            d = Cap.capDir("Ingresa un Directorio: ");
            cout << "El Directorio ingresado es valido: \n" << d << endl;
            break;
        case 5:
            f = Cap.capFile("Selecciona un Archivo: ",
                            R"(C:\Users\EnrickMC\Desktop\POO\Lista_Articulo Python)",
                            ".csv");
            cout << "El archivo es: \n" << f << endl;
            break;
        case 6:
            f = Cap.capFile("Selecciona un Archivo: ",
                            ".csv");
            cout << "El archivo es: \n" << f << endl;
            break;
        case 7:
            vector<string> opciones= {"Kg (Kilogramos)","Lt (Litros)","Cm (Centimetros)","U (Unidades)","T (Toneladas)"};
            l = Cap.capList("Selecciona una opción:", opciones);
            cout << "La opción seleccionada es: " << l << endl;
            break;
    }
    return 0;
}
