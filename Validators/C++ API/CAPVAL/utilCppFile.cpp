#include "utilCPPFile.h"
#include <windows.h>
#include <fstream>
#include <iostream>

File::File(){    Capturador cap = this->capturador;    }

File::File(Capturador cap) : capturador(cap) {}

File::~File(){}

bool File::isDir(std::string ruta_param){
    if( !  fs::is_empty(ruta_param) 
        && fs::is_directory(ruta_param) 
        && fs::exists(ruta_param))
        return true;
    return false;
}

bool File::isDir(fs::path ruta_param){
    if( !  fs::is_empty(ruta_param) 
        && fs::is_directory(ruta_param) 
        && fs::exists(ruta_param))
        return true;
    return false;
}

auto File::getDirs(std::string directorio){
    std::vector<fs::path> dirs;

    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
        return dirs;
    }

    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta)){
        if(arch.is_regular_file())
            dirs.push_back(arch.path());
    }
    return dirs;
}

auto File::getDirs(fs::path directorio){
    std::vector<fs::path> dirs;

    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
        return dirs;
    }

    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta)){
        if(arch.is_regular_file())
            dirs.push_back(arch.path());
    }
    return dirs;
}

auto File::getDirs(fs::path directorio, std::string ext){
    std::vector<fs::path> dirs;

    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
        return dirs;
    }

    fs::path ruta{directorio};
    for (const auto& arch : fs::directory_iterator(ruta)){
        if(arch.is_regular_file() && arch.path().extension() == ext)
            dirs.push_back(arch.path());
    }
    return dirs;
}

void File::printFiles(fs::path directorio){
    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
    }

    fs::path ruta{directorio};
    int count {1};

    for (const auto& arch : fs::directory_iterator(ruta))
        if(arch.is_regular_file()){
            std::cout << count << ".- "<<arch.path().filename() << std::endl;
            count++;
        }
}

void File::printFiles(fs::path directorio, std::string ext){
    if (!isDir(directorio)){
        std::cout << "Directorio invalido.";
    }

    fs::path ruta{directorio};
    int count {1};

    for (const auto& arch : fs::directory_iterator(ruta))
        if(arch.is_regular_file() && arch.path().extension() == ext){
            std::cout << count << ".- "<<arch.path().filename() << std::endl;
            count++;
        }
}

fs::path File::capFile(){
    fs::path dirActual {fs::current_path()};

    fs::path nuevoDir {dirActual / "src"};
    while(!isDir(nuevoDir)){
        try {
            fs::create_directory(nuevoDir); 
        } catch (const fs::filesystem_error& e) {                    
            std::cerr << "Error al crear directorio: " << std::endl; 
            throw e;                                                 
        } //Simplemente wow, pero no se me ha ocurrido una mejor manera de hacer esto
    }     // asi que se queda con un catch -> throw cagadisimo JAJAJA
    
    printFiles(nuevoDir);

    auto archs {getDirs(nuevoDir)};
    const int LIMITE_SELECCION {1};
    const int LIMITE_ARCHIVOS {archs.size()};

    int opc {capturador.capInt(
        "Ingrese el numero del archivo deseado: ",
         LIMITE_SELECCION, LIMITE_ARCHIVOS
        )
    };

    return archs.at(opc - 1);
}

fs::path File::capFile(std::string ext){
    fs::path dirActual {fs::current_path()};

    fs::path nuevoDir {dirActual / "src"};
    while(!isDir(nuevoDir)){
        try {
            fs::create_directory(nuevoDir); 
        } catch (const fs::filesystem_error& e) {                    
            std::cerr << "Error al crear directorio: " << std::endl; 
            throw e;                                                 
        } //Simplemente wow, pero no se me ha ocurrido una mejor manera de hacer esto
    }     // asi que se queda con un catch -> throw cagadisimo JAJAJA
    
    printFiles(nuevoDir, ext);

    auto archs {getDirs(nuevoDir, ext)};
    const int LIMITE_SELECCION {1};
    const int LIMITE_ARCHIVOS {archs.size()};

    int opc {capturador.capInt(
        "Ingrese el numero del archivo deseado: ",
         LIMITE_SELECCION, LIMITE_ARCHIVOS
        )
    };

    return archs.at(opc - 1);
}
