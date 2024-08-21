#include "CVal.h"
#include <regex>
#include <filesystem>

using namespace std;
namespace fs = filesystem;


CVal::CVal()= default;
CVal::~CVal()= default;

    /**Método para validar números naturales*/
    bool CVal::isNum(const string& cadena){
        try {
            double x = stod(cadena);
            return true;
        }
        catch(...) {
            return false;
        }
}

    /**Método para validar cadenas de caracteres sin números*/
    bool CVal::isNom(const string& cadena){
    string patron{"^(([A-Za-z]?)| )+$"};
    basic_regex<char> patronRegex{patron};

    return regex_search(cadena, patronRegex) && (cadena.length() != 0);
}

    /** Función para validar la fecha en distintos formatos*/
    bool CVal::isDate(const string& fecha) {
        // Vector con las expresiones regulares para los formatos de fecha
        string formatos[] = {
                R"((\d{4})/(\d{1,2})/(\d{1,2}))",   // Formato: 2024/08/14
                R"((\d{4})-(\d{1,2})-(\d{1,2}))",   // Formato: 2024-08-14
                R"((\d{4})\.(\d{1,2})\.(\d{1,2}))", // Formato: 2024.08.14
                // Formatos adicionales con un solo dígito para día y mes
                R"((\d{1,2})/(\d{1,2})/(\d{2,4}))",   // Formato: 8/8/24
                R"((\d{1,2})-(\d{1,2})-(\d{2,4}))",   // Formato: 8-8-24
                R"((\d{1,2})\.(\d{1,2})\.(\d{2,4}))", // Formato: 8.8.24
        };

        for (const auto& formato : formatos) {
            regex regex(formato);
            smatch match;

            if (regex_match(fecha, match, regex)) {
                int day, month, year;

                // Determinar el formato según el número de componentes
                if (match[1].length() <= 2 && match[3].length() == 4) { // dd/mm/yyyy
                    day = stoi(match[1]);
                    month = stoi(match[2]);
                    year = stoi(match[3]);
                } else if (match[1].length() == 4 && match[3].length() <= 2) { // yyyy/mm/dd
                    year = stoi(match[1]);
                    month = stoi(match[2]);
                    day = stoi(match[3]);
                } else if (match[3].length() == 2) { // dd/mm/yy, dd-mm-yy, dd.mm.yy, etc.
                    day = stoi(match[1]);
                    month = stoi(match[2]);
                    year = stoi(match[3]);
                    // Convertir el año de dos dígitos a cuatro
                    if (year < 100) {
                        year += 2000;
                    }
                }

                // Validar componente día, mes, año
                if (isDateFormat(day, month, year)) {
                    return true; // La fecha es válida
                }
            }
        }

        return false; // Ningún formato válido o componentes incorrectos
    }

    /** Función para comprobar si un año es bisiesto*/
    bool CVal::isBis(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /** Función para validar el día, mes y año*/
    bool CVal::isDateFormat(int day, int month, int year) {
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;

        // Días máximos por month
        int dayForMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Sí es año bisiesto, ajustar febrero
        if (month == 2 && isBis(year)) {
            dayForMonth[1] = 29;
        }

        // Comprobar si el día está en el rango permitido para el month
        return day <= dayForMonth[month - 1];
    }

    /** Método para validar cadenas de texto vacías o nulas */
    bool CVal::isStr(const string& cadena) {
    if (cadena.empty() || all_of(cadena.begin(), cadena.end(), ::isspace)) {
        return false;
    }
    return true;
}

    /**Método para validar un directorio*/
    bool CVal::isDir(const string& cadena) {
        if (fs::is_directory(cadena) && !fs::is_regular_file(cadena)) {
            return true;
        } else {
            return false;
    }
}
