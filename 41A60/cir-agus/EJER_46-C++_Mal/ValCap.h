#ifndef VALCAP_H
#define VALCAP_H
#include <string>

/*
 * He hecho algunos de estos validadores usando expresiones regulares
 * es un metodo que no hemos usado antes asi que hay que tener cuidado,
 * no he testeado aun ninguna funcion, pero creo que deberian funcionar
 * de forma adecuada, eres libre de hacer cambios a tu discrecion.
 * -Mosaic
 */


class ValCap {
    public:
        bool isNum(std::string prueba);
        bool isNom(std::string prueba);
        bool isDate(std::string prueba);
        bool isDir(std::string prueba);

        bool stringVal(std::string prueba);

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

        bool csvVal(std::string ruta); // Trabajo en proceso, ya existe la declaracion de 
                                       // la funcion pero no esta completo el algoritmo.
};
#endif
