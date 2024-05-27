from multipledispatch import dispatch


class Miscelaneo:

    # -------------------------------------------------MISCELÁNEO------------------------------------------------- #
    # ------------------------------------------------------------------------------------------------------------ #

    def __init__(self) -> None:
        pass

    # Método para leer archivos csv/txt, adjuntando los datos en líneas de texto
    # Recibe la dirección de un archivo para su funcionamiento
    def readFile(self, directorio) -> str:
        with open(directorio, 'r') as archivo:
            lineas = archivo.readlines()
        return [linea.strip() for linea in lineas]

    # Método para escribir sobre archivos csv/txt
    # Recibe la dirección de un archivo nuevo o existente para su funcionamiento
    @dispatch(str, str)
    def writeFile(self, cadena, directorio):
        with open(directorio, 'a') as writer:
            writer.write(cadena + "\n")
        print("El texto se ha guardado correctamente en el archivo.")
