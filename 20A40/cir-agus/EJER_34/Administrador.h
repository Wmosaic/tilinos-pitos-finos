# include <string>
# include "Empleado.h"

# define ADMINISTRADOR_H
# ifdef ADMINISTRADOR_H


class Administrador : public Empleado
{
private:
    //Sexo
public:
    Administrador(/* args */);
    ~Administrador();
};



#endif