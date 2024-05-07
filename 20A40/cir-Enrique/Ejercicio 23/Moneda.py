class Moneda:        
    def __init__(self):
        self.__valor
        self.__año
        self.__divisa
        self.__pais
        self.__escudo

    def __init__(self, divisa: str, valor: float, pais: str, año: int, escudo: str):
        self.__valor = valor
        self.__año = año
        self.__divisa = divisa
        self.__pais = pais
        self.__escudo = escudo

    def setValor(self, valor: float) -> bool:
        if isinstance(valor, (int, float)):
            self.__valor = valor
            return True
        else:
            return False

    def setDivisa(self, divisa: str) -> bool:
        if isinstance(divisa, str):
            self.__divisa = divisa
            return True
        else:
            return False

    def setEscudo(self, escudo: str) -> bool:
        if isinstance(escudo, str):
            self.__escudo = escudo
            return True
        else:
            return False

    def setPais(self, pais: str) -> bool:
        if isinstance(pais, str):
            self.__pais = pais
            return True
        else:
            return False

    def setAño(self, año: int) -> bool:
        if isinstance(año, int):
            self.__año = año
            return True
        else:
            return False

    def getValor(self) -> float:
        return self.__valor

    def getDivisa(self) -> str:
        return self.__divisa

    def getEscudo(self) -> str:
        return self.__escudo

    def getPais(self) -> str:
        return self.__pais

    def getAño(self) -> int:
        return self.__año

    def toString(self) -> str:
        return f"Valor: {self.__valor}, Año: {self.__año}, Divisa: {self.__divisa}, País: {self.__pais}, Escudo: {self.__escudo}"