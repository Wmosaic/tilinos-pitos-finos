#include "Miscellaneous.h"
#include <filesystem>
#include <vector>
#include <fstream>
#include <iostream>
#include <regex>

using namespace std;
namespace fs = filesystem;

Miscellaneous::Miscellaneous() = default;
Miscellaneous::~Miscellaneous()= default;

    /**Método para leer una línea en un archivo csv/txt
    * Recibe la dirección de un archivo para su funcionamiento
    * @param directorio La ruta/dirección del archivo que se va a leer
    * @param linea Especifica la línea que se quiera leer
    * @return Una línea en específico (en formato String) dentro del archivo*/
    string Miscellaneous::readFile(int linea, const fs::path& directorio){
        ifstream archivo(directorio);
        string lineaCSV;
        int contador = 0;

        // Si el número de línea especificado no existe en el archivo lanza una excepción
        if (!archivo.is_open()) {
            throw runtime_error("Error al abrir el archivo: " + directorio.string());
        }

        // Leer el archivo línea por línea hasta que coincida con la línea solicitada
        while (std::getline(archivo, lineaCSV)) {
            if (contador == linea) {
                archivo.close();
                return lineaCSV;
            }
            contador++;
        }
        archivo.close();
        return "";
    }

    /**Método para leer archivos csv/txt, adjuntando los datos en líneas de texto
    * Recibe la dirección de un archivo para su funcionamiento
    * @param directorio La ruta/dirección del archivo que se va a leer
    * @return Todas las cadenas (en formato String) dentro del archivo*/
    vector<string> Miscellaneous::readFile(const fs::path& directorio){
        ifstream archivo(directorio);
        vector<std::string> lineas;
        string lineaCSV;

        // Si el número de línea especificado no existe en el archivo lanza una excepción
        if (!archivo.is_open()) {
            throw runtime_error("Error al abrir el archivo: " + directorio.string());
        }

        while (getline(archivo, lineaCSV)) {
            lineas.push_back(lineaCSV);
        }

        archivo.close();
        return lineas;
    }

    /**Método para escribir sobre archivos csv/txt
    * Recibe la dirección de un archivo nuevo o existente para su funcionamiento
    * Si el archivo no existe, se creará; si existe, se abrirá para agregar texto.
    * @param cadena Es la línea completa (en formato String) que se va a agregar
    * @param directorio La ruta/dirección del archivo en el cual se va a escribir
    * @param append Modo de escritura:
    * append: Cualquier contenido que se escriba se agregará, sin borrar el contenido previo.
    * trunc: El contenido del archivo se borrará y el nuevo contenido escrito reemplaza al anterior.*/
    void Miscellaneous::writeFile(const string& cadena, const fs::path& directorio, bool append){
        try {
            // Abrir el archivo en modo de escritura (append o truncate)
            ofstream archivo(directorio, append ? ios_base::app : ios_base::trunc);


            // Escribir la cadena en el archivo y agregar una nueva línea al final
            archivo << cadena << endl;

            // Cerrar el archivo
            archivo.close();
            cout << "Los datos se guardaron correctamente en el archivo" << endl;
        } catch (const exception& e) {
            cerr << "Se produjo un error al intentar guardar el archivo: " << e.what() << endl;
        }
    }

    /**Método para convertir la fecha a un formato específico
    * @param date La fecha que se quiera reformatear
    * @return La fecha con el formato establecido*/
    string Miscellaneous::convertDate(const string& date){
        std::string formatos[] = {
                R"((\d{4})/(\d{1,2})/(\d{1,2}))",   // Formato: 2024/08/14
                R"((\d{4})-(\d{1,2})-(\d{1,2}))",   // Formato: 2024-08-14
                R"((\d{4})\.(\d{1,2})\.(\d{1,2}))", // Formato: 2024.08.14
                R"((\d{1,2})/(\d{1,2})/(\d{2,4}))",   // Formato: 8/8/24
                R"((\d{1,2})-(\d{1,2})-(\d{2,4}))",   // Formato: 8-8-24
                R"((\d{1,2})\.(\d{1,2})\.(\d{2,4}))"  // Formato: 8.8.24
        };

        for (const auto& formato : formatos) {
            regex datePattern(formato);
            smatch matches;

            if (regex_match(date, matches, datePattern)) {
                int year, month, day;

                if (matches[1].str().length() == 4) {  // El año es completo (YYYY)
                    year = stoi(matches[1].str());
                    month = stoi(matches[2].str());
                    day = stoi(matches[3].str());
                } else {  // El año tiene dos dígitos (YY)
                    day = stoi(matches[1].str());
                    month = stoi(matches[2].str());
                    year = stoi(matches[3].str());
                    if (year < 100) {  // Añadir siglo para años cortos
                        year += 2000;
                    }
                }

                return to_string(day) + "/" + to_string(month) + "/" + to_string(year);
            }
        }
        return "";
    }