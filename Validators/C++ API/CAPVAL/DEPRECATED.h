#ifndef VALIDATORS
#define VALIDATORS
#include <string>


class Validators {
    public:
        bool isNum(std::string prueba);
        bool isNom(std::string prueba);
        bool isDate(std::string prueba);
        bool isDir(std::string prueba);
        bool isStr(std::string prueba);

        int capInt(std::string mensaje);
        int capInt(std::string mensaje, const int limite);
        int capInt(std::string mensaje, const int limiteInferior
                                     , const int limiteSuperior);

        double capDouble(std::string mensaje);
        double capDouble(std::string mensaje, const int limite);
        double capDouble(std::string mensaje, const int limiteInferior
                                           , const int limiteSuperior);

        std::string capNom(std::string mensaje);
        std::string capNom(std::string mensaje, const int limiteDeCaracteres);

        std::string stringInverter(std::string origen);

        std::string capDate(std::string mensaje);

        auto getDirs(std::string directorio);

        void printDirs(std::string directorio);

};
#endif
