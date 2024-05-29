#include "Moneda.h"
#include "../Validators/C++ API/CAPVAL/Capturador.h"
#include "../Validators/c++ API/CAPVAL/utilCppFile.h"
#include <string>
#include <iostream>
#include <filesystem>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>
#include <cctype>

namespace fs = std::filesystem;
typedef std::vector<Moneda*> Monedero;
typedef std::vector<std::string> StrVector;

std::vector<double> totalDivisas;
std::vector<double> subtotal;
std::vector<int>    nMonedas;

//Funcion rapida para convertir a mayusculas, devuelve std::string
std::string aMayus(std::string& str){
    std::transform(str.begin(), str.end(), str.begin(),
     [](unsigned char letra){
         return std::toupper(letra);
        }
    );
}

void meta(){
    std::cout << "Programa para capturar y desplegar monedas en pantalla " 
        << "a por medio de dato centinela o archivo de texto y generar un "
        << "archivo de salida de la captura." << std::endl;
}

void datos(Capturador*& dec){
    bool cond {true};

    std::cout << "Elija su tipo de entrada:\n" << std::endl;
    do {
        std::string opc {dec->capNom("A)rchivo\tM)anual\n")} ;
        if(aMayus(opc) == "A"){
            //leerArchivos(miMonedero);
            cond = false;
        } else if(aMayus(opc) == "M"){
            //capturaManual(miMonedero, capturador);
            cond = false;
        } else std::cout << "Ingrese un valor valido." << std::endl;
    } while (cond);
}

void leerArchivos(Monedero& monedero, File*& lector){
    typedef std::string cadena;

    //La extension del archivo que se quiere mostrar en pantalla 
    const cadena EXTENSION {".mdat"};
    auto ruta {lector->capFile(EXTENSION)};

    std::ifstream archivo(ruta);
    if(!archivo.is_open()){
        std::cout << "Elija un archivo valido." << std::endl;
        leerArchivos(monedero, lector);
    }

    instanciarObjetos(monedero, archivo);
}

StrVector leerLinea(const std::string& linea) {
    StrVector StrVector;
    std::istringstream entrada(linea);
    std::string campo;
    bool comillas = false;
    char letra;
    
    while (entrada >> std::noskipws >> letra) {
        if (letra == '"') {
            comillas = !comillas;
        } else if (letra == ',' && !comillas) {
            StrVector.push_back(campo);
            campo.clear();
        } else {
            campo += letra;
        }
    }
    StrVector.push_back(campo);

    return StrVector;
}

// Quien sea que pueda refactorizar esta funcion adelante, urge

void instanciarObjetos(Monedero& monedero , std::ifstream& entrada){
    typedef std::string cadena;
    Validador* val = new Validador();
    double  valor; 
    int date, cantidad, cuenta {0};
    cadena escudo, divisa, pais;
    cadena renglon;
    StrVector inits;

    /* 
     * Agustin ayudame a arreglar este metodo porque de seguro al
     * ciriaco no le va a gustar xdddddd auxilio.
     */

    /*
     * Esta funcion lee una linea del csv, y devuelve un std::vector
     * lleno de std::string, eliminando las comas y todo. Esta es la 
     * funcion para instanciar objetos validando datos para evitar un
     * crash por un dato mal colocado. Intente hacerlo con un for-each
     * y un switch case, pero le he visto complicaciones que no tengo 
     * tiempo para resolver xd. Sin embargo esta funcion esta un poquito 
     * tremenda (enchorizada), no se si cirino invalide el ejercicio por ella.
     */

    inits = leerLinea(renglon);
    for(int i = 0; i < inits.size(); i++){
        if(val->isNum(inits.at(i)) && cuenta == 0)
            valor = stof(inits.at(i));
        else valor = 0;

        if(val->isNum(inits.at(i)) && cuenta == 1)
            date = stoi(inits.at(i));
        else date = 0;

        if(val->isNom(inits.at(i)) && cuenta == 2)
            escudo = inits.at(i);
        else escudo = "DATO INVALIDO";

        if(val->isNom(inits.at(i)) && cuenta == 3)
            pais = inits.at(i);
        else pais = "DATO INVALIDO";

        if(val->isNom(inits.at(i)) && cuenta == 4)
            divisa = inits.at(i);
        else divisa = "DATO INVALIDO";

        if(val->isNum(inits.at(i)) && cuenta == 5)
            cantidad = stoi(inits.at(i));
        else cantidad = 0;


        (cuenta%6 == 0)? cuenta=0:cuenta++;
        monedero.push_back(new Moneda(valor, date, escudo, pais, divisa));
        nMonedas.push_back(cantidad);
    }
    delete val;
}

void capturaManual(Monedero& monedero, Capturador*& dec){
    typedef std::string cadena;
    int valor, date;
    cadena escudo, divisa;
    cadena pais {dec->capNom("Ingrese el nombre del pais.")};

    do {
        escudo = dec->capNom("Ingrese el nombre del escudo.");
        divisa = dec->capNom("Ingrese el nombre de la divisa.");
        valor  = dec->capReal("Ingrese el valor de la moneda.", 0);
        date   = dec->capInt("Ingrese el valor del año.", 1600, 2024);
        monedero.push_back(new Moneda(valor, date, escudo, pais, divisa));

	// Se usa date porque ya se instancio el objeto, por lo que 
	// se puede perder el valor en date libremente.
        date = dec->capInt("Ingrese la cantidad de monedas.", 0);

	nMonedas.push_back(date);
        pais   = dec->capNom("Ingrese el nombre del pais.");
    } while (aMayus(pais) != "FIN");
}

// Funcion para filtrar divisas usando for-each
// los tipos auto son moneda* y std::string&
// Esta funcion se hace bien facil con el not in de python 

StrVector filtrarDivisas(Monedero& monedero){
    StrVector divisas;
    int divisasDistintas;
    for (const auto& moneda : monedero){
        divisasDistintas = 0;        

        for(const auto& divisa : divisas){
            if(moneda->getDivisa() != divisa ){
                divisasDistintas++;
            } else break;
            if(divisasDistintas == divisas.size())
                divisas.push_back(moneda->getDivisa());
        }
    }
    return divisas;
}

StrVector divisaPorMoneda(Monedero& monedero){
    StrVector divisas;
    for(const auto& moneda : monedero)
        divisas.push_back(moneda->getDivisa());
    return divisas;
}

/* 
    para cada moneda()
	conseguir valor total de la moneda (totalMoneda = valor * cantidad)
 	sumar valor a la suma de divisas()
		para cada divisa filtrada()
			si divisaF == moneda.divisa entonces
				sumaDivisas  = sumadivisas + totalMoneda
		
 */
void calculos(Monedero& monedero, StrVector& divisasFiltradas){
    StrVector divisasMonedero {divisaPorMoneda(monedero)};
	double dineros;
    const int sexo = divisasFiltradas.size();
    

    //BASURA ALERT
    for (const auto& divisa : divisasFiltradas)
        totalDivisas.push_back(0.0);

    for(int i = 0; i < divisasFiltradas.size(); i++){
        dineros = 0;
        for(int j = 0 ; j < monedero.size(); j++)
            if(divisasFiltradas.at(j) == monedero.at(i)->getDivisa())
                dineros += nMonedas.at(j) * monedero.at(j)->getValor();
        totalDivisas.at(i) = dineros;
    }

    for (int i = 0; i < monedero.size(); i++)
        subtotal.push_back(nMonedas.at(i) * monedero.at(i)->getValor());
}
