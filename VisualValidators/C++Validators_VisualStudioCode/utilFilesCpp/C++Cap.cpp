#include "CCap.h"
#include <iostream>
#include <vector>
#include <filesystem>

using namespace std;
namespace fs = filesystem;

//-------------------------------------------------GET LINE-----------------------------------------------------//
//--------------------------Todos los capturadores de esta clase hacen uso del getline--------------------------//

CppCap::CppCap() : cVal(){}
CppCap::CppCap(const CVal& val){    this-> cVal = val;    }
CppCap::~CppCap()= default;

    /** Método para capturar cualquier cadena de caracteres
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La cadena de caracteres capturada y validada*/
    string CppCap::cap(const string& mensaje){
        string aux;
        cout << mensaje << endl;
        getline(cin, aux);

        while (!cVal.isStr(aux)) {
            cout << mensaje << endl;
            getline(cin, aux);
        }
        return trim(aux);
    }

    /** Método para capturar solamente números enteros
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return El número entero capturado y validado*/
    int CppCap::capInt(const string& mensaje) {
    string aux;
    cout << mensaje << endl;
    getline(cin, aux);

    while (!cVal.isNum(aux)) {
        cout << mensaje << endl;
        getline(cin, aux);
    }
    return static_cast<int>(stof(aux));
}

    /** Método para capturar solamente números enteros con un límite determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param lim Indica el límite inferior de los valores que no se podrán capturar
    * @return El número entero capturado y validado dentro del límite especificado*/
    int CppCap::capInt(const string& mensaje, int lim){
        int aux = capInt(mensaje);

        while(aux < lim){
            aux = capInt(mensaje + "(No menor a " + to_string(lim) + ")");
        }
        return aux;
    }

    /** Método para capturar solamente números enteros dentro de un rango determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limI Indica el límite inferior de los valores que no se podrán capturar
    * @param limS Indica el límite superior de los valores que no se podrán capturar
    * @return El número entero capturado y validado dentro del rango especificado*/
    int CppCap::capInt(const string& mensaje, int limI, int limS){
        int aux = capInt(mensaje);

        while (aux < limI || aux > limS){
            aux = capInt(mensaje + "(Entre " + to_string(limI) + " y " + to_string(limS) + ") ");
        }
        return aux;
    }

    /** Método para capturar solamente números racionales
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return El número racional capturado y validado*/
    double CppCap::capReal(const string& mensaje){
        string aux;
        cout << mensaje << endl;
        getline(cin, aux);

        while(!cVal.isNum(aux)){
            cout << mensaje << endl;
            getline(cin, aux);
        }
        return static_cast<double>(stod(aux));
    }

    /** Método para capturar solamente números racionales con un limite determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param lim Indica el límite inferior de los valores que no se podrán capturar
    * @return El número racional capturado y validado dentro del límite especificado*/
    double CppCap::capReal(const string& mensaje, int lim){
        double aux = capReal(mensaje);

        while(aux < lim){
            aux = capReal(mensaje + "(No menor a " + to_string(lim) + ") ");
        }
        return aux;
    }

    /** Método para capturar solamente números racionales dentro de un rango determinado
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limI Indica el límite inferior de los valores que no se podrán capturar
    * @param limS Indica el límite superior de los valores que no se podrán capturar
    * @return El número racional capturado y validado dentro del rango especificado*/
    double CppCap::capReal(const string& mensaje, int limI, int limS){
        double aux = capReal(mensaje);

        while (aux < limI || aux > limS){
            aux = capReal(mensaje + "(Entre " + to_string(limI) + " y " + to_string(limS) + ") ");
        }
        return aux;
    }

    /** Método para capturar una cadena sin caracteres numéricos
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La cadena de texto capturada y validada sin caracteres numéricos*/
    string CppCap::capNom(const string& mensaje){
        string aux;
        cout << mensaje << endl;
        getline(cin, aux);

        while((!cVal.isStr(aux) || !cVal.isNom(aux))){
            cout << mensaje << endl;
            getline(cin, aux);
        }
        return trim(aux);
    }

    /**Método para capturar una cadena de texto con un límite de caracteres
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param limC Indica el límite en la cantidad de caracteres capturados
    * @return La cadena de texto capturada y validada sin caracteres numéricos*/
    string CppCap::capNom(const string& mensaje, int limC){
    string aux = capNom(mensaje);

    while (aux.length() >= limC){
        aux = capNom(mensaje + " (Menor a " + to_string(limC) + " Caracteres)");
    }
    return aux;
}

    /** Método para capturar una fecha
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La fecha capturada y validada como cadena*/
    string CppCap::capDate(const string& mensaje){
    string aux;
    cout << mensaje << endl;
    getline(cin, aux);

    while (!cVal.isDate(trim(aux))){
        cout << "(Fecha Invalida) " + mensaje << endl;
        getline(cin, aux);
    }
    return aux;
}

    /** Método para capturar un directorio
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @return La ruta del directorio capturada y validada como cadena*/
    string CppCap::capDir(const string& mensaje) {
        string aux;
        cout << mensaje << endl;
        getline(cin, aux);

        while (!cVal.isStr(aux) || !cVal.isDir(aux)) {
            cout << mensaje << endl;
            getline(cin, aux);
        }
        return trim(aux);
    }

    /** Método para capturar todos los archivos de un solo tipo de extension
     * @param extension El tipo de extensión de los archivos que se van a capturar
     * @return Todos los archivos de la extension especificada*/
    vector<fs::path> CppCap::capFile(const string& extension) {
        string directorio = capDir("Ingresa un Directorio:");
        vector<fs::path> archivosFiltrados;

        for (const auto &entry: fs::directory_iterator(directorio)) {
            if (entry.path().extension() == extension) {
                archivosFiltrados.emplace_back(entry.path().string());
            }
        }
        return archivosFiltrados;
    }

    /** Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
     * Extension (responsabilidad del programador)
     * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
     * @param extension El tipo de extensión del archivo que se va a capturar
     * @return El archivo capturado y validado*/
    fs::path CppCap::capFile(const string& mensaje, const string& extension) {
        vector<fs::path> files = capFile(extension);

        //Este bucle se repetirá hasta que se encuentre al menos un archivo con la extensión específica
        while (files.empty()) {
            cout << "No se encontraron archivos validos en este directorio" << endl;
            files = capFile(extension);
        }

        vector<string> nomFile;
        //Se almacenan los nombres de los archivos en el vector declarado
        for (const auto& file : files) {
            nomFile.push_back(file.filename().string());
        }

        //Se despliega una lista con los archivos almacenados en el arreglo
        string l = capList(mensaje, nomFile);

        //Se comprueba si el archivo existe, si no retorna path vació
        for (const auto& file : files) {
            if (file.filename().string() == l) {
                return file;
            }
        }

        cout << "No se encontró el archivo seleccionado." << endl;
        return {};
    }

    /** Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    * Directorio y extension (responsabilidad del programador)
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param directorio la ruta/dirección donde se buscarán los archivos
    * @param extension El tipo de extensión del archivo que se va a capturar
    * @return El archivo capturado y validado*/
    fs::path CppCap::capFile(const string& mensaje, const string& directorio, const string& extension) {
        vector<fs::path> files;
        for (const auto &entry: fs::directory_iterator(directorio)) {
            if (entry.path().extension() == extension) {
                files.emplace_back(entry.path().string());
            }
        }

        vector<string> nomFile;
        //Se almacenan los nombres de los archivos en el vector declarado
        for (const auto& file : files) {
            nomFile.push_back(file.filename().string());
        }

        //Se despliega una lista con los archivos almacenados en el arreglo
        string l = capList(mensaje, nomFile);

        //Se comprueba si el archivo existe, si no retorna path vació
        for (const auto& file : files) {
            if (file.filename().string() == l) {
                return file;
            }
        }

        cout << "No se encontró el archivo seleccionado." << endl;
        return {};
    }

    /** Método para desplegar una lista usando vectores
    * @param mensaje Cadena de texto que se mostrará al usuario solicitando la entrada
    * @param opciones Arreglo de opciones a desplegar
    * @return La opción seleccionada por el usuario como una cadena*/
    string CppCap::capList(const string& mensaje, vector<string> opciones) {
        for (size_t i = 0; i < opciones.size(); ++i) {
            std::cout << i + 1 << "- " << opciones[i] << std::endl;
        }

        int index = capInt(mensaje, 1, opciones.size());

        return opciones[index - 1];
    }

    /**Función para eliminar los espacios en blanco al principio y al final de la cadena*/
    string CppCap::trim(const string& cadena) {
        string resultado = cadena;
        resultado.erase(0, resultado.find_first_not_of(" \t\r\n")); // Elimina espacios al inicio
        resultado.erase(resultado.find_last_not_of(" \t\r\n") + 1); // Elimina espacios al final

        return resultado;
    }