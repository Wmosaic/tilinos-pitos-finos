from multipledispatch import dispatch
from utilFilesPython.PythonVal import *
from math import trunc
from os import listdir
from os.path import basename, join
from pathlib import Path

# Instalar desde el cmd: (pip install multipledispatch)
# Para el correcto funcionamiento de esta clase
# y hacer posible que los métodos sean sobrecargados

# ---------------------------------------------------INPUT------------------------------------------------------ #
# ---------------------todos los capturadores de esta clase hacen uso del multipledispatch---------------------- #


class PythonCap:

    @dispatch()
    def __init__(self) -> None:
        self.__Val = PythonVal()

    @dispatch(object)
    def __init__(self, objetoValidador) -> None:
        self.__objV = objetoValidador

    @dispatch(str)
    def cap(self, mensaje) -> int:
        """Método para capturar cualquier cadena de caracteres.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :return: La cadena de caracteres capturada y validada."""
        aux = input(mensaje + "\n")

        while not (self.__Val.isStr(aux)):
            aux = input(mensaje + "\n")

        return aux.strip()

    @dispatch(str)
    def capInt(self, mensaje) -> int:
        """ Método para capturar solamente números enteros
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada
        :return: El número entero capturado y validado."""
        aux = input(mensaje + "\n")

        while not (self.__Val.isNum(aux)):
            aux = input(mensaje + "\n")

        return trunc(float(aux))

    @dispatch(str, int)
    def capInt(self, mensaje, lim) -> int:
        """Método para capturar solamente números enteros con un límite determinado.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param lim: Indica el límite inferior de los valores que no se podrán capturar.
        :return: El número entero capturado y validado dentro del límite especificado."""
        aux = self.capInt(mensaje + "\n")
        while aux < lim:
            aux = self.capInt(mensaje + "(No menor a " + str(lim) + ")")

        return aux

    @dispatch(str, int, int)
    def capInt(self, mensaje, limI, limS) -> int:
        """Método para capturar solamente números enteros dentro de un rango determinado.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param limI: Indica el límite inferior de los valores que no se podrán capturar.
        :param limS: Indica el límite superior de los valores que no se podrán capturar.
        :return: El número entero capturado y validado dentro del rango especificado."""
        aux = self.capInt(mensaje + "")
        while not (limI <= aux <= limS):
            aux = self.capInt(mensaje + "(Entre " + str(limI) + " y " + str(limS) + ")")

        return aux

    @dispatch(str)
    def capReal(self, mensaje) -> float:
        """Método para capturar solamente números racionales.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :return: El número racional capturado y validado."""
        aux = input(mensaje + "\n")

        while not (self.__Val.isNum(aux)):
            aux = input(mensaje + "\n")

        return float(aux)

    @dispatch(str, float)
    def capReal(self, mensaje, lim) -> float:
        """Método para capturar solamente números racionales con un límite determinado.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param lim: Indica el límite inferior de los valores que no se podrán capturar.
        :return: El número racional capturado y validado dentro del límite especificado"""
        aux = self.capReal(mensaje)
        while aux < lim:
            aux = self.capReal(mensaje + "(No menor a " + str(lim) + ")")

        return aux

    @dispatch(str, float, float)
    def capReal(self, mensaje, limI, limS) -> float:
        """Método para capturar solamente números racionales dentro de un rango determinado.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param limI: Indica el límite inferior de los valores que no se podrán capturar.
        :param limS: Indica el límite superior de los valores que no se podrán capturar.
        :return: El número racional capturado y validado dentro del rango especificado."""
        aux = self.capReal(mensaje)
        while not (limI <= aux <= limS):
            aux = self.capReal(mensaje + "(Entre " + str(limI) + " y " + str(limS) + ")")

        return aux

    @dispatch(str)
    def capNom(self, mensaje) -> str:
        """Método para capturar una cadena sin caracteres numéricos.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :return: La cadena de texto capturada y validada sin caracteres numéricos."""
        aux = input(mensaje + "\n")

        while not self.__Val.isStr(aux) or not self.__Val.isNom(aux):
            aux = input(mensaje + "\n")

        return aux.strip()

    @dispatch(str, int)
    def capNom(self, mensaje, limC) -> str:
        """Método para capturar una cadena de texto con un límite de caracteres.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param limC: Indica el límite en la cantidad de caracteres capturados.
        :return: La cadena de texto capturada y validada sin caracteres numéricos."""
        aux = self.capNom(mensaje)

        while not (len(aux) < limC):
            aux = self.capNom(mensaje + "(Menor a " + str(limC) + " Caracteres)")

        return aux

    @dispatch(str)
    def capDate(self, mensaje) -> str:
        """Método para capturar una fecha.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :return: La fecha capturada y validada como cadena."""
        aux = input(mensaje + "\n")

        while not (self.__Val.isDate(aux)):
            aux = input("(Fecha Invalida) " + mensaje + "\n")

        return aux

    @dispatch(str)
    def capDir(self, mensaje) -> str:
        """Método para capturar un directorio.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :return: La ruta del directorio capturada y validada como cadena."""
        aux = input(mensaje + "\n")

        while not self.__Val.isStr(aux) or not self.__Val.isDir(aux):
            aux = input(mensaje + "\n")

        return Path(aux).as_posix().replace('"', '')

    @dispatch(str)
    def capFile(self, extension) -> list:
        """Método para capturar todos los archivos de un solo tipo de extensión.
        :param extension: El tipo de extensión de los archivos que se van a capturar.
        :return: Una lista con las rutas completas de los archivos filtrados por extension."""
        # Esta parte filtra los archivos y los añade en una nueva lista
        # Agrega cada "file" en "directorio" Si los archivos son de la extension específica
        # Combina el directorio con el nombre del archivo y extension
        # listdir para especificar que se trata de un directorio (y funcione correctamente)
        directorio = self.capDir("Ingresa un Directorio: ")
        return [join(directorio, file) for file in listdir(directorio) if file.lower().endswith(extension)]

    @dispatch(str, str)
    def capFile(self, mensaje, extension) -> str:
        """Método para capturar un archivo de un tipo de extensión (Desplegable en una lista).
        La extensión es responsabilidad del programador.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param extension: El tipo de extensión del archivo que se va a capturar.
        :return: La dirección completa del archivo seleccionado."""
        files = self.capFile(extension)

        # Este bucle se repetirá hasta que se encuentre al menos un archivo con la extensión específica
        while not files:
            print("No se encontraron archivos válidos en este directorio")
            files = self.capFile(extension)
            
        # Se despliega una lista con los archivos almacenados en la lista
        nomFile = [basename(file) for file in files]
        archivoSeleccionado = self.capList(mensaje, nomFile)

        # Se comprueba si el archivo existe y se retorna la dirección completa
        for file in files:
            if basename(file) == archivoSeleccionado:
                # Retorna la dirección completa del archivo seleccionado
                return str(Path(file).resolve())

        print("No se encontró el archivo seleccionado.")
        return None

    @dispatch(str, str, str)
    def capFile(self, mensaje, directorio, extension) -> str:
        """Método para capturar un archivo de un tipo de extensión (Desplegable en una lista).
        El directorio y la extensión son responsabilidad del programador.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param directorio: La ruta/dirección donde se buscarán los archivos.
        :param extension: El tipo de extensión del archivo que se va a capturar.
        :return: El archivo capturado y validado como una cadena."""
        # Esta parte filtra los archivos y los añade en una nueva lista
        files = [join(directorio, file) for file in listdir(directorio) if file.lower().endswith(extension)]

        # Este bucle se repetirá hasta que se encuentre al menos un archivo con la extensión específica
        while not files:
            print("No se encontraron archivos validos en este directorio")
            files = self.capFile(extension)

        # Se despliega una lista con los archivos almacenados
        nomFile = [basename(file) for file in files]
        archivoSeleccionado = self.capList(mensaje, nomFile)

        # Se comprueba si el archivo existe y se retorna la dirección completa
        for file in files:
            if basename(file) == archivoSeleccionado:
                # Retorna la dirección completa del archivo seleccionado
                return str(Path(file).resolve())

        print("No se encontró el archivo seleccionado.")
        return None

    @dispatch(str, list)
    def capList(self, mensaje, opciones) -> str:
        """Método para desplegar una lista.
        :param mensaje: Cadena de texto que se mostrará al usuario solicitando la entrada.
        :param opciones: Lista de opciones a desplegar.
        :return: La opción seleccionada por el usuario como una cadena."""
        if opciones is not None:
            for i, opcion in enumerate(opciones):
                print(f"{i + 1} - {opcion}")
            index = self.capInt(mensaje, 1, len(opciones))
            return opciones[index - 1]
        print("No hay opciones disponibles")
        return opciones
