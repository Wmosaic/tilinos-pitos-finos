#define VALIDATORS
#include <string>
#include <regex>
#include <iostream>
#include <vector>
#include <filesystem>

namespace fs = std::filesystem;

bool isDir(std::string directorio);

auto getDirs(std::string directorio){
    std::vector<fs::path> dirs;
    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
        return dirs;
    }
    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta)){
        dirs.push_back(arch.path());
    }
    return dirs;
}

void printDirs(std::string directorio){
     if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
    }
    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta))
        std::cout << arch.path() << "\n";
}
