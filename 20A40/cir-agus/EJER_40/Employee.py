class Employee:
    def __init__(self, name, adress, salary) -> None:
        self.__name = name
        self.__adrs = adress
        self.__sala = salary
        
    def setName(self, nam) -> bool:
        if len(nam) > 0:
            self.__name = nam
            return True
        else: return False
    
    def setAdress(self, adr) -> bool:
        if len(adr) > 0:
            self.__adrs = adr
            return True
        else: return False
    
    def setSalary(self, saly) -> bool:
        if saly > 0:
            self.__sala = saly
            return True
        else: return False
    
    def getName(self) -> str:   return self.__name
    def getAdress(self) -> str:   return self.__adrs
    def getSalary(self) -> float: return self.__sala
    
    def toString(self) -> str:
        cadena = f"Nombre: {self.__name}\n"
        cadena += f"Direccion: {self.__adrs}\n"
        cadena += f"Salario: {self.__sala}"
        return cadena

"""Falta estudio
    def __init_subclass__(cls,name, adress, salary) -> None:
        cls.__name = name
        cls.__adrs = adress
        cls.__sala = salary
        return cls.__init__(Employee,name,adress,salary)
    """