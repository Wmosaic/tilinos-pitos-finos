from datetime import datetime

class Empleado:
    def __init__(self):
        self.nombre = ""
        self.salario = 0.0
        self.fecha_nacimiento = None

    def __init__(self, nombre, salario, fecha_nacimiento):
        self.set_nombre(nombre)
        self.set_salario(salario)
        self.set_fecha_nacimiento(fecha_nacimiento)

    def __init__(self, nombre, salario):
        self.set_nombre(nombre)
        self.set_salario(salario)

    def __init__(self, nombre):
        self.set_nombre(nombre)

    def set_nombre(self, nombre):
        if nombre and nombre.strip():
            self.nombre = nombre
            return True
        return False

    def set_fecha_nacimiento(self, fecha_nacimiento):
        if isinstance(fecha_nacimiento, datetime):
            self.fecha_nacimiento = fecha_nacimiento
            return True
        return False

    def set_salario(self, salario):
        if salario >= 0:
            self.salario = salario
            return True
        return False

    def get_nombre(self):
        return self.nombre

    def get_salario(self):
        return self.salario

    def get_fecha_nacimiento(self):
        return self.fecha_nacimiento

    def get_details(self):
        details = "Nombre: {}\nSalario: {}".format(self.nombre, self.salario)
        if self.fecha_nacimiento:
            details += "\nFecha de nacimiento: {}".format(self.fecha_nacimiento.strftime("%d/%m/%Y"))
        return details