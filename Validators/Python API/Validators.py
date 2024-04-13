from multipledispatch import dispatch
from math import ceil
from datetime import datetime
from os import listdir,abort,path

class Validators:
    #Constructor por omision y vacio xdxd
    def __init__(self):
        pass

    #Verifica si es un numero
    def __isNume(self, cadena): 
        try:
            float(cadena)
            return True
        except ValueError: return False            
    
    #Verifica si es una cadena Pura (sin caracteres o numeros)
    def __isNomb(self, cadena): 
        defaulth = True
        lisnas = cadena.rsplit()
    
        for st in lisnas:
            if not(st.isalpha()):
                defaulth = False
                break
        if len(cadena) == 0: defaulth = False
        return defaulth
    
    #Verifica si es una fecha en el Formato dd/mm/aaaa y si el año es mayor de 1900
    #Se obtiene un objeto data con el metodo strptime
    def __isDate(self, fecha): 
        try:
            datetime.strptime(fecha, '%d/%m/%Y')
            match len(fecha):
                case 10: return int(fecha[6:10]) >= 1900 
                case 9:  return int(fecha[5:9]) >= 1900
                case 8:  return int(fecha[4:8]) >= 1900
        except ValueError: return False
    
    #Manejo de archivos en Python forDireccion hasta isFile
    def forDireccion(self,m):
        newD = ""
        
        for c in m:
            if c == "\\": c = '/'
            if c == '"': c = ''
            newD += c
            
        if len(m) == 0: return newD
        else: return str(newD)+'/'
    
    def isDire(self, Directorio):
        try:
            listdir(self.forDireccion(Directorio))
            return True
        except FileNotFoundError:
            return False
        except OSError:
            return False
        except UnicodeDecodeError:
            return False
    
    def isFile(self,direccion):
        try:
            d = self.forDireccion(direccion)
            p =  d[len(d)-1:]
            if p == '/': d = d[:-1]
            with open(d,encoding='UTF-8'):
                return True
        except: 
            return False
        
    @dispatch(str)
    def capCade(self,texto):
        cad = input(texto)
        
        while not(self.__isNomb(cad)):
            print("Solo letras")
            cad = input(texto)
        
        return str(cad)
    
    @dispatch(str,int)
    def capCade(self,texto,limC): #ValiNombre pero con delimitador de caracteres
        mensError = "Solo letras o se excedio "
        mensError += "el numero de caracteres: {:}".format(limC)
        cad = input(texto)
        
        while not(self.__isNomb(cad)) or not(len(cad) <= limC):
            print(mensError)
            cad = input(texto)
        
        return str(cad)
            
    @dispatch(str)
    def capReal(self, texto):
        numR = input(texto)
        
        while not(self.__isNume(numR)):
            print("No se permiten letras")
            numR = input(texto)
            
        return float(numR)
    
    @dispatch(str,float)
    def capReal(self,texto,lim):
        mensError = "No se aceptan letras o el valor"
        mensError += "es menor que {:}".format(lim)
        vr = False
        numR = input(texto)
        
        if self.__isNume(numR): 
            vr = float(numR) >= lim    
        
        while (not(self.__isNume(numR)) or not(vr)):
            print(mensError)
            numR = input(texto)        
            if self.__isNume(numR): 
                vr = float(numR) >= lim  
                      
        return float(numR)
    
    @dispatch(str,float,float)
    def capReal(self,texto,limI,limS):
        mensError = "No se aceptan letra o el numero no esta"
        mensError += "dentro del rango {:} y {:}".format(limI,limS)
        vr = False
        numR = input(texto)
        
        if self.__isNume(numR): 
            vr = limI <= float(numR) <= limS  
        
        while (not(self.__isNume(numR)) or not(vr)):
            print(mensError)
            numR = input(texto)        
            
            if self.__isNume(numR): 
                vr = limI <= float(numR) <=limS  
                
        return float(numR)
     
    @dispatch(str)
    def capInte(self,texto):
        numI = input(texto)
        
        while not(self.__isNume(numI)):
            print("No se permiten letras")
            numI = input(texto)
        
        return abs(ceil(float(numI)))
    
    @dispatch(str,int)
    def capInte(self,texto,lim):
        mesnError = "No se aceptan letras o el valor"
        mesnError += "es menor que {:}".format(lim)
        vr = False
        numI = input(texto)
        
        if self.__isNume(numI): 
            vr = abs(ceil(float(numI))) >= lim    
        
        while (self.__isNume(numI) or vr == False):
            print(mesnError)
            numI = input(texto)        
            if self.__isNume(numI): 
                vr = abs(ceil(float(numI))) >= lim    
                
        return abs(ceil(float(numI))) #Si un chistoso captura -89.5 regresa 89 
    
    @dispatch(str,int,int)
    def capInte(self,texto,limI,limS):
        mensError = "No se aceptan letra o el numero no esta"
        mensError += "dentro del rango {:} y {:}".format(limI,limS)
        vr = False
        numI = input(texto)
        
        if self.__isNume(numI): 
            vr = limI <= abs(ceil(float(numI))) <= limS   
        
        while (not(self.__isNume(numI)) or not(vr)):
            print(mensError)
            numI = input(texto)        
            if self.__isNume(numI): 
                vr = limI <= abs(ceil(float(numI))) <= limS      
                
        return abs(ceil(float(numI))) 
    
    #El metodo strftime 'dd/mm/yyyy' correspoindente a dd/mm/aaaa
    #Simpre trabaja con datos de tipo Date
    def capFecha(self, texto): 
        mensError = "Fecha invalida o año menor de 1900"
        fecha = input(texto)
        
        while not(self.__isDate(fecha)):
            print(mensError)
            fecha = input(texto) 
           
        fecha_F = datetime.strptime(fecha,'%d/%m/%Y')     
        return datetime.strftime(fecha_F,'%d/%m/%Y') 
    
    def isStrVacio(self, cadena):
        if len(cadena) == 0 or cadena == None: return True
        else: return False
    
    def reversoCad(self, cadena):
        return cadena[::-1]

    #Manejo de Archivos
    #La direccion deber ser valida responsabilidad del programador
    #Tanto isFile y isDirec tienen que ser verdaderos
    def capCSV(self,direc) -> None:
        rowError,cuenta = 1,0
        with open(direc,encoding='UTF-8') as csvFile: 
            csvFile.readline()
            for lines in csvFile:
                rowError += 1 
                myLis = lines.rstrip().split(',')
                for lin in myLis:   
                    if self.__isNomb(lin): cuenta += 1
                    if self.__isNume(lin): cuenta += 1
                    if self.__isDate(lin): cuenta += 1 
                if len(myLis) != cuenta:
                    print("Hay un error en la linea: "+str(rowError))
                    abort()
                cuenta = 0
        print("No hay errores en su archivo: :D")
    
    #Directorio validado responsabilidad del programador
    def gepFiles(self,direccion,ext=".csv"):
        myList = listdir(self.forDireccion(direccion))
        myFiles = [x for x in myList if x.lower().endswith(ext)]
        
        for f in range(0,len(myFiles),1): print(f"{f+1}. {myFiles[f]}")

        return myFiles
    
    def capDire(self,mensaje):
        myF = []
        Error = "Hubo un problema con la ruta de acceso"
        Error += " O ningun archivo se puede abrir"
        direc = input(mensaje)

        if self.isDire(direc):
            myF = listdir(self.forDireccion(direc))
            
        while self.isDire(direc) == False:
            print(Error)
            direc = input(mensaje)
            if self.isDire(direc):
                myF = listdir(self.forDireccion(direc))
        
        return self.forDireccion(direc)      
