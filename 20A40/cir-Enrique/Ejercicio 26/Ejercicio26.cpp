#include "Ejercicio26.h"
#include <iostream>

Referencia::Referencia() : x(0) {}

Referencia& Referencia::incremento() {
    x++;
    return *this;
}

int main() {
    Referencia ref;
    Referencia &alias = ref;

    alias.incremento().incremento().incremento();
    ref.incremento().incremento();

    std::cout << "ref = " << ref.x << std::endl;
    std::cout << "alias = " << alias.x << std::endl;

    std::cin.get();

    return 0;
}
