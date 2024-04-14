from datetime import datetime
from os import listdir,abort

class Validador:
    def __init__(self) -> None:
        pass
    
    def formatearCadena(self, cadena) -> str:
        if '"' in cadena:
            direcFormateada = (cadena.replace('"','')).replace('\\','/')
        else:
            direcFormateada = cadena.replace('\\','/')
        return direcFormateada
    
    def isNum(self, cadena) -> bool:
        try:
            float(cadena)
            return True
        except: return False
    
    def isNom(self, cadena) -> bool:
        #El metodo rsplit genera una lista de strings eliminando espacios
        aux = True
        if len(cadena) != 0:
            listaStrings = cadena.rsplit()
            for elementos in listaStrings: 
                if not(elementos.isalpha()): 
                    aux = False
                    break
        else: return False
        return aux
    
    #Dependiendo de la longitud de la fecha capturada se extree el año 
    #Para verificar si el año es mayor a 1900, usando el slicig
    def isDate(self, fecha) -> bool:
        try:
            datetime.strptime(fecha, '%d/%m/%Y')
            match len(fecha):
                case 10: return int(fecha[6:10]) >= 1900 
                case 9: return int(fecha[5:9]) >= 1900
                case 8: return int(fecha[4:8]) >= 1900
                case _: return False
        except: return False
    
    def isDir(self, cadena) -> bool:  
        try:
            listdir(self.formatearCadena(cadena))
            return True
        except FileNotFoundError: return False
        except OSError: return False
        except UnicodeDecodeError: return False
    
    def isStrVacio(self, cadena) -> bool:
       if isinstance(cadena, str): return len(cadena) == 0
       elif cadena == None: return True
       else: return False
    
    #La direccion ya debe estar validada responsabilidad del programador
    #Nota: Creo que no se desarrollada en C++ ni en Java por lo tanto es metodo dispar
    #Entre los demas lenguajes hasta ahora
    def valCSV(self, direccion) -> None:
         rowError,cuenta = 1,0
         with open(direccion,encoding='UTF-8') as csvFile: 
            csvFile.readline()
            for lines in csvFile:
                rowError += 1 
                myLis = lines.rstrip().split(',')
                for lin in myLis:   
                    if self.isNom(lin): cuenta += 1
                    if self.isNum(lin): cuenta += 1
                    if self.isDate(lin): cuenta += 1 
                if len(myLis) != cuenta:
                    print("Hay un error en la linea: "+str(rowError))
                    abort()
                cuenta = 0
            print("No hay errores en su archivo: :D")