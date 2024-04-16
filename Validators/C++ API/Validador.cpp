#include "Validador.h"
#include <regex>
#include <filesystem>
#include <typeinfo>

namespace fs = std::filesystem;

bool Validador::isNum(std::string prueba){
    try{
        int x{stod(prueba)};
        return true;
    }
    catch(...){    return false;    }
    
}

bool Validador::isNom(std::string prueba){
    std::string patron{"^(([A-Za-z]?)| )+$"};
    std::basic_regex<char> patronRegex{patron};

    return std::regex_search(prueba, patronRegex) && (prueba.length() != 0);
}

bool Validador::isDate(std::string prueba){

    //No se que hacer con el patron regex xd como lo recorto
    std::string patron{"^(0?[1-9]|[12][0-9]|3[01])(/|-|\\.|_)(0?[1-9]|1[0-2])(/|-|\\.|_)(\\d{4})$"};

    std::basic_regex<char> patronRegex{patron};
    return std::regex_search(prueba, patronRegex);
}

bool Validador::isDir(std::string prueba){    return fs::is_directory(prueba);   }

bool Validador::isStr(std::string prueba){
    const decltype(prueba) tipo{prueba};  // Esta linea declara la variable 
    if (typeid(prueba).name() != tipo)    // tipo como el mismo tipo de 
        return false;                     // declaracion que la var prueba
    return prueba.length() != 0;          // y se compara con el metodo
                                          // typeid, que regresa el tipo
}                                         // de la variable dada
