#include "Capturador.h"
#include <iostream>
namespace fs = std::filesystem;

Capturador::Capturador() : validator(){}

Capturador::Capturador(Validador val){    this-> validator = val;    }

Capturador::~Capturador(){    delete this;    }

int Capturador::capInt(std::string mensaje){
    std::string aux;

    std::cout << mensaje << std::endl;
    std::getline(std::cin, aux);

    while(!validator.isNum(aux)){
        std::cout << "Solo se admiten numeros." << std::endl;
        std::getline(std::cin, aux);
    }
    return std::stoi(aux);
}

int Capturador::capInt(std::string mensaje, int limite){
    int aux;

    do{    aux = capInt(mensaje);    } while(aux >= limite);
    return aux;
}

int Capturador::capInt(std::string mensaje, 
    int limiteInferior, int limiteSuperior){
        int aux;

        do{
            aux = capInt(mensaje);
        } while(limiteSuperior <= aux >= limiteInferior);
        return aux;
}

double Capturador::capReal(std::string mensaje){
    std::string aux;
    std::cout << mensaje << std::endl;
    std::getline(std::cin, aux);

    while(!validator.isNum(aux)){
        std::cout << "Solo se admiten numeros." << std::endl;
        std::getline(std::cin, aux);
    }
    return std::stod(aux);
}

double Capturador::capReal(std::string mensaje, int limite){
    int aux;

    do{    aux = capReal(mensaje);    } while(aux >= limite);
    return aux;
}

double Capturador::capReal(std::string mensaje, 
    int limiteInferior, int limiteSuperior){
        int aux;

        do{    aux = capInt(mensaje);
        } while(limiteSuperior <= aux >= limiteInferior);
        return aux;
}

std::string Capturador::capNom(std::string mensaje){
    std::string aux;
    
    std::cout << mensaje << std::endl;
    std::getline(std::cin, aux);

    while(!validator.isNom(aux)){
        std::cout << "Solo se admiten cadenas." << std::endl;
        std::getline(std::cin, aux);
    }
    return aux;
}

std::string Capturador::capNom(std::string mensaje, int limiteCaracteres){
    std::string aux;
    
    do{
        aux = capNom(mensaje);
    } while (aux.length() >= limiteCaracteres);
    return aux;
}

fs::path Capturador::capDir(){
    std::string auxTest;
    
    std::cout << "Ingrese la ruta al directorio deseado: \n";
    std::getline(std::cin, auxTest);

    while(!validator.isDir(auxTest)){
        std::cout << "Ingrese una ruta valida";
    }
}
