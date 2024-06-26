from datetime import datetime
from os import abort

class Validador:
    def __init__(self) -> None:
        pass
    
    def isNum(self, cadena) -> bool:
        try:
            float(cadena)
            return True
        except: return False
    
    def isNom(self, cadena) -> bool:
        listaStrings = cadena.rsplit()
        aux = True
        
        if len(cadena) != 0 and len(listaStrings) != 0:
            for elementos in listaStrings: 
                if not(elementos.isalpha() or elementos.isspace()): 
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
    
    def isStrVacio(self, cadena) -> bool:
       if isinstance(cadena, str): return len(cadena) == 0
       elif cadena == None: return True
       else: return False
    
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