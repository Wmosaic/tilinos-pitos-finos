# include <string>

# define EMPLEADO_H
# ifdef EMPLEADO_H

class Empleado
{
private:
    std::string nombre, fecha;
    double salario;
public:
    Empleado();
    Empleado(std::string newNombre,double newSalrio,std::string newFecha);
    bool setNombre(std::string nom);
    bool setSalario(double sal);
    bool setFecha(std::string fecha);
    std::string getNombre();
    double getSalario();
    std::string getFecha();
    std::string toString();
    ~Empleado();
};
# endif