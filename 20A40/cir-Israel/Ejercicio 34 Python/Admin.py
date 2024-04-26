from Empleado import Empleado

class Admin(Empleado):
    def __init__(self):
        super().__init__()
        self.department = ""
        self.bono = 0.0

    def __init__(self, nombre, salario, fecha_nacimiento, dept, bono):
        super().__init__(nombre, salario, fecha_nacimiento)
        self.set_depto(dept)
        self.set_bono(bono)

    def __init__(self, nombre, salario, dept, bono):
        super().__init__(nombre, salario)
        self.set_depto(dept)
        self.set_bono(bono)

    def __init__(self, nombre, dept, bono):
        super().__init__(nombre)
        self.set_depto(dept)
        self.set_bono(bono)

    def __init__(self, dept, bono):
        super().__init__()
        self.set_depto(dept)
        self.set_bono(bono)

    def __init__(self, n, s, y, m, d, dep, bono):
        super().__init__(n, s, y, m, d)
        self.set_depto(dep)
        self.set_bono(bono)

    def set_bono(self, b):
        if b > 0:
            self.bono = b
            return True
        return False

    def set_depto(self, d):
        if d and d.strip():
            self.department = d
            return True
        return False

    def get_department(self):
        return self.department

    def get_bono(self):
        return self.bono

    def get_details(self):
        return super().get_details() + "\nDepartment: {}\nBonus: {}".format(self.department, self.bono)