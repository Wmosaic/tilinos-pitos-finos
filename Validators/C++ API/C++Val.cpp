#include "CVal.h"
#include <regex>
#include <filesystem>
#include <iostream>

namespace fs = std::filesystem;
using namespace std;


CVal::CVal(){}
CVal::~CVal()= default;

    bool CVal::isNum(string cadena){
        try {
            double x = stod(cadena);
            return true;
        }
        catch(...) {
            return false;
        }
}

    bool CVal::isNom(string prueba){
    string patron{"^(([A-Za-z]?)| )+$"};
    basic_regex<char> patronRegex{patron};

    return regex_search(prueba, patronRegex) && (prueba.length() != 0);
}

    bool CVal::isDate(string prueba){

    //No se que hacer con el patron regex xd como lo recorto
    string patron{R"(^(0?[1-9]|[12][0-9]|3[01])(/|-|\.|_)(0?[1-9]|1[0-2])(/|-|\.|_)(\d{4})$)"
    };
    basic_regex<char> patronRegex{patron};
    return regex_search(prueba, patronRegex);
}

    bool CVal::isStr(string prueba){
    const decltype(prueba) tipo{prueba};
    if (typeid(prueba).name() != tipo)
        return false;
    return prueba.length() != 0;

}

    bool CVal::isDir(string prueba) {
        if (fs::is_directory(prueba) && !fs::is_regular_file(prueba)) {
            return true;
        } else {
            cout << "El directorio no es valido" << endl;
            return false;
    }
}