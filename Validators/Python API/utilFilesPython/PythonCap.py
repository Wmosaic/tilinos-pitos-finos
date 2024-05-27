from multipledispatch import dispatch
from datetime import datetime
from utilFilesPython.PythonVal import *
from math import trunc
from pathlib import Path
from os import listdir


# Instalar desde el cmd: (pip install multipledispatch)
# Para el correcto funcionamiento de esta clase
# y hacer posible que los métodos sean sobrecargados


class PythonCap:

    # -------------------------------------------------INPUT------------------------------------------------------ #
    # ------------------------------------------------------------------------------------------------------------ #

    @dispatch()
    def __init__(self) -> None:
        self.__Val = PythonVal()

    @dispatch(object)
    def __init__(self, objetoValidador) -> None:
        self.__objV = objetoValidador

    # Método para capturar un número entero
    @dispatch(str)
    def capInt(self, mensaje) -> int:
        aux = input(mensaje+"\n")

        while not (self.__Val.isNum(aux)):
            aux = input(mensaje+"\n")

        return trunc(float(aux))

    # Método para capturar un número entero dentro de un limite determinado
    @dispatch(str, int)
    def capInt(self, mensaje, lim) -> int:
        aux = self.capInt(mensaje+"\n")

        while aux < lim:
            aux = self.capInt(mensaje + "(No menor a " + str(lim) + ")")

        return trunc(float(aux))

    # Método para capturar un número entero dentro de un rango determinado
    @dispatch(str, int, int)
    def capInt(self, mensaje, limI, limS) -> int:
        aux = self.capInt(mensaje+"")

        while not (limI <= aux <= limS):
            aux = self.capInt(mensaje + "(Entre " + str(limI) + " y " + str(limS) + ")")

        return aux

    #  Método para capturar un número racional
    @dispatch(str)
    def capReal(self, mensaje) -> int:
        aux = input(mensaje+"\n")

        while not (self.__Val.isNum(aux)):
            aux = input(mensaje+"\n")

        return float(aux)

    # Método para capturar un número racional dentro de un limite determinado
    @dispatch(str, float)
    def capReal(self, mensaje, lim) -> float:
        aux = self.capReal(mensaje)

        while aux < lim:
            aux = self.capReal(mensaje + "(No menor a " + str(lim) + ")")

        return aux

    # Método para capturar un número entero dentro de un rango determinado
    @dispatch(str, float, float)
    def capReal(self, mensaje, limI, limS) -> int:
        aux = self.capReal(mensaje)

        while not (limI <= aux <= limS):
            aux = self.capReal(mensaje + "(Entre " + str(limI) + " y " + str(limS) + ")")

        return aux

    # Método para capturar solamente una cadena de texto
    @dispatch(str)
    def capNom(self, mensaje) -> str:
        aux = input(mensaje+"\n")

        while not (self.__Val.isNom(aux)):
            aux = input(mensaje+"\n")

        return aux.strip()

    # Método para capturar una cadena de texto con un límite de caracteres
    @dispatch(str, int)
    def capNom(self, mensaje, limC) -> str:
        aux = self.capNom(mensaje)

        while not (len(aux) < limC):
            aux = self.capNom(mensaje + "(Menor a " + str(limC) + " Caracteres)")

        return aux

    # Método para capturar una fecha
    def capDate(self, mensaje) -> str:
        fecha = input(mensaje+"\n")

        while not (self.__Val.isDate(fecha)):
            fecha = input("Fecha Invalida) " + mensaje+"\n")

        fechaFormateada = datetime.strptime(fecha, '%d/%m/%Y')
        return datetime.strftime(fechaFormateada, '%d/%m/%Y')

    # Método para capturar un directorio
    def capDir(self, mensaje) -> str:
        aux = input(mensaje+"\n")

        while not (self.__Val.isDir(aux)):
            aux = input(mensaje+"\n")

        return Path(aux).as_posix().replace('"', '')

    # -Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    # -extension validada, responsabilidad del programador
    @dispatch(str, str)
    def capFile(self, mensaje, extension) -> str:
        misfiles = listdir(self.capDir("Ingresa un Directorio: "))
        myNewFiles = [file for file in misfiles if file.lower().endswith(extension)]

        index = self.capList(mensaje, myNewFiles)

        return Path(directorio + "/" + index)

    # -Método para capturar un archivo de un tipo de extension (Desplegable en una lista).
    # -Directorio y extension validados, responsabilidad del programador
    @dispatch(str, str, str)
    def capFile(self, mensaje, directorio, extension) -> str:
        print(mensaje)
        misfiles = listdir(directorio)
        myNewFiles = [file for file in misfiles if file.lower().endswith(extension)]

        index = self.capList(mensaje, myNewFiles)

        return Path(directorio + "/" + index)

    # Método para desplegar una lista
    def capList(self, mensaje, opciones) -> str:
        if opciones is not None:
            for i, opcion in enumerate(opciones):
                print(f"{i + 1} - {opcion}")
            index = self.capInt(mensaje, 1, len(opciones))
            return opciones[index - 1]
        print("No hay opciones disponibles")
        return opciones
