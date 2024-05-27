from utilFilesPython.PythonCap import *

Cap = PythonCap()

aux = 7

if int(aux) == 1:
    n = Cap.capInt("Ingresa un numero: ")
    print("El numero es valido:", n)

elif int(aux) == 2:
    p = Cap.capNom("Ingresa una palabra: ")
    print("La palabra es:", p)

elif int(aux) == 3:
    fecha = Cap.capDate("Ingresa una fecha en el formato dd/mm/yyyy: ")
    print("La fecha es:", fecha)

elif int(aux) == 4:
    d = Cap.capDir("Ingresa un Directorio: ")
    print("La Dirección es:", d)

elif int(aux) == 5:
    f = Cap.capFile("Elige un Archivo: ",
                    r'C:\Users\EnrickMC\Desktop\POO\Lista_Articulo Python',
                    '.csv')
    print("El archivo es:", f)

elif int(aux) == 6:
    f = Cap.capFile("Elige un Archivo: ", '.csv')
    print("El archivo es:", f)

elif int(aux) == 7:
    opciones = ["Kg (Kilogramos)", "Lt (Litros)", "Cm (Centímetros)", "U (Unidades)", "T (Toneladas)"]
    l = Cap.capList("Selecciona una opción:", opciones)
    print("La opción seleccionada es: " + l)
