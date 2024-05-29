#include "Validador.h"
#include "REGEX_FECHA.h"
#include <regex>
#include <chrono>
#include <filesystem>
#include <typeinfo>

namespace fs = std::filesystem;

Validador::Validador(){}
Validador::~Validador(){}

bool Validador::isNumI(std::string prueba){
    try{
        int x{std::stoi(prueba)};
        return true;
    }
    catch(...){    return false;    }
    
}

bool Validador::isNumD(std::string prueba){
    try{
        int x{std::stoi(prueba)};
        return true;
    }
    catch(...){    return false;    }
    
}

bool Validador::isNom(std::string prueba){
    std::string patron{"^(([A-Za-z]?)| )+$"};
    std::basic_regex<char> patronRegex{patron};

    return std::regex_search(prueba, patronRegex) 
            && (prueba.length() != 0 )
            && prueba != "" || " ";
}

bool Validador::isDate(std::string prueba){

    std::string patron{PATRON_FECHA};

    std::basic_regex<char> patronRegex{patron};
    return std::regex_search(prueba, patronRegex);
}

bool Validador::isStr(std::string prueba){
    const decltype(prueba) tipo{prueba};  // Esta linea declara la variable 
    if (typeid(prueba).name() != tipo)    // tipo como el mismo tipo de 
        return false;                     // declaracion que la var prueba
    return prueba.length() != 0;          // y se compara con el metodo
                                          // typeid, que regresa el tipo
}                                         // de la variable dada
