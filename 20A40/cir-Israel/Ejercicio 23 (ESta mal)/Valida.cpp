#include "valida.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <limits>

bool existe(const std::string& archivo) {
    std::ifstream file(archivo);
    if (!file.is_open()) {
        std::cout << "Error: El archivo " << archivo << " no existe." << std::endl;
        return false;
    }
    return true;
}

std::vector<std::string> leerCSV(const std::string& archivo) {
    std::vector<std::string> lineas;
    std::ifstream file(archivo);
    std::string linea;
    
    if (!file.is_open()) {
        std::cout << "Error: No se pudo abrir el archivo " << archivo << "." << std::endl;
        return lineas; // Retorna vector vacío si no se puede abrir el archivo
    }

    while (std::getline(file, linea))
        lineas.push_back(linea);

    return lineas;
}

bool esNumero(const std::string& str) {
    for (char c : str) {
        if (!std::isdigit(c) && c != '.') {
            std::cout << "Error: La entrada no es un número válido." << std::endl;
            return false;
        }
    }
    return true;
}

bool capturaEntero(int num) {
    if (!std::cin.good()) {
        std::cout << "Error: La entrada no es un número entero válido." << std::endl;
        std::cin.clear();
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        return false;
    }
    return true;
}