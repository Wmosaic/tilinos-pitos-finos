#include <iostream>
#include <string>
#include <cctype>  // Para std::tolower

std::string toLowerCase(const std::string& str) {
    std::string result = str; // Hacemos una copia de la cadena original
    for (char& c : result) {
        c = std::tolower(static_cast<unsigned char>(c));
    }
    return result;
}

int main() {
    std::string str = "Hola Mundo!";
    std::string lowerStr = toLowerCase(str);
    std::cout << lowerStr << std::endl; // salida: hola mundo!

    return 0;
}
