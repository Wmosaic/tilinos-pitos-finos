from Employee import Employee

class Manager(Employee):
    def __init__(self,numReport,officeID,bonus) -> None:
        self.__numReport = numReport
        self.__officeID = officeID
        self.__bonus = bonus
        #super().__init__(name, adress, salary)
    
    def setNumReport(self, numR) -> bool:
        if len(numR) > 0:
            self.__numReport = numR
            return True
        else: return False
    
    def setOfficeID(self, officeID) -> bool:
        if officeID > 0: 
            self.__officeID = officeID
            return True
        else: return False
    
    def setBonus(self, bonus) -> bool:
        if bonus > 0:
            self.__bonus = bonus
            return True
        else: return False
    
    def getNumReport(self) -> int: return self.__numReport
    def getOfficeID(self) -> int: return self.__officeID
    def getBonus(self) -> float: return self.__bonus
    
    def toString(self) -> str:
        resulBase =  super().toString()
        cadena = resulBase
        cadena += f"\nNumero de reportes: {self.__numReport}\n"
        cadena += f"ID Official: {self.__officeID}\n"
        cadena += f"Bono: {self.__bonus}\n"
        return cadena
    
    def hires(self) -> Employee: pass
    def plans(self) -> None: pass 