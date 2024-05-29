from multipledispatch import dispatch
from datetime import datetime
from Validador import Validador
from math import trunc

"""
LEER IMPORTENTE: SI QUIERES HACER CORRECTO USO DE ESTA CLASE DEBES ISNTALAR DESDE EL CMD
EL "multipledispatch" CON ESTE COMANDO: pip3 install multipledispatch SOLO HACES COPIA Y PEGA 
Y LISTO
"""

class Capturas:
    #Contructor por omision
    @dispatch()
    def __init__(self) -> None:
        self.__objV = Validador()
        
    @dispatch(object)
    def __init__(self,objetoValidador) -> None:
        self.__objV = objetoValidador
    
    @dispatch(str)
    def capCade(self,mensaje) -> str:
        cade = input(mensaje)
        
        while not(self.__objV.isNom(cade)):
            print("Solo permiten letras")
            cade = input(mensaje)
        
        return str(cade)
    
    @dispatch(str,int)
    def capCade(self,mensaje,limChar) -> str:
        #Esto es una porqueria pero en caso de que un programador chistoso ponga un entero negativo
        #Abra un ciclo infinito por naturaleza del isNom(), entoces si detecta un negativo lo hace Positivo
        #Esto se podria lanzar con RisesError quiza para solucionar problemas.
        if limChar < 0: limChar = limChar*-1 #Se proponen una validacion super Rapida
        if limChar == 0: limChar = limChar+1
        mensError = "El numero de caracteres debe ser menor a: "+str(limChar)
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

        return float(numReal)
    
    @dispatch(str,float)
    def capReal(self,mensaje,limValor) -> float:
        
        numReal = self.capReal(mensaje)
        
        while numReal < limValor:
            print("El numero deber ser mayor o igual a "+str(limValor))
            numReal = self.capReal(mensaje)
        
        return float(numReal)
    
    @dispatch(str,float,float)
    def capReal(self,mensaje,limInferior,LimSuperior) -> float:
        numReal = self.capReal(mensaje)
        
        while not(limInferior <= numReal <= LimSuperior):
            print("El numero debe estar entre: "+str(limInferior)+" y "+ str(LimSuperior))
            numReal = self.capReal(mensaje)
        
        return float(numReal)
    
    @dispatch(str)
    def capInte(self,mensaje) -> int:
        numEntero = input(mensaje)
        
        while not(self.__objV.isNum(numEntero)):
            print("No se aceptan letras")
            numEntero = input(mensaje)
            
        return trunc(float(numEntero))
    
    @dispatch(str,int)
    def capInte(self,mensaje,limValor) -> int:
        numEntero = self.capInte(mensaje)
        
        while numEntero < limValor:
            print("El numero debe ser mayor o igual a "+str(limValor))
            numEntero = self.capInte(mensaje)
        
        return numEntero
    
    @dispatch(str,int,int)
    def capInte(self,mensaje,limInferior,LimSuperior) -> int:
        numEntero = self.capInte(mensaje)
        
        while not(limInferior <= numEntero <= LimSuperior):
            print("El numero debe estar entre: "+str(limInferior)+" y "+ str(LimSuperior))
            numEntero = self.capInte(mensaje)
        
        return numEntero
    
    def capDate(self,mensaje) -> str:
        fecha = input(mensaje)
        
        while not(self.__objV.isDate(fecha)):
            print("Fecha invalida")
            fecha = input(mensaje)
        
        fechaFormateada = datetime.strptime(fecha,'%d/%m/%Y')
        return datetime.strftime(fechaFormateada,'%d/%m/%Y')
