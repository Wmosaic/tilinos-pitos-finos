#include "Capturador.h"
#include <iostream>

Capturador::Capturador() {Validador val = this->validator;}

Capturador::Capturador(Validador val) : validator (val) {}

Capturador::~Capturador(){}

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
        } while(limiteSuperior < aux >= limiteInferior);
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
        } while(limiteSuperior < aux >= limiteInferior);
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

std::string Capturador::capDate(std::string mensaje){
    std::string buf;
    std::getline(std::cin, buf);
    while (!validator.isDate(buf) && buf == ""){
        std::cout << mensaje << std::endl;
        std::getline(std::cin, buf);
    }
    return buf;
}

