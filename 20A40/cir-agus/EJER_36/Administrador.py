from Empleado import Empleado

class Administrador(Empleado):
    
    def __init__(self,nombre,salario,fecha,deptoC, bonoC) -> None:
        self.__depto = deptoC
        self.__bono = bonoC
        super().__init__(nombre,salario,fecha)   

    def setDepto(self,dept) -> bool:
        if len(dept) > 0:
            self.__depto = dept
            return True
        else: return False
    
    def setBono(self,bono) -> bool:
        if bono > 0:
            self.__bono = bono
            return True
        else: return False

    def getDepto(self) -> str: return self.__depto
    def getBono(self)  -> float: return self.__bono

    def toString(self) -> str:
        resul = super().toString()
        
        resultado = resul + f"\nDepartamento {self.__depto}\n"
        resultado += f"Bono: {self.__bono}"
        return resultado