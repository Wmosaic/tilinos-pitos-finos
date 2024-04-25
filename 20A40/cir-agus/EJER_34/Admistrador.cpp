# include <iostream>
# include <string>
# include <Administrador.h>

Administrador::Administrador(){}

Administrador::Administrador(std::string newDep, double newBono){
    this -> Departamento = newDep;
    this -> Bono = newBono;
}

bool Administrador::setDepartamento(std::string dept ){
    if(dept.length() > 0){
        Departamento = dept;
        return true;
    } else return false;
}

bool Administrador::setBono(double bono){
    if(bono > 0){
        Bono = bono;
        return true;
    }else return false;
}

std::string Administrador::getDepartamento(){ return Departamento; }
double Administrador::getBono(){ return Bono; }

std::string Administrador::toStringE(){
    std::string resultado = "Departamento: "+Departamento;
    resultado += "Bono: "+std::to_string(Bono);
    return resultado;
}

Administrador::~Administrador(){
    delete[] this;
}
