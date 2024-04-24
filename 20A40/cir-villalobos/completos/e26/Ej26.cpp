#include "Ej26.h"

Referencia::Referencia() : x(0) {}

Referencia& Referencia::incremento() {
    x++;
    return *this;
}