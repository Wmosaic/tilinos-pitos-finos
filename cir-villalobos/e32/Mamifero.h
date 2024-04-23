#ifndef MAMIFERO
#define MAMIFERO
#include <string>

class Mamifero{
int numeroDePatas;
std::string color;
std::string nombre;
std::string especie;


public:
Mamifero();
Mamifero(int nPatas, std::string colorP,
         std::string nombreP, std::string especieP); 

~Mamifero();

bool setPatas(int nPatas);
bool setColor(std::string col);
bool setNombre(std::string nom);
bool setEspecie(std::string esp);

int getPatas();
auto getColor();
auto getNombre();
auto getEspecie();

};

#endif
