#include <iostream>
#include <filesystem>
#include <vector>
#include "utilFilesCpp/CCap.h"
#include "utilFilesCpp/Miscellaneous.h"

namespace fs = std::filesystem;
using namespace std;
CppCap Cap;
Miscellaneous Mis;


void testCppCap(int aux);
void testMiscellaneous(int aux);

int main() {
    testCppCap(0);
    testMiscellaneous(0);
    return 0;
}

void testCppCap(int aux){

    string s;
    int x1, x2, x3;
    double y1, y2, y3;
    string n1, n2;
    string d;
    string c;
    vector<fs::path> f1;
    fs::path f2, f3;
    string o1, o2;

    switch (aux){
        case 0:
            //cap Genérico
            s = Cap.cap("mensaje");
            Cap.trim(s);
            cout << s << endl;
            break;
        case 1:
            //capInt
            x1 = Cap.capInt("Entero");
            //capInt Limite
            x2 = Cap.capInt("Entero, Lim?", 0);
            //capInt Rango
            x3 = Cap.capInt("Entero, LimI?, LimS?", 0, 10);
            cout << x1 + x2 + x3 << endl;
            break;
        case 2:
            //capReal
            y1 = Cap.capReal("Real");
            //capReal Limite
            y2 = Cap.capReal("Real, Lim?", 0);
            //capReal Rango
            y3 = Cap.capReal("Real, LimI?, LimS?", 0, 1);
            cout << y1 + y2 + y3 << endl;
            break;
        case 3:
            //capNom
            n1 = Cap.capNom("Cadena");
            //capNom Limite
            n2 = Cap.capNom("Cadena, LimC?", 10);
            cout << n1 + n2 << endl;
            break;
        case 4:
            //capDate
            d = Cap.capDate("Fecha");
            cout << d << endl;
            break;
        case 5:
            //capDir
            c = Cap.capDir("Directorio");
            cout << c << endl;
            break;
        case 6:
            //capFile Genérico
            f1 = Cap.capFile(".csv"); for (const auto& archivo : f1) {cout << archivo.string() << endl;}
            //capFile sin Directorio
            f2 = Cap.capFile("mensaje, Extension",".csv");
            cout << f2 << endl;
            //capFile con Directorio
            f3 = Cap.capFile("mensaje, Directorio, Extension",R"(C:\Users\EnrickMC\Desktop\POO\ArchivosPrueba)",".csv");
            cout << f3 << endl;
            break;
        case 7:
            vector<string> opciones = {"Opción A", "Opción B", "Opción C", "Opción D"};
            //capList
            o1 = Cap.capList("Lista, Opciones", opciones);
            //capList
            o2 = Cap.capList("Lista, Opciones", vector<string>{"Opción A", "Opción B", "Opción C", "Opción D"});
            cout << o1 + o2 << endl;
            break;
    }
}

void testMiscellaneous(int aux) {
    string datos = "Dato 1, Dato 2, Dato 3";
    string a1;
    vector<string> a2;
    string Date;

    switch (aux) {
        case 0:
            //writeFile
            Mis.writeFile(datos, filesystem::current_path() / "Nombre_Archivo.csv", true);
            break;
        case 1:
            //readFile Especifico
            a1 = Mis.readFile(1, filesystem::current_path() / "Nombre_Archivo.csv");
            cout << a1 << endl;
            //readFile Completo
            a2 = Mis.readFile(filesystem::current_path() / "Nombre_Archivo.csv");
            for (const auto& archivo : a2) {cout << archivo << endl;}
            break;
        case 2:
            //convertDate
            Date = Mis.convertDate(Cap.capDate("Fecha"));
            cout << Date << endl;
            break;
    }
}