#ifndef FILESCPP
#define FILESCPP

#include "Capturador.h"
#include <filesystem>
#include <vector>

namespace fs = std::filesystem;

class File{
    Capturador* capturador;

public:
    File();
    File(Capturador* cap_param);
    ~File();

    bool isDir(std::string ruta_param);
    bool isDir(fs::path ruta_param);

    auto getDirs(std::string directorio);
    auto getDirs(fs::path directorio);
    auto getDirs(fs::path directorio, std::string ext);
    fs::path capFile();
    fs::path capFile(std::string ext);
    void printFiles(fs::path directorio);
    void printFiles(fs::path directorio, std::string ext);
};

#endif
