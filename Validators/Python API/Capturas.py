from multipledispatch import dispatch
from datetime import datetime
from Validador import Validador
from math import ceil
from pathlib import Path
from os import listdir

class Capturas:
    #Contructor por omision
    @dispatch()
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
        #Si un chistoso captura -89.5 regresa 89 y no lo penaliza
        return abs(ceil(float(numEntero)))
    
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
    
    def capDire(self) -> str:
        print("Nota: usa Shift+Ctrl+C para la ruta de acceso (En windows)")
        direccion = input("Capture la ruta de acceso: ")
        
        while not(self.__objV.isDir(direccion)):
            print("Ruta de acceso invalido")
            direccion = input("Capture la ruta de acceso: ")
        
        return Path(direccion).as_posix().replace('"','')
    
    @dispatch(str,str)
    def capFile(self,direccion,ext=".csv") -> Path:
        misfiles = listdir(direccion)
        myNewFiles = [ file for file in misfiles if file.lower().endswith(ext) ]
        
        for i in range(0,len(myNewFiles),1):
            print("{:d}.{}".format(i+1,myNewFiles[i]))
        
        index = self.capInte("Seleccione su archivo por numero: ",1,len(myNewFiles))
        
        return Path(direccion+"/"+myNewFiles[index-1])