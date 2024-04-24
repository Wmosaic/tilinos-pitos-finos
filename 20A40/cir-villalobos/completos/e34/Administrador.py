from Empleado import Empleado

class Administrador(Empleado):
    depto = "N/A"
    bono = 0

    def __init__(self,nombreC, salarioC, fechaNacC, deptoC, bonoC):
        self.nombre = nombreC
        self.salario = salarioC
        self.fechaNac = fechaNacC
        self.depto = deptoC
        self.bono = bonoC

    def setDepto(self,dept):
        if(not(len(dept) > 0)):    return False
        self.depto = dept
        return True
    
    def setBono(self,bono):
        if(not(bono >= 0)):    return False
        self.bono = bono
        return True

    def getDepto(self) : return self.depto
    def getBono(self)  : return self.bono

    def toString(self):
        concat =  (super().toString() + "\tDepartamento: " 
        + self.depto + "\tBono: " + str(self.bono))
        return concat
