class Empleado:
    def __init__(self,Nombre, Salario, fechaNac) -> None:
        self.__nombre = Nombre
        self.__salario = Salario
        self.__fechaNac = fechaNac
        
    def setNombre(self,nomb) -> bool:
        if len(nomb) > 0: 
            self.__nombre = nomb   
            return True
        else: return False
    
    def setSalario(self,sala) -> bool:
        if sala > 0:    
            self.__salario = sala
            return True
        else: return False
    
    def setFechaNac(self, fech) -> bool:
        if len(fech) > 0:
            self.__fechaNac = fech
            return True
        else: return False

    def getNombre(self) -> str: return self.__nombre
    def getSalario(self) -> float: return self.__salario
    def getFechaNac(self) -> str: return self.__fechaNac
    
    def toString(self) -> str:
        resultado = f"Nombre: {self.__nombre}\n"
        resultado += f"Salario: {self.__salario}\n"
        resultado += f"Fecha nacimiento: {self.__fechaNac}"
        return resultado