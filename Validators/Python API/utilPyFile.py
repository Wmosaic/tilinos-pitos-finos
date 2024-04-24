from Capturas import Capturas
from multipledispatch import dispatch
from os import listdir,abort
from pathlib import *

class utilPyFile:
    def __init__(self) -> None:
         self.__objC = Capturas()
         
    def isDir(self, cadena) -> bool:
        #La ruta de Acceso tiene un Match que sirve para que no se den
        #Entrada para esos caracterers que por Enter da un '.' y el listdir
        #Acepta '/' para abrir directorios entoces ya da false en caso de 
        #Siniestros
        
       try: 
           #Nota .as_posix() Cambia una ruta de acceso de windows a Unix
           #Cuando copias el Path de una carpeta de windows salen comillas
           #Entoces Replace se encarga de quitarlas
            rutaAcceso = PureWindowsPath(cadena).as_posix().replace('"','')
            match rutaAcceso:
                case '.': return False
                case '/': return False
                case  '': return False
            listdir(rutaAcceso)
            return True
       except: return False
    
    def areFiles(self, direccion, ext) -> list:
        myFiles = [file for file in listdir(direccion) if file.lower().endswith(ext) and Path(file).is_file()]
        if len(myFiles) == 0: abort()
        return myFiles
            
    def capDir(self) -> str:
        print("Nota: usa Shift+Ctrl+C para la ruta de acceso (En windows)")
        direccion = input("Capture la ruta de acceso: ")
        
        while not(self.isDir(direccion)):
            print("Ruta de acceso invalido")
            direccion = input("Capture la ruta de acceso: ")
        
        return Path(direccion).as_posix().replace('"','')
    
    @dispatch(str)
    def capFile(self,ext) -> Path:
        rutaDeAcceso = self.capDire()
         
        myFiles = self.areFiles(rutaDeAcceso,ext)
        
        for i in range(0,len(myFiles),1):
            print("{:d}.{}".format(i+1,myFiles[i]))
        
        index = self.__objC.capInte("Seleccione su archivo por numero: ",1,len(myFiles))
        
        return Path(rutaDeAcceso+"/"+myFiles[index-1])
    
    @dispatch(str,str)
    def capFile(self,direccion,ext) -> Path:
        myFiles = self.areFiles(direccion,ext)
        
        for i in range(0,len(myFiles),1):
            print("{:d}.{}".format(i+1,myFiles[i]))
        
        index = self.capInte("Seleccione su archivo por numero: ",1,len(myFiles))
        
        return Path(direccion+"/"+myFiles[index-1])