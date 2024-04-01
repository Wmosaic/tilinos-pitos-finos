from multipledispatch import dispatch
from math import ceil
from datetime import datetime
from os import listdir

class Validators:
    #Constructor por omision y vacio xdxd
    def __init__(self):
        pass
    
    def __forDireccion(self,m):
        newD = ""
        
        for c in m:
            if c == "\\": c = '/'
            if c == '"': c = ''
            newD += c
            
        return newD     

    #Verifica si es un numero
    def __isNum(self, cadena): 
        try:
            float(cadena)
            return True
        except ValueError: return False            
    
    #Verifica si es una cadena Pura (sin caracteres o numeros)
    def __isNom(self, cadena): 
        defaulth = True
        lisnas = cadena.rsplit(' ')
    
        for st in lisnas:
            if not(st.isalpha()):
                defaulth = False
                break
        return defaulth
    
    #Verifica si es una fecha en el Formato dd/mm/aaaa y si el año es mayor de 1900
    #Se obtiene un objeto data con el metodo strptime
    def __isFecha(self, fecha): 
        try:
            datetime.strptime(fecha, '%d/%m/%Y')
            match len(fecha):
                case 10: return int(fecha[6:10]) >= 1900 
                case 9:  return int(fecha[5:9]) >= 1900
                case 8:  return int(fecha[4:8]) >= 1900
        except ValueError: return False
    
    
    def __isDirec(self, Directorio):
        try:
            listdir(Directorio)
            return True
        except FileNotFoundError:
            return False
        except OSError:
            return False
        except UnicodeDecodeError:
            return False
        
    @dispatch(str)
    def capCade(self,texto):
        cad = input(texto)
        
        while not(self.__isNom(cad)):
            print("Solo letras")
            cad = input(texto)
        
        return str(cad)
    
    @dispatch(str,int)
    def capCade(self,texto,limC): #ValiNombre pero con delimitador de caracteres
        mensError = "Solo letras o se excedio "
        mensError += "el numero de caracteres: {:}".format(limC)
        cad = input(texto)
        
        while not(self.__isNom(cad)) or not(len(cad) <= limC):
            print(mensError)
            cad = input(texto)
        
        return str(cad)
            
    @dispatch(str)
    def capReal(self, texto):
        numR = input(texto)
        
        while not(self.__isNum(numR)):
            print("No se permiten letras")
            numR = input(texto)
            
        return float(numR)
    
    @dispatch(str,float)
    def capReal(self,texto,lim):
        mensError = "No se aceptan letras o el valor"
        mensError += "es menor que {:}".format(lim)
        vr = False
        numR = input(texto)
        
        if self.__isNum(numR): 
            vr = float(numR) >= lim    
        
        while (not(self.__isNum(numR)) or not(vr)):
            print(mensError)
            numR = input(texto)        
            if self.__isNum(numR): 
                vr = float(numR) >= lim  
                      
        return float(numR)
    
    @dispatch(str,float,float)
    def capReal(self,texto,limI,limS):
        mensError = "No se aceptan letra o el numero no esta"
        mensError += "dentro del rango {:} y {:}".format(limI,limS)
        vr = False
        numR = input(texto)
        
        if self.__isNum(numR): 
            vr = limI <= float(numR) <= limS  
        
        while (not(self.__isNum(numR)) or not(vr)):
            print(mensError)
            numR = input(texto)        
            
            if self.__isNum(numR): 
                vr = limI <= float(numR) <=limS  
                
        return float(numR)
     
    @dispatch(str)
    def capInte(self,texto):
        numI = input(texto)
        
        while not(self.__isNum(numI)):
            print("No se permiten letras")
            numI = input(texto)
        
        return abs(ceil(float(numI)))
    
    @dispatch(str,int)
    def capInte(self,texto,lim):
        mesnError = "No se aceptan letras o el valor"
        mesnError += "es menor que {:}".format(lim)
        vr = False
        numI = input(texto)
        
        if self.__isNum(numI): 
            vr = abs(ceil(float(numI))) >= lim    
        
        while (self.__isNum(numI) or vr == False):
            print(mesnError)
            numI = input(texto)        
            if self.__isNum(numI): 
                vr = abs(ceil(float(numI))) >= lim    
                
        return abs(ceil(float(numI))) #Si un chistoso captura -89.5 regresa 89 
    
    @dispatch(str,int,int)
    def capInte(self,texto,limI,limS):
        mensError = "No se aceptan letra o el numero no esta"
        mensError += "dentro del rango {:} y {:}".format(limI,limS)
        vr = False
        numI = input(texto)
        
        if self.__isNum(numI): 
            vr = limI <= abs(ceil(float(numI))) <= limS   
        
        while (not(self.__isNum(numI)) or not(vr)):
            print(mensError)
            numI = input(texto)        
            if self.__isNum(numI): 
                vr = limI <= abs(ceil(float(numI))) <= limS      
                
        return abs(ceil(float(numI))) 
    
    #El metodo strftime 'dd/mm/yyyy' correspoindente a dd/mm/aaaa
    #Simpre trabaja con datos de tipo Date
    def capFecha(self, texto): 
        mensError = "Fecha invalida o año menor de 1900"
        fecha = input(texto)
        
        while not(self.__isFecha(fecha)):
            print(mensError)
            fecha = input(texto) 
           
        fecha_F = datetime.strptime(fecha,'%d/%m/%Y')     
        return datetime.strftime(fecha_F,'%d/%m/%Y') 
    
    def cadeVaci(self, cadena):
        if len(cadena) == 0 or cadena == None: return True
        else: return False
    
    def reversoCad(self, cadena):
        return cadena[::-1]

    def capCSV(self,lisCSV):
        ele = []
        for i in range(len(lisCSV)):
            if self.__isNom(lisCSV[i]):
                ele.append(True)
            if self.__isNum(lisCSV[i]):
                ele.append(True)
            if self.__isFecha(lisCSV[i]):
                ele.append(True)
        if len(ele) == (len(lisCSV)):
            return True
        else:
            return False
    
    def capDireccion(self, mensaje):
        Error = "Hubo un problema con la ruta de acceso, verifique por favor"
        direc = input(mensaje)
        
        while not(self.__isDirec(self.__forDireccion(direc))):
            print(Error)
            direc = input(mensaje)

        return self.__forDireccion(direc)
        
    def getFiles(self,direccion):
        
        myFiles = listdir(direccion)
        
        for f in range(0,len(myFiles),1):
            print(f"{f+1}. {myFiles[f]}")
        
        return myFiles