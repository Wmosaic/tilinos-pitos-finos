from datetime import datetime
from os import listdir, abort
from pathlib import PureWindowsPath
import os


class PythonVal:
    def __init__(self) -> None:
        pass

    # Método validador para datos numéricos
    def isNum(self, cadena) -> bool:
        try:
            float(cadena)
            return True
        except:
            return False

    # Método validador para cadena Pura (sin caracteres o números)
    def isNom(self, cadena) -> bool:
        listaStrings = cadena.rsplit()
        aux = True

        if len(cadena) != 0 and len(listaStrings) != 0:
            for elementos in listaStrings:
                if not (elementos.isalpha() or elementos.isspace()):
                    aux = False
                    break
        else:
            return False
        return aux

    # Método para validar la fecha ingresada
    def isDate(self, cadena):
        try:
            datetime.strptime(cadena, '%d/%m/%Y')
            return True
        except ValueError:
            return False

    # Método para validar un directorio
    def isDir(self, cadena):
        try:
            os.listdir(cadena)
            return True
        except (FileNotFoundError, OSError, UnicodeDecodeError):
            return False
