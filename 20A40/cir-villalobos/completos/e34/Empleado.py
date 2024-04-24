from datetime import datetime

class Empleado:
    nombre = "Empleado"
    salario = 0
    fechaNac = datetime.today()

    def __init__(self,nombreC, salarioC, fechaNacC):
        self.nombre = nombreC
        self.salario = salarioC
        self.fechaNac = fechaNacC
        
    def setNombre(self,nomb):
        if(not(len(nomb) > 0)):    return False
        self.nombre = nomb
        return True
    
    def setSalario(self,sala):
        if(not(sala > 0)):    return False
        self.salario = sala
        return True
    
    def setFechaNac(self, fech):
        try:
            self.fechaNac = fech
            return True
        except: return False

    def getNombre(self)  : return self.nombre
    def getSalario(self) : return self.salario
    def getFechaNac(self): return self.fechaNac
    
    def toString(self):
        concat = ("Nombre: " + self.nombre + "\tSalario: " + str(self.salario)
            + "\tFecha de nacimiento: " + str(self.fechaNac.today())[0:10])
        return concat
