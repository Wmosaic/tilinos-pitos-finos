#ifndef VALIDA_H
#define VALIDA_H

#include <string>
#include <vector>

bool existe(const std::string& archivo);

std::vector<std::string> leerCSV(const std::string& archivo);

bool esNumero(const std::string& str);

bool capturaEntero(int num);

#endif // VALIDA_H