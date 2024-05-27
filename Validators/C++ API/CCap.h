#ifndef CAPTURADOR
#define CAPTURADOR
#include "CVal.h"
using namespace std;
#include <filesystem>
#include <vector>

namespace fs = std::filesystem;

class CCap {
private:
    CVal cVal{};

public:
    CCap();
    CCap(CVal val);
    ~CCap();

    int capInt(string mensaje);

    int capInt(string mensaje, int limite);

    int capInt(string mensaje, int limI, int limS);

    double capReal(string mensaje);

    double capReal(string mensaje, int limite);

    double capReal(string mensaje, int limI, int limS);

    string capNom(string mensaje);

    string capNom(string mensaje, int limC);

    string capDate(string mensaje);

    string capDir(string mensaje);

    fs::path  capFile(string mensaje, string extencion);

    fs::path  capFile(string mensaje, string directorio, string extencion);

    string capList(string mensaje, vector<string> opciones);
};

#endif
