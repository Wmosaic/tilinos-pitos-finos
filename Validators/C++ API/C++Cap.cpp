#include "CCap.h"
#include <iostream>
#include <vector>
#include <filesystem>
namespace fs = std::filesystem;
using namespace std;

CCap::CCap() : cVal(){}
CCap::CCap(CVal val){    this-> cVal = val;    }
CCap::~CCap()= default;

    /**Método para capturar solamente números enteros*/
    int CCap::capInt(string mensaje) {
    string aux;
    cout << mensaje << endl;
    getline(cin, aux);

    while (!cVal.isNum(aux)) {
        cout << "Solo se admiten numeros." << endl;
        getline(cin, aux);
    }
    return stoi(aux);
}

    /**Método para capturar solamente números enteros con un limite determinado*/
    int CCap::capInt(string mensaje, int lim){
        int aux = capInt(mensaje);

        while(aux <= lim){
            aux = capInt(mensaje + "(No menor a " + to_string(lim) + ") ");
        };
        return aux;
    }

    /**Método para capturar solamente números enteros dentro de un rango determinado*/
    int CCap::capInt(string mensaje, int limI, int limS){
        int aux = capInt(mensaje);

        while (aux < limI || aux > limS){
            aux = capInt(mensaje + "(Entre " + to_string(limI) + " y " + to_string(limS) + ") ");
        };
        return aux;
    }

    /**Método para capturar solamente números racionales*/
    double CCap::capReal(string mensaje){
        string aux;
        cout << mensaje << endl;
        getline(cin, aux);

        while(!cVal.isNum(aux)){
            cout << "Solo se admiten numeros." << endl;
            getline(cin, aux);
        }
        return stod(aux);
    }

    /**Método para capturar solamente números racionales con un limite determinado*/
    double CCap::capReal(string mensaje, int lim){
        double aux = capReal(mensaje);

        while(aux <= lim){
            aux = capReal(mensaje + "(No menor a " + to_string(lim) + ") ");
        };
        return aux;
    }

    /**Método para capturar solamente números racionales dentro de un rango determinado*/
    double CCap::capReal(string mensaje, int limI, int limS){
        double aux = capReal(mensaje);

        while (aux < limI || aux > limS){
            aux = capReal(mensaje + "(Entre " + to_string(limI) + " y " + to_string(limS) + ") ");
        };
        return aux;
    }

    /**Método para capturar solamente una cadena de texto*/
    string CCap::capNom(string mensaje){
        string aux;

        cout << mensaje << std::endl;
        getline(cin, aux);

        while(!cVal.isNom(aux)){
            cout << "Solo se admiten cadenas." << endl;
            getline(cin, aux);
        }
        return aux;
    }

    /**Método para capturar una cadena de texto con un límite de caracteres*/
    string CCap::capNom(string mensaje, int limC){
    string aux = capNom(mensaje);;

    while (aux.length() >= limC){
        aux = capNom(mensaje + " (Menor a " + to_string(limC) + " Caracteres)");
    };
    return aux;
}

    /** Método para capturar una fecha*/
    string CCap::capDate(string mensaje){
    string aux;

    cout << mensaje << "\n";
    getline(cin, aux);
    while (!cVal.isDate(aux)){
        cout << mensaje << "\n";
        getline(cin, aux);
    }
    return aux;
}

    /** Método para capturar un directorio*/
    string CCap::capDir(string mensaje) {
        string aux;

        cout << mensaje << std::endl;
        getline(cin, aux);

        while (!cVal.isDir(aux)) {
            cout << mensaje << endl;
            getline(cin, aux);
        }
        return aux;
}

    /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * -Directorio y extension validados, responsabilidad del programador*/
    fs::path CCap::capFile(string mensaje, string extension) {

        string directorio = capDir("Ingresa un Directorio: ");
        vector<string> archivosFiltrados;

        for (const auto &entry: fs::directory_iterator(directorio)) {
            if (entry.path().extension() == extension) {
                archivosFiltrados.push_back(entry.path().filename().string());
            }
        }
        string l = capList("Selecciona una opción:", archivosFiltrados);

        return fs::path(directorio) / l;
    };

    /**-Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * -Directorio y extension validados, responsabilidad del programador*/
    fs::path CCap::capFile(string mensaje, string directorio, string extension) {

        vector<string> archivosFiltrados;

        for (const auto& entry : fs::directory_iterator(directorio)) {
            if (entry.path().extension() == extension) {
                archivosFiltrados.push_back(entry.path().filename().string());
            }
        }
        string l = capList("Selecciona una opción:", archivosFiltrados);

        return fs::path(directorio) / l;
    };

    /** Método para desplegar una lista usando Vectores*/
    string CCap::capList(string mensaje, vector<string> opciones) {
        for (size_t i = 0; i < opciones.size(); ++i) {
            std::cout << i + 1 << "- " << opciones[i] << std::endl;
        }

        int index = capInt(mensaje, 1, opciones.size());

        return opciones[index - 1];
    };