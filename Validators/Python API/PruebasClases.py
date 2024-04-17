from Validador import Validador
from Capturas import Capturas
objV = Validador()
objC = Capturas(objV)



pene = objC.capCade("Capture su Pene: ")
print(pene,type(pene))

def esCierto(valor) -> None:
    if valor:
        print("Es cierto")
    else: 
        print("Es falso")
    
Direc =  objC.capDire()
print(Direc,type(Direc))
print()
Direc =  objC.capFile("C:/Users/Luis.Luisss/Documentos/Programacion/POO/Copias de seguridad/Empleados",".csv")
print(Direc,type(Direc))
print(Direc.is_file())
print()
Direc = objC.capFile(".csv")
print(Direc,type(Direc))
print(Direc.is_file())

#Existe error en el is Nom regresa el valor booleano del ultimo valor comparadao
#Osea Pancho mat3o vi//a sex0 niño Gáy regresa True comparo el Gáy
#Se arreglo usando un variable auxiliar, quiza se opte por expresiones regulares
esCierto(objV.isNom("\n"))
esCierto(objV.isNum("Hola"))
esCierto(objV.isDate("29/02/2005"))
#Hay un error de logica con la expresion if len(cadena) == 0 or cadena == None:
#En caso de que la cadena sea None el metodo len() no lo soporta como argumento
#Entocens instacio el argumento como cadena y si pertenece a la clase Strig 
#Me devueleve la expresion booleana len(cadena) == 0 si no compara que sea None
# retorna el True y si ninguna de las dos pues retorna false 
esCierto(objV.isStrVacio(''))

"""
micadena = objC.capCade("Capture su cadena: ")
print(micadena)
micadena = objC.capCade("Capture su cadena: ",10)
print(micadena," y ",type(micadena))

miNumeroReal = objC.capReal("Capture un numero real: ")
print(miNumeroReal," y ", type(miNumeroReal))
miNumeroReal = objC.capReal("Capture un numero real: ",0.0)
print(miNumeroReal," y ", type(miNumeroReal))
miNumeroReal = objC.capReal("Capture un numero real: ",1.0,10.0)
print(miNumeroReal," y ", type(miNumeroReal))

ubiArchivo = objC.capDire()

if Path(ubiArchivo).exists(): print("Si existe")
else: print("No existe")
A = objC.capCade("sEXO: ")
print(A,type(A))
"""