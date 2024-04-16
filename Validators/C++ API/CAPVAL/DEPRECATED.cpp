#include "DEPRECATED.h"
#define VALIDATORS
#include <string>
#include <regex>
#include <iostream>
#include <vector>
#include <filesystem>

namespace fs = std::filesystem;


bool isNum(std::string prueba){
    std::string patron{"^\d+(\.\d+)?$"};
    std::basic_regex<char> patronRegex{patron};

    return std::regex_search(prueba, patronRegex);
}

bool isNom(std::string prueba){
    std::string patron{"^[^\d]+$"};
    std::basic_regex<char> patronRegex{patron};

    return std::regex_search(prueba, patronRegex);
}

bool isDate(std::string prueba){
    std::string patron{"^\d{2}(/|-|\.|_)\d{2}(/|-|\.|_)\d{4}$"};
    std::basic_regex<char> patronRegex{patron};

    return std::regex_search(prueba, patronRegex);
}

bool isDir(std::string prueba){    return fs::is_directory(prueba);   }

bool stringVal(std::string prueba){    return prueba.empty();    }

int capInt(std::string mensaje){
    char aux[100];

    std::cout << mensaje << "\n";
    std::cin >> aux;
    while (!isNum(aux)){
        std::cout << mensaje << "\n";
        std::cin >> aux;
    }
    return atoi(aux);
}

int capInt(std::string mensaje, const int limite){
    char aux[100];

    std::cout << mensaje << "\n";
    std::cin >> aux;
    do{
        while (!isNum(aux)){
            std::cout << mensaje <<"\n";
            std::cin >> aux;
        }
        if (atoi(aux) <= limite) 
            std::cout << "El valor debe ser mayor a " << limite <<".\n";
        } while (atoi(aux)<= limite);
    return atoi(aux);
}

int capInt(std::string mensaje, const int limiteInferior
                              , const int limiteSuperior){
    char aux[100];

    std::cout << mensaje << "\n";
    std::cin >> aux;
    do{
        while (!isNum(aux)){
            std::cout << mensaje <<"\n";
            std::cin >> aux;
        }
        if (atoi(aux) <= limiteInferior || atoi(aux) >= limiteSuperior)
            std::cout << "El valor estar entre " << limiteInferior
                      << " y " << limiteSuperior << ".\n";
    } while (atoi(aux)<= limiteInferior || atoi(aux) >= limiteSuperior);
    return atoi(aux);
}

double capDouble(std::string mensaje){
    char aux[100];

    std::cout << mensaje << "\n";
    std::cin >> aux;
    while (!isNum(aux)){
        std::cout << mensaje << "\n";
        std::cin >> aux;
    }
    return atof(aux);
}

double capDouble(std::string mensaje, const int limite){
    char aux[100];

    std::cout << mensaje << "\n";
    std::cin >> aux;
    do{
        while (!isNum(aux)){
            std::cout << mensaje <<"\n";
            std::cin >> aux;
        }
        if (atof(aux) <= limite) 
            std::cout << "El valor debe ser mayor a " << limite <<".\n";
    } while (atof(aux)<= limite);
    return atof(aux);
}

double capDouble(std::string mensaje, const int limiteInferior
                                    , const int limiteSuperior){
    char aux[100];

    std::cout << mensaje << "\n";
    std::cin >> aux;
    do{
        while (!isNum(aux)){
            std::cout << mensaje <<"\n";
            std::cin >> aux;
        }
        if (atof(aux) <= limiteInferior || atof(aux) >= limiteSuperior)
            std::cout << "El valor estar entre " << limiteInferior
                      << " y " << limiteSuperior << ".\n";
    } while (atof(aux)<= limiteInferior || atof(aux) >= limiteSuperior);
    return atof(aux);    
}

std::string capNom(std::string mensaje){
    std::string aux;

    std::cout << mensaje << "\n";
    std::getline(std::cin, aux);
    while (!isNom(aux)){
        std::cout << mensaje << "\n";
        std::getline(std::cin, aux);
    }
}

std::string capNom(std::string mensaje, const int limiteDeCaracteres){
    std::string aux;

    std::cout << mensaje << "\n";
    std::getline(std::cin, aux);
    do{
        while (!isNom(aux)){
            std::cout << mensaje << "\n";
            std::getline(std::cin, aux);
        }
        if (aux.length() >= limiteDeCaracteres)
            std::cout << "La cadena debe tener longitud menor a: "
                      << limiteDeCaracteres << ".\n";
    } while (aux.length() >= limiteDeCaracteres);
    return aux;
}

std::string stringInverter(std::string origen){
    std::string aux{""};
    for (int i{origen.length() - 1}; i >= 0; i--)
        aux += origen[i];
    return aux;
}

std::string capDate(std::string mensaje){
    std::string aux{""};

    std::cout << mensaje << "\n";
    std::getline(std::cin, aux);
    while (!isDate(aux)){
        std::cout << mensaje << "\n";
        std::getline(std::cin, aux);
    }
    return aux;
}

auto getDirs(std::string directorio){
    std::vector<fs::path> dirs;
    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
        return dirs;
    }
    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta)){
        dirs.push_back(arch.path());
    }
    return dirs;
}

void printDirs(std::string directorio){
     if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
    }
    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta))
        std::cout << arch.path() << "\n";
}

bool csvVal(std::string ruta); // Trabajo en proceso, ya existe la declaracion de 
                               // la funcion pero no esta completo el algoritmo.
