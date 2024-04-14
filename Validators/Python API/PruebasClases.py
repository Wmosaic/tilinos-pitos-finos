from Validador import Validador

objV = Validador()

miDireccion = input("Capture el directorio: ")
print(objV.formatearCadena(miDireccion))

def esCierto(valor) -> None:
    if valor:
        print("Es cierto")
    else: 
        print("Es falso")

#Existe error en el is Nom regresa el valor booleano del ultimo valor comparadao
#Osea Pancho mat3o vi//a sex0 niño Gáy regresa True comparo el Gáy
#Se arreglo usando un variable auxiliar, quiza se opte por expresiones regulares
esCierto(objV.isNom("Pancho mateo villa sexo niño Gáy"))
esCierto(objV.isNum("Hola"))
esCierto(objV.isDate("29/02/2005"))
#Hay un error de logica con la expresion if len(cadena) == 0 or cadena == None:
#En caso de que la cadena sea None el metodo len() no lo soporta como argumento
#Entocens instacio el argumento como cadena y si pertenece a la clase Strig 
#Me devueleve la expresion booleana len(cadena) == 0 si no compara que sea None
# retorna el True y si ninguna de las dos pues retorna false
esCierto(objV.isStrVacio(''))
objV.valCSV(objV.formatearCadena(miDireccion))