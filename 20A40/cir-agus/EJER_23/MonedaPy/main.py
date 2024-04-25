import sys
from pathlib import Path
sys.path.append("C:\\Users\\Luis.Luisss\\Documentos\\Programacion\\Tilinos\\tilinos-pitos-finos\\")
sys.path.append("C:\\Users\\Luis.Luisss\\Documentos\\Programacion\\Tilinos\\tilinos-pitos-finos\\Validators\\PythonAPI")
from Validators.PythonAPI.Validador import Validador
from Validators.PythonAPI.Capturas import Capturas
from Validators.PythonAPI.utilPyFile import utilPyFile
from Moneda import Moneda

val = Validador()
Monedero = []
repeticionMoneda = []

def meta() -> None:
    print("Capturar y desplegar una lista de monedas")
    print("Presentes dentro de un monedero totalizando")
    print("las monedas presentes dentro de cada divisa")
    print("Por captura de datos Centinelas o CSV")

def capturaManual() -> None:
    Cap = Capturas(val)
    print("Capture las Caracteristicas de sus Monedas")
    print("-"*50)
    
    for _ in range(0,50,1):
        divisa = Cap.capCade("Deme el nombre de la divisa o fin: ",40)
        if divisa.lower() == "fin": break
        valor = Cap.capReal("Capture el valor: ",1.0)
        pais = Cap.capCade("Capture el pais de procedencia: ",40)
        año = Cap.capInte("Capture el año: ",1000)
        Escudo = Cap.capCade("Capture como se llama el Escudo: ",40)
        mones = Cap.capInte("¿Cuantas veces se repite la moneda?: ",1)
        repeticionMoneda.append(mones)
        Monedero.append(Moneda(divisa,valor,pais,año,Escudo))

def capturaFichero() -> None:
    utilFile = utilPyFile()
    
    miArchivo = utilFile.capFile(".csv")
    val.valCSV(miArchivo)
    
    with open(miArchivo,"r",encoding='UTF-8') as fileCSV:
        fileCSV.readline()
        for linea in fileCSV:
            listaStringTemp = linea.rsplit(',')
            divisa = str(listaStringTemp[0])
            valor = float(listaStringTemp[1])
            pais = str(listaStringTemp[2])
            año = int(listaStringTemp[3])
            escudo = str(listaStringTemp[4])
            repeticionMoneda.append(int(listaStringTemp[5]))
            Monedero.append(Moneda(divisa,valor,pais,año,escudo))	

def setMonedas():
    newMonedas = []
    
    for i in range(0,len(Monedero),1):
        if Monedero[i].getDivisa() not in newMonedas:
            newMonedas.append(Monedero[i].getDivisa())
            
    return newMonedas

def calculos():
    newMonedas = setMonedas()
    
    subTotal = []
    totalPorDivisa = []
    
    for i in range(0,len(newMonedas),1):
        dineros = 0
        for j in range(0,len(Monedero),1):
            if newMonedas[i] == Monedero[j].getDivisa():
                dineros += repeticionMoneda[j] * Monedero[j].getValor()
        totalPorDivisa.append(dineros)
    
    for k in range(0,len(Monedero),1): 
        subTotal.append(repeticionMoneda[k]*Monedero[k].getValor())
    
    return subTotal,totalPorDivisa,newMonedas

def salida(subtotalDivisa,totalDivisa,newMonedas):
    print("-"*50)
    for i in range(0,len(Monedero),1):
        print(Monedero[i].toString())
        print("Hubo un total de: ",repeticionMoneda[i]," Elementos repetidos")
        print("En subtotal hay: ",subtotalDivisa[i])
        print("-"*50)
    
    for r in range(0,len(totalDivisa),1):
        print("De la divisa: "+str(newMonedas[r]),end="")
        print("Hubo un total de: "+str(totalDivisa[r]))
        
        
def main():
    meta()
    capturaManual()
    sub,tota,newDivi = calculos()
    salida(sub,tota,newDivi)

main()

if __name__ == "main":
    main()