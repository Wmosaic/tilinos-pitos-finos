#ifndef VALIDATORS
#define VALIDATORS
#include <string>

class Validators {
    public:
        bool isNum(std::string prueba);
        bool isNom(std::string prueba);
        bool isDate(std::string prueba);
        bool isDir(std::string prueba);
        bool stringVal(std::string prueba);
        bool csvVal(std::string ruta);
        int capInt(std::string mensaje);
        int capInt(std::string mensaje, int limite);
        int capInt(std::string mensaje, int limiteInferior
                                     , int limiteSuperior);

        double capDouble(std::string mensaje);
        double capDouble(std::string mensaje, int limite);
        double capDouble(std::string mensaje, int limiteInferior
                                           , int limiteSuperior);
        std::string capString(std::string mensaje);
        std::string capString(std::string mensaje, int limiteDeCaracteres);
        std::string stringInverter(std::string origen);
        std::string capDate(std::string mensaje);
        void printDirs(std::string directorio);
};
#endif
