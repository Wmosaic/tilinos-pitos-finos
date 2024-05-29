#include "CAPVAL/Capturador.h"
#include <iostream>

int main(){
	Capturador* cap = new Capturador();
	int x {cap->capInt("Ingrese un numero")};
	std::cout << x << std::endl;
	return 0;
}
