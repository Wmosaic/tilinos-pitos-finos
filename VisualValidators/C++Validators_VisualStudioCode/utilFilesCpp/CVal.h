#ifndef VALIDADOR
#define VALIDADOR
#include <string>

using namespace std;

class CVal {
public:
    CVal();
    ~CVal();

    bool isNum (const string& prueba);

    bool isNom (const string& cadena);

    bool isDate (const string& cadena);

    bool isDateFormat(int day, int month, int year);

    bool isBis (int year);

    bool isStr (const string& cadena);

    bool isDir (const string& cadena);
};

#endif