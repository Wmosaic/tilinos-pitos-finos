#include <iostream>
#include <vector>
#include <algorithm>
#include "Moneda.h"
#include "Valida.h"

using namespace std;

void meta() {
    system("cls");
    cout << "Imprimir los totales de cada divisa" << endl;
    cout << "--------------------------------------------------" << endl;
}

void datos(vector<Moneda*>& monedero) {
    cout << "Ingrese los datos de las monedas:" << endl;
    while (true) {
        double valor;
        valor = capReal("Valor (Ingrese 0 para terminar): ");
        if (valor == 0) break;
        
        int cantidad;
        cout << "Cantidad: ";
        cin >> cantidad;

        string divisa, escudo, pais;
        int anio;
        
        cout << "Divisa: "; cin >> divisa;
        cout << "Escudo: "; cin >> escudo;
        cout << "Pais: "; cin >> pais;
        cout << "Año: "; cin >> anio;
        
        Moneda* moneda = new Moneda();
        moneda->setValor(valor * cantidad);
        moneda->setDivisa(divisa);
        moneda->setEscudo(escudo);
        moneda->setPais(pais);
        moneda->setAño(anio);
        monedero.push_back(moneda);
    }
}

void calculos(vector<Moneda*>& monedero, 
              vector<string>& divisas, 
              vector<double>& totalDivisas) {
    for (Moneda* moneda : monedero) {
        string divisa = moneda->getDiv();
        double valor = moneda->getVal();
        
        auto it = find(divisas.begin(), divisas.end(), divisa);
        if (it != divisas.end()) {
            // La divisa ya existe, actualiza el total
            int index = distance(divisas.begin(), it);
            totalDivisas[index] += valor;
        } else 
            divisas.push_back(divisa);
            totalDivisas.push_back(valor);
    }
}

void resultados(vector<string>& divisas, vector<double>& totalDivisas) {
    cout << "--------------------------------------------------" << endl;
    cout << "Resultados:" << endl;
    for (int i = 0; i < divisas.size(); ++i) {
        cout << "Total de dinero de divisa " 
        << divisas[i] << ": " << totalDivisas[i] << endl;
    }
    cout << "--------------------------------------------------" << endl;
}

int main() {
    char repetir;
    do {
        vector<Moneda*> monedero;
        vector<string> divisas;
        vector<double> totalDivisas;
        
        meta();
        datos(monedero);
        calculos(monedero, divisas, totalDivisas);
        resultados(divisas, totalDivisas);
        for (Moneda* moneda : monedero) {
            delete moneda;
        }

        cout << "Desea repetir el programa? (S/N): ";
        cin >> repetir;
        cout << endl;
        system("cls");
    } while (toupper(repetir) == 'S');
    return 0;
}