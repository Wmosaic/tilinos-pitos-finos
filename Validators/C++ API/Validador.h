#ifndef VALIDADOR
#define VALIDADOR

#include <string>

class Validador {
public:
    Validador();
    ~Validador();

    bool isNum  (std::string prueba);
    bool isNom  (std::string prueba);
    bool isDate (std::string prueba);
    bool isDir  (std::string prueba);
    bool isStr  (std::string prueba);
};

#endif
