from utilFilesPython.PythonCap import *
from utilFilesPython.Miscellaneous import *

Cap = PythonCap()
Mis = Miscellaneous()


def testPythonCap(aux):
    if int(aux) == 0:
        # cap Genérico
        s = Cap.cap("mensaje")
        print(s)
    elif int(aux) == 1:
        # capInt
        x1 = Cap.capInt("Entero")
        # capInt Limite
        x2 = Cap.capInt("Entero, lim?", 0)
        # capInt Rango
        x3 = Cap.capInt("Entero, LimI?, LimS?", 0, 10)
        print(x1 + x2 + x3)
    elif int(aux) == 2:
        # capReal
        y1 = Cap.capReal("Real")
        # capReal limite
        y2 = Cap.capReal("Real, lim?", 0)
        # capReal Rango
        y3 = Cap.capReal("Real, LimI?, LimS?", 0, 1)
        print(y1 + y2 + y3)
    elif int(aux) == 3:
        # capNom
        n1 = Cap.capNom("Cadena")
        # capNom Limite
        n2 = Cap.capNom("Cadena, LimC?", 10)
        print(n1 + n2)
    elif int(aux) == 4:
        # capDate
        d = Cap.capDate("Fecha")
        print(d)
    elif int(aux) == 5:
        # capDir
        c = Cap.capDir("Directorio")
        print(c)
    elif int(aux) == 6:
        # capFile Genérico
        f1 = Cap.capFile('.csv')
        for files in f1:
            print(files)
        # capFile sin Directorio
        f2 = Cap.capFile("Mensaje, Extension", '.csv')
        print(f2)
        # capFile con Directorio
        f3 = Cap.capFile("mensaje, Directorio, Extension", r'C:\Users\EnrickMC\Desktop\POO\Lista_Articulo Python', '.csv')
        print(f3)
    elif int(aux) == 7:
        opciones = ["Opcion A", "Opcion B", "Opcion C", "Opcion D"]
        o1 = Cap.capList("Lista, Opciones", opciones)
        o2 = Cap.capList("Lista de Opciones", ["Opción A", "Opción B", "Opción C", "Opcion D"])
        print(o1 + o2)


def testMiscellaneous(aux):
    if int(aux) == 0:
        # writeFile
        datos = "Opcion A, Opcion B, Opcion C, Opcion D"
        Mis.writeFile(str(datos), os.path.join(os.path.dirname(os.path.abspath(__file__)), "Nombre_Archivo" + ".csv"))
    elif int(aux) == 1:
        # readFile Especifico
        a1 = Mis.readFile(2, os.path.join(os.path.dirname(os.path.abspath(__file__)), "Nombre_Archivo" + ".csv"))
        # readFile Completo
        a2 = Mis.readFile(os.path.join(os.path.dirname(os.path.abspath(__file__)), "Nombre_Archivo" + ".csv"))
    elif int(aux) == 3:
        # convertDate
        Date = Mis.convertDate(Cap.capDate("Fecha"))
        print(Date)


class Main:
    testPythonCap(0)
    testMiscellaneous(0)
