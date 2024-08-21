from multipledispatch import dispatch
from datetime import datetime

# -------------------------------------------------MISCELÁNEO------------------------------------------------- #
# ------------------------------------------------------------------------------------------------------------ #


class Miscellaneous:

    def __init__(self) -> None:
        pass

    @dispatch(str)
    def readFile(self, linea, directorio) -> str:
        """Método para leer una línea en un archivo csv/txt.
        Recibe la dirección de un archivo para su funcionamiento.
        :param directorio: La ruta/dirección del archivo que se va a leer.
        :param linea: El número de la línea específica que se va a leer.
        :return: La línea específica (en formato String) dentro del archivo."""
        with open(directorio, 'r') as archivo:
            for i, contenido in enumerate(archivo):
                if i == linea:
                    return contenido.strip()
        return None

    @dispatch(str)
    def readFile(self, directorio) -> str:
        """Método para leer archivos csv/txt, adjuntando los datos en líneas de texto.
        Recibe la dirección de un archivo para su funcionamiento.
        :param directorio: La ruta/dirección del archivo que se va a leer.
        :return: Lista con todas las cadenas (en formato String) dentro del archivo."""
        with open(directorio, 'r') as archivo:
            lineas = archivo.readlines()
        return [linea.strip() for linea in lineas]

    @dispatch(str, str)
    def writeFile(self, cadena, directorio):
        """Método para escribir sobre archivos csv/txt.
        Recibe la dirección de un archivo nuevo o existente para su funcionamiento.
        Si el archivo no existe, se creará; si existe, se abrirá para agregar texto.
        :param cadena: Es la línea completa (en formato String) que se va a agregar.
        :param directorio: La ruta/dirección del archivo en el cual se va a escribir."""
        with open(directorio, 'a') as writer:
            writer.write(cadena + "\n")
        print("Los datos se guardaron correctamente en el archivo.")

    @dispatch(str)
    def convertDate(self, date) -> str:
        """Método para convertir la fecha a un formato específico.
        :param date: La fecha que se quiera reformatear.
        :return: La fecha con el formato establecido o None si no se puede convertir."""
        formatos = ["%d.%m.%y", "%d-%m-%y", "%d.%m.%Y", "%d-%m-%Y", "%d/%m/%y", "%d/%m/%Y", "%d/%m/%Y", "%d/%m/%Y"]
        for formato in formatos:
            try:
                parsed_date = datetime.strptime(date, formato)
                return parsed_date.strftime("%d/%m/%Y")
            except ValueError:
                continue
        return None

