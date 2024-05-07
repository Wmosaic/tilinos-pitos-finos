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
        myFiles = []
        myRutaPath = Path(direccion)
    
        for files in myRutaPath.iterdir():
            if str(files).lower().endswith(ext) and files.is_file():
                myFiles.append(str(files.name))
                
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
        misArchivos = []
        rutaDeAcceso = self.capDir()
        myRuta = Path(rutaDeAcceso)
        
        for files in myRuta.iterdir():
            if str(files).lower().endswith(ext) and files.is_file():
                misArchivos.append(str(files.name))
        
        if len(misArchivos) == 0:
            print("No se encontro un archivo con la extension o estan dañados")
            abort()
        
        for i in range(0,len(misArchivos),1): 
            print("{:d}.{}".format(i+1,misArchivos[i]))
        
        index = self.__objC.capInte("Seleccione su archivo por numero: ",1,len(misArchivos))
        
        return Path(rutaDeAcceso+"/"+misArchivos[index-1])
    
    @dispatch(str,str)
    def capFile(self,direccion,ext) -> Path:
       misArchivos = []
       myRuta = Path(direccion)
        
       for files in myRuta.iterdir():
            if str(files).lower().endswith(ext) and files.is_file():
                misArchivos.append(str(files.name))
        
       if len(misArchivos) == 0: abort()
       
       for i in range(0,len(misArchivos),1): print("{:d}.{}".format(i+1,misArchivos[i]))
        
       index = self.__objC.capInte("Seleccione su archivo por numero: ",1,len(misArchivos))
        
       return Path(direccion+"/"+misArchivos[index-1])

"""
    def areFiles(self, direccion, ext) -> list:
        myFiles = []
        myRutaPath = Path(direccion)
    
        for files in myRutaPath.iterdir():
            if str(files).lower().endswith(ext) and files.is_file():
                myFiles.append(str(files.name))
                
        if len(myFiles) == 0: abort()
        
        return myFiles
        """