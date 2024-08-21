#ifndef CAPTURADOR
#define CAPTURADOR
#include <filesystem>
#include <vector>
#include "CVal.h"

using namespace std;
namespace fs = std::filesystem;

class CppCap {
private:
    CVal cVal{};

public:
    CppCap();
    explicit CppCap(const CVal& val);
    ~CppCap();

    string cap(const string& mensaje);

    int capInt(const string& mensaje);

    int capInt(const string& mensaje, int limite);

    int capInt(const string& mensaje, int limI, int limS);

    double capReal(const string& mensaje);

    double capReal(const string& mensaje, int limite);

    double capReal(const string& mensaje, int limI, int limS);

    string capNom(const string& mensaje);

    string capNom(const string& mensaje, int limC);

    string capDate(const string& mensaje);

    string capDir(const string& mensaje);

    vector<fs::path> capFile(const string& extension);

    fs::path  capFile(const string& mensaje, const string& extencion);

    fs::path  capFile(const string& mensaje, const string& directorio, const string& extencion);

    string capList(const string& mensaje, vector<string> opciones);

    string trim (const string& cadena);
};

#endif
