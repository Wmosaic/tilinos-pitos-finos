class Moneda:        
    def __init__(self, divisa, valor, pais, año, escudo):
        self.__divisa = divisa
        self.__valor = valor
        self.__pais = pais
        self.__año = año
        self.__escudo = escudo

    def setDivisa(self, divisa) -> bool:
        if len(divisa) > 0:
            self.__divisa = divisa
            return True
        else: return False
    
    def setValor(self, valor) -> bool:
        if valor > 0:
            self.__valor = valor
            return True
        else: return False
    
    def setPais(self, pais) -> bool:
        if len(pais) > 0:
            self.__pais = pais
            return True
        else: return False
    
    def setAño(self, año) -> bool:
        if año > 0:
            self.__año = año
            return True
        else: return False

    def setEscudo(self, escudo: str) -> bool:
        if len(escudo) > 0:
            self.__escudo = escudo
            return True
        else: return False

    def getDivisa(self) -> str: return self.__divisa
    def getValor(self) -> float: return self.__valor
    def getPais(self) -> str: return self.__pais
    def getAño(self) -> int: return self.__año
    def getEscudo(self) -> str: return self.__escudo

    def toString(self) -> str:
        cadena = f"Divisa: {self.__divisa}\n"
        cadena += f"Valor: {self.__valor}\n"
        cadena += f"Pais: {self.__pais}\n"
        cadena += f"Año: {self.__año}\n"
        cadena += f"Escudo: {self.__escudo}\n"
        return cadena