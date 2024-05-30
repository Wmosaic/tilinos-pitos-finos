#include "Validador.h"
#include "REGEX_FECHA.h"
#include <regex>
#include <typeinfo>
#include <cctype>

Validador::Validador(){}
Validador::~Validador(){}

bool Validador::isNumI(std::string& prueba){
    try{
        int x{std::stoi(prueba)};
        return true;
    }
    catch(...){    return false;    }
    
}

bool Validador::isNumD(std::string& prueba){
    try{
        int x{std::stoi(prueba)};
        return true;
    }
    catch(...){    return false;    }
    
}
 
bool Validador::isNom(std::string& prueba){
    std::basic_regex<char> patron {"^( )+$"};

    if (prueba.length() != 0){
        for(const char& letra : prueba)
            if (!(isalpha(letra) || isspace(letra)))
                return false;
    } else return false;

    return !std::regex_match(prueba, patron);
}

bool Validador::isDate(std::string& prueba){
    std::basic_regex<char> patronRegex{PATRON_FECHA};
    return std::regex_match(prueba, patronRegex);
}

bool Validador::isStr(std::string& prueba){
    const std::string tipo {
        "NSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE"
        };
    // Este es el identificador interno para el tipo std::string
    // puede variar entre compiladores, lo que convierte esta funcion
    // inestable. Tratar con cuidado si se compila en gcc.

    if (typeid(prueba).name() != tipo)
        return false;

    return prueba.length() != 0;
}
