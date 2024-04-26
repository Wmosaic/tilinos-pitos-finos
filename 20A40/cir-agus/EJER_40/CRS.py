from Manager import Employee,Manager
from datetime import datetime

class CRS(Employee):
    def __init__(self, headType, myManager, loginID) -> None:
        self.__headType = headType
        self.__myManager = myManager
        self.__loginID = loginID
        #super().__init__(name, adress, salary)
    
    def setHeadType(self, hety) -> bool:
        if len(hety) > 0:
            self.__headType = hety
            return True
        else: return False
    
    def setMyManager(self, myManager) -> bool:
        if isinstance(myManager,Manager) and myManager != None:
            self.__myManager = myManager
            return True
        else: return False
    
    def setLoginID(self, loginID) -> bool: 
        if len(loginID) > 0:
            self.__loginID = loginID
            return True
        else: return False
    
    def getHeadType(self) -> str: return self.__headType
    def getMyManager(self) -> Manager: return self.__myManager
    def getLoginID(self) -> str: return self.__loginID
    
    def toString(self) -> str:
        resul =  super().toString()
        cadena = resul
        cadena += f"HeadType: {self.__headType}\n"
        cadena += f"My Manager: {self.__myManager.getName()}\n"
        cadena += f"Login ID: {self.__loginID}"
        return cadena
    
    def clockIN(self)->datetime:pass
    def ClocksOut(self)->datetime:pass