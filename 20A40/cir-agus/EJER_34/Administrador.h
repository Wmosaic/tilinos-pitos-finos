# include <string>

# define ADMINISTRADOR_H
# ifdef ADMINISTRADOR_H
#include "Empleado.h"

class Administrador : public Empleado
{
private:
    /* data */
public:
    Administrador(/* args */);
    ~Administrador();
};



#endif