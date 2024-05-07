#include "Moneda.h"
#include "valida.h"
#include <iostream>
#include <vector>
#include <algorithm>

void Meta() {
    std::cout << "Imprimir los totales de la suma de distintas divisas" << std::endl;
}

void ArchivoCSV(std::vector<Moneda>& monedas) {
    std::string nombreArchivo;
    std::cout << "Ingrese el nombre del archivo CSV: ";
    std::cin >> nombreArchivo;

    if (!existe(nombreArchivo))
        return;

    std::vector<std::string> lineas = leerCSV(nombreArchivo);
    
    for (const auto& linea : lineas) {
        std::istringstream ss(linea);
        std::string valor, divisa, escudo, pais, año;
        std::getline(ss, valor, ',');
        std::getline(ss, divisa, ',');
        std::getline(ss, escudo, ',');
        std::getline(ss, pais, ',');
        std::getline(ss, año, ',');
        
        Moneda nuevaMoneda;
        nuevaMoneda.setValor(std::stod(valor));
        nuevaMoneda.setDivisa(divisa);
        nuevaMoneda.setEscudo(escudo);
        nuevaMoneda.setPais(pais);
        nuevaMoneda.setAño(std::stoi(año));

        monedas.push_back(nuevaMoneda);
    }
}

void Datos(std::vector<Moneda>& monedas) {
    std::cout << "Ingrese los datos de las monedas:" << std::endl;
    while (true) {
        std::string valor_str, divisa, escudo, pais, año_str;
        double valor;
        int año;

        std::cout << "Valor de la moneda (Ingrese 'fin' para terminar): ";
        std::cin >> valor_str;
        if (valor_str == "fin")
            break;
        if (!esNumero(valor_str))
            continue;
        valor = std::stod(valor_str);

        std::cout << "Divisa: ";
        std::cin >> divisa;
        
        std::cout << "Escudo: ";
        std::cin >> escudo;
        
        std::cout << "País: ";
        std::cin >> pais;
        
        std::cout << "Año: ";
        std::cin >> año_str;
        if (!esNumero(año_str))
            continue;
        año = std::stoi(año_str);

        Moneda nuevaMoneda;
        nuevaMoneda.setValor(valor);
        nuevaMoneda.setDivisa(divisa);
        nuevaMoneda.setEscudo(escudo);
        nuevaMoneda.setPais(pais);
        nuevaMoneda.setAño(año);

        monedas.push_back(nuevaMoneda);
    }
}

void Calculos(const std::vector<Moneda>& monedas, std::vector<std::string>& divisas, std::vector<double>& totales) {
    for (const auto& moneda : monedas) {
        std::string divisa = moneda.getDivisa();
        double valor = moneda.getValor();

        auto it = std::find(divisas.begin(), divisas.end(), divisa);
        if (it != divisas.end()) {
            int index = std::distance(divisas.begin(), it);
            totales[index] += valor;
        } else {
            divisas.push_back(divisa);
            totales.push_back(valor);
        }
    }
}

void Resultados(const std::vector<std::string>& divisas, const std::vector<double>& totales) {
    std::cout << "Resultados:" << std::endl;
    for (size_t i = 0; i < divisas.size(); ++i) {
        std::cout << "Total de dinero de divisa " << divisas[i] << ": " << totales[i] << std::endl;
    }
}

int main() {
    char respuesta;
    std::vector<Moneda> monedas;
    std::vector<std::string> divisas;
    std::vector<double> totales;

    do {
        std::cout << "Menú:" << std::endl;
        std::cout << "1. Captura manual de datos" << std::endl;
        std::cout << "2. Leer archivo CSV" << std::endl;
        std::cout << "3. Terminar" << std::endl;
        std::cout << "Seleccione una opción: ";
        int opcion;
        std::cin >> opcion;

        switch (opcion) {
            case 1:
                Datos(monedas);
                break;
            case 2:
                ArchivoCSV(monedas);
                break;
            case 3:
                return 0;
            default:
                std::cout << "Opción no válida. Intente de nuevo." << std::endl;
        }

        Calculos(monedas, divisas, totales);
        Resultados(divisas, totales);

        std::cout << "Desea repetir el programa? (S/N): ";
        std::cin >> respuesta;
        std::cout << std::endl;

        // Limpiar el vector de monedas para una nueva ejecución
        monedas.clear();
        // Limpiar los vectores de divisas y totales para una nueva ejecución
        divisas.clear();
        totales.clear();

    } while (respuesta == 'S' || respuesta == 's');

    return 0;
}
