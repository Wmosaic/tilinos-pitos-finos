# include <string>
# include "Empleado.h"

# define ADMINISTRADOR_H
# ifdef ADMINISTRADOR_H


class Administrador : public Empleado
{
private:
    std:: string Departamento;
    double Bono;
public:
    
    Administrador();
    Administrador(std::string newDep, double bono);
    bool setDepartamento(std::string dep);
    bool setBono(double bono);
    std::string getDepartamento();
    double getBono();
    std::string toStringE();
    ~Administrador();
};



#endif