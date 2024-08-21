from multipledispatch import dispatch
from datetime import datetime
from os import listdir, abort
from pathlib import PureWindowsPath
import os

# -----------------------------------------------VALIDATORS--------------------------------------------------- #
# ------------------------------------------------------------------------------------------------------------ #


class PythonVal:

    def __init__(self) -> None:
        pass

    @dispatch(str)
    def isNum(self, cadena) -> bool:
        """Método para validar números naturales"""
        try:
            float(cadena)
            return True
        except:
            return False

    @dispatch(str)
    def isNom(self, cadena) -> bool:
        """Método para validar cadenas de caracteres sin números"""
        return all(char.isalpha() or char.isspace() for char in cadena)

    @dispatch(str)
    def isDate(self, cadena) -> bool:
        """Método para validar una fecha en diferentes formatos"""
        formatos = ["%d.%m.%y", "%d-%m-%y", "%d.%m.%Y", "%d-%m-%Y", "%d/%m/%y", "%d/%m/%Y"]

        for formato in formatos:
            if PythonVal.isDateFormat(cadena, formato):
                return True
        return False

    @dispatch(str, str)
    def isDateFormat(self, cadena, formato) -> bool:
        """Método para validar una fecha"""
        try:
            datetime.strptime(cadena, formato)
            return True
        except ValueError:
            return False

    @dispatch(str)
    def isStr(self, cadena) -> bool:
        """Método para validar cadenas de texto vaciás o nulas"""
        if not isinstance(cadena, str) or cadena.strip() == "":
            return False
        return True

    @dispatch(str)
    def isDir(self, cadena):
        """Método para validar un directorio"""
        try:
            os.listdir(cadena)
            return True
        except (FileNotFoundError, OSError, UnicodeDecodeError):
            return False
