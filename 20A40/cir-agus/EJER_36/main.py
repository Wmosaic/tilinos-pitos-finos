import sys
sys.path.append("PythonAPI")
from Administrador import Administrador,Empleado
from PythonAPI.Capturas import Capturas
from os import system

Cap = Capturas()

def meta() -> None:
   print("Capturar, calcular y desplegar datos de empleados y adminstradores")
   print("Totalizando los salarios, bonos y el total de ambos")
   print("-"*50)

def datos() -> list:
    Nomina = []
    
    for _ in range(0,100,1):
        opc = Cap.capCade("Capture su tipo N)ormal/ A)dmin/ F)in?: ",1)
        if opc.upper() == "F" or (opc.upper() != "N" and opc.upper() != "A"): 
            break
        nome = Cap.capCade("Deme su Nombre: ",40)
        sala = Cap.capReal("Deme el salario: ",1.0)
        fnac = Cap.capDate("Deme la fecha de nacimiento: ")
        if opc.upper() == "A":
            depat = Cap.capCade("Deme el departamento: ",40)
            bonos = Cap.capReal("Deme su bono: ",1.0)
            Nomina.append(Administrador(nome,sala,fnac,depat,bonos))
        if opc.upper() == "N":
            Nomina.append(Empleado(nome,sala,fnac))
    
    return Nomina

def calculos(nominas) -> list:
    sumaNominas,sumaBonos = 0.0,0.0
    
    for i in range(0,len(nominas),1):
        if isinstance(nominas[i], Administrador):
            sumaBonos += nominas[i].getBono()
        sumaNominas += nominas[i].getSalario()
    total = sumaBonos + sumaNominas
    
    return total,sumaNominas,sumaBonos

def salida(nominas,total,sumaNominas,sumaBonos) -> None:
    print("-"*50)
    print("Para los empleados de la empresa.")
    
    for i in range(0,len(nominas),1):
        if isinstance(nominas[i], Administrador):
            print("Datos del admistrador: ")
            print(nominas[i].toString())
            print("-"*50)
        else:
            print("Datos del empleado: ")
            print(nominas[i].toString())
            print("-"*50)
            
    print("Los valores totalizados.")
    print("Total de salarios: "+str(sumaNominas))
    print("Total de Bonos: "+str(sumaBonos))
    print("Total de Nominas y Bonos: "+str(total))
    print("-"*50)
        
def main() -> None:
    system("cls")
    meta()
    nominas = datos()
    tota,sNomi,sumBono = calculos(nominas)
    salida(nominas,tota,sNomi,sumBono)
    print("Ha finalizado el programa")

main()

if __name__ == "__main()__":
    main()