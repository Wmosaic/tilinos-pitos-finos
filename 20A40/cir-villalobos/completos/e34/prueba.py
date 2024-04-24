from Empleado import Empleado
from Administrador import Administrador
from datetime import datetime

nombreGenerico1 = "Jose"
nombreGenerico2 = "Carlos"

salario1 = 200
salario2 = 350

fecha1 = datetime(2024, 4, 17)
fecha2 = datetime(2023, 7, 22)

bono = 9999
depto = "kkkfoda"

emple = Empleado(nombreGenerico1, salario1, fecha1)
admin = Administrador(nombreGenerico2, salario2, fecha2 , depto, bono)

print(emple.toString())
print(admin.toString())
