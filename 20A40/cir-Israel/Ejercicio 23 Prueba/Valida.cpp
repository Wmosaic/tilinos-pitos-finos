#include <iostream>
#include <string>
#include <locale>
#include <stdexcept>

using namespace std;

// Función para verificar si una cadena es un número válido
bool isNum(string cad) {
    if (cad.empty()) {
        return false;
    } else {
        try {
            stod(cad);
            return true;
        } catch (invalid_argument& e) {
            return false;
        }
    }
}

// Función para capturar un número real
double capReal(string prompt) {
    string input;
    double num;
    while (true) {
        cout << prompt;
        cin >> input;
        if (isNum(input)) {
            num = stod(input);
            break;
        }
    }
    return num;
}

// Función para capturar un número entero
int capInt(string prompt) {
    string input;
    int num;
    while (true) {
        cout << prompt;
        cin >> input;
        if (isNum(input)) {
            num = stoi(input);
            break;
        }
    }
    return num;
}