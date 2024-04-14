from multipledispatch import dispatch
from Validador import Validador
from math import ceil

class Capturas:
    #Contructor por omision
    @dispatch(None)
    def __init__(self) -> None:
        self.__objV = Validador()
        
    #Constructor sobrecargado que acepta un objeto
    #Probablemte al instanciar se debe envolver
    #En la clase object de Python o creo que no w
    @dispatch(object)
    def __init__(self,objetoValidador) -> None:
        self.__objV = objetoValidador
    
    @dispatch(str)
    def capCade(self,mensaje) -> str:
        cade = input(mensaje)
        
        while not(self.__objV.isNom(cade)):
            print("Solo permiten letras")
            cade = input(mensaje)
        
        return cade
    
    @dispatch(str,int)
    def capCade(self,mensaje,limChar) -> str:
        mensError = "El numero de caracteres debe ser menor a: "+str(limChar)
        #Hago referencia al metodo "Original" para reutilizar logica
        #No se si es la forma mas eficente pero es mas legible sobre 
        #todo en el capReal y capInte
        cad = self.capCade(mensaje)
        
        while not(len(cad) <= limChar):
            print(mensError)
            cad = self.capCade(mensaje)
        
        return str(cad)
    
    @dispatch(str)
    def capReal(self,mensaje) -> float:
        numReal = input(mensaje)
        
        while not(self.__objV.isNum(numReal)):
            print("No se aceptan letras")
            numReal = input(mensaje)

        return numReal
    
    @dispatch(str,float)
    def capReal(self,mensaje,limValor) -> float:
        
        numReal = self.capReal(mensaje)
        
        while numReal < limValor:
            print("El numero deber ser mayor o igual a "+str(limValor))
            numReal = self.capReal(mensaje)
        
        return numReal
    
    @dispatch(str,float,float)
    def capReal(self,mensaje,limInferior,LimSuperior) -> float:
        numReal = self.capReal(mensaje)
        
        while not(limInferior <= numReal <= LimSuperior):
            print("El numero debe estar entre: "+str(limInferior)+" y "+ str(LimSuperior))
            numReal = self.capReal(mensaje)
        
        return numReal