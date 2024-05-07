from multipledispatch import dispatch
from datetime import datetime
from PythonVal import PythonVal
from math import trunc
from pathlib import Path
from os import listdir


# Instalar desde la terminal utilizada: (pip install multipledispatch)
# Para el correcto funcionamiento de esta clase
# y hacer posible que los métodos sean sobrecargados


class PythonCap:
    @dispatch()
    def __init__(self) -> None:
        self.__Val = PythonVal()

    @dispatch(object)
    def __init__(self, objetoValidador) -> None:
        self.__objV = objetoValidador

    # Método para capturar un número entero
    @dispatch(str)
    def capInt(self, mensaje) -> int:
        aux = input(mensaje)

        while not (self.__Val.isNum(aux)):
            aux = input(mensaje)

        return trunc(float(aux))

    # Método para capturar un número entero dentro de un limite determinado
    @dispatch(str, int)
    def capInt(self, mensaje, lim) -> int:
        aux = self.capInt(mensaje)

        while aux < lim:
            aux = self.capInt(mensaje + "(El numero debe ser mayor a" + str(lim) + ")")

        return trunc(float(aux))

    # Método para capturar un número entero dentro de un rango determinado
    @dispatch(str, int, int)
    def capInt(self, mensaje, limI, LimS) -> int:
        aux = self.capInt(mensaje)

        while not (limI <= aux <= LimS):
            aux = self.capInt("El numero debe estar entre (" + str(limI) + " y " + str(LimS) + "):\n")

        return aux

    #  Método para capturar un número racional
    @dispatch(str)
    def capReal(self, mensaje) -> int:
        aux = input(mensaje)

        while not (self.__Val.isNum(aux)):
            aux = input(mensaje)

        return float(aux)

    # Método para capturar un número racional dentro de un limite determinado
    @dispatch(str, float)
    def capReal(self, mensaje, lim) -> float:
        aux = self.capReal(mensaje)

        while aux < lim:
            aux = self.capReal(mensaje + "El numero debe ser mayor a " + str(lim) + ": ")

        return aux

    # Método para capturar un número entero dentro de un rango determinado
    @dispatch(str, float, float)
    def capReal(self, mensaje, limI, LimS) -> int:
        aux = self.capReal(mensaje)

        while not (limI <= aux <= LimS):
            aux = self.capReal("El numero debe estar entre (" + str(limI) + " y " + str(LimS) + "):\n")

        return aux

    # Método para capturar solamente una cadena de texto
    @dispatch(str)
    def capNom(self, mensaje) -> str:
        aux = input(mensaje)

        while not (self.__Val.isNom(aux)):
            aux = input(mensaje)

        return aux

    # Método para capturar una cadena de texto con un límite de caracteres
    @dispatch(str, int)
    def capNom(self, mensaje, limC) -> str:
        aux = self.capNom(mensaje)

        while not (len(aux) < limC):
            aux = self.capNom(mensaje + "(Menor a " + str(limC) + " Caracteres):\n")

        return aux

    # Método para capturar una fecha
    def capDate(self, mensaje) -> str:
        fecha = input(mensaje)

        while not (self.__Val.isDate(fecha)):
            fecha = input(mensaje)

        fechaFormateada = datetime.strptime(fecha, '%d/%m/%Y')
        return datetime.strftime(fechaFormateada, '%d/%m/%Y')

    # Método para capturar un directorio
    def capDir(self, mensaje) -> str:
        aux = input(mensaje)

        while not (self.__Val.isDir(aux)):
            aux = input(mensaje)

        return Path(aux).as_posix().replace('"', '')

    # -Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    # -Directorio y extension validados, responsabilidad del programador
    @dispatch(str, str, str)
    def capFile(self, mensaje, directorio, extension) -> str:
        print(mensaje)
        misfiles = listdir(directorio)
        myNewFiles = [file for file in misfiles if file.lower().endswith(extension)]

        for i in range(0, len(myNewFiles), 1):
            print("{:d}.{}".format(i + 1, myNewFiles[i]))

        index = self.capInt("Seleccione su archivo por numero: ", 1, len(myNewFiles))

        return Path(directorio + "/" + myNewFiles[index - 1])
