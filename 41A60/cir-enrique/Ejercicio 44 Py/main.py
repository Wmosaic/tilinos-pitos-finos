import sys
from os import system
sys.path.append("PythonAPI")
from pathlib import Path
from PythonAPI.Capturas import Capturas
from PythonAPI.utilPyFile import utilPyFile
from Moneda import Moneda

Cap = Capturas()
utilFile = utilPyFile()
guion = "-"*50

def meta() -> None:
    print("Capturar y desplegar una lista de monedas")
    print("Presentes dentro de un monedero totalizando")
    print("las monedas presentes dentro de cada divisa")
    print("Por captura de datos Centinelas o CSV")
    print(guion)

def capturaManual() -> list:
    Monedero = []
    repeticionMoneda = []
    print("\nCapture las Caracteristicas de sus Monedas")
    print(guion)
    
    for _ in range(0,50,1):
        divisa = Cap.capCade("Deme el nombre de la divisa o fin: ",40)
        if divisa.lower() == "fin": break
        valor  = Cap.capReal("Capture el valor: ",1.0)
        pais   = Cap.capCade("Capture el pais de procedencia: ",40)
        año    = Cap.capInte("Capture el año: ",1000)
        Escudo = Cap.capCade("Capture como se llama el Escudo: ",40)
        mones  = Cap.capInte("¿Cuantas veces se repite la moneda?: ",1)
        repeticionMoneda.append(mones)
        Monedero.append(Moneda(divisa,valor,pais,año,Escudo))
    
    print(guion)
    print("Yeah")
    return Monedero,repeticionMoneda

def capturaFichero() -> list:
    Monedero = []
    repeticionMoneda = []
    miArchivo = utilFile.capFile(".csv")
    
    with open(miArchivo,"r",encoding='UTF-8') as fileCSV:
        fileCSV.readline()
        for linea in fileCSV:
            listaStringTemp = linea.rsplit(',')
            divisa = str(listaStringTemp[0])
            valor  = float(listaStringTemp[1])
            pais   = str(listaStringTemp[2])
            año    = int(listaStringTemp[3])
            escudo = str(listaStringTemp[4])
            repeticionMoneda.append(int(listaStringTemp[5]))
            Monedero.append(Moneda(divisa,valor,pais,año,escudo))	
    print(guion)
    print("Leyendos archivos")
    return Monedero,repeticionMoneda
    
def setMonedas(Monedero) -> list:
    newMonedas = []
    
    for i in range(0,len(Monedero),1):
        if Monedero[i].getDivisa() not in newMonedas: 
            newMonedas.append(Monedero[i].getDivisa())
            
    return newMonedas

def calculos(Monedero,repeticionMoneda) -> list:
    newMonedas = setMonedas(Monedero)
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
    
    return [subTotal,totalPorDivisa,newMonedas]

def generarCarpeta() -> Path: 
    archivo = Path(input("Deme el nombre se su archivo: "))
    opc = Cap.capCade("¿Ya tiene una carpeta?[S/N]: ")
    
    if opc.lower() == 's': 
        ruta = Path(utilFile.capDir())
    else: 
        while True:
            ruta = Path(input("Deme el nombre de la carpeta: "))
            try:
                ruta.mkdir(parents=False,exist_ok=False)
                break
            except FileExistsError:
                print("La carpeta ya existe")    
                
    return Path.joinpath(ruta,archivo)    

def escrituraArchivo(Monedero,repeticionMoneda,rutaFile, miList):
    subtotalDivisa,totalDivisa,newMonedas = miList[0],miList[1],miList[2]
    limT = len(Monedero)
    limS = len(totalDivisa)
    archivo = open(rutaFile,"w",encoding='UTF-8')
    for i in range(0,limT,1):
        archivo.write(Monedero[i].toString())
        archivo.write(f"Hubo un total de: {repeticionMoneda[i]} Elementos repetidos")
        archivo.write(f"Hubo un total: {subtotalDivisa[i]}\n")
    
    for j in range(0,limS,1): 
        archivo.write(f"De la divisa: {newMonedas[j]} hubo un total de {totalDivisa[j]}\n")
    
    archivo.close() 

def escrituraData(Monedero, repeticionMoneda) -> None:
    print("Usted guardar la informacion capturada")
    nomFileOut = input("Deme el nombre del archivo: ")
    
    fileOut = open(nomFileOut,"w",encoding='UTF-8')
    limMoneda = len(Monedero)
    fileOut.write("Nombre,Valor,Escudo,Año,Pais,Repeticion"+'\n')
    for i in range(0,limMoneda,1):
        nomDiv = Monedero[i].getDivisa()
        valMoneda = Monedero[i].getValor()
        nomEscudo = Monedero[i].getEscudo()
        añoMone = Monedero[i].getAño()
        nomPais = Monedero[i].getPais()
        linea = nomDiv+','+str(valMoneda)+','+nomEscudo+','+str(añoMone)
        linea += ','+nomPais
        fileOut.write(linea+','+str(repeticionMoneda[i])+'\n')
    print("-"*50)
    fileOut.close()
     
           
def salida(Monedero,repeticionMoneda,miList) -> None:
    subtotalDivisa,totalDivisa,newMonedas = miList[0],miList[1],miList[2]
     
    print(guion)
    for i in range(0,len(Monedero),1):
        print(Monedero[i].toString())
        print("Hubo un total de: ",repeticionMoneda[i]," Elementos repetidos")
        print("En subtotal hay: ",subtotalDivisa[i])
        print(guion)
    
    for r in range(0,len(totalDivisa),1):
        print("De la divisa: "+str(newMonedas[r]),end=" ")
        print("Hubo un total de: "+str(totalDivisa[r]))
    print(guion)
        
def main() -> None:
    afir = "S"
    while afir == "S" or afir == "s":
        system("cls")
        meta()
        opc = Cap.capCade("Seleccione una opcion Manual/Fichero: ")
        match opc.lower():
            case "manual": mone,rept = capturaManual()
            case "fichero": mone,rept = capturaFichero()
            case _: continue
        misResul = calculos(mone,rept)
        salida(mone,rept,misResul)
        
        opc = Cap.capCade("Desea guardar los datos capturados?[S/N] ",1)
        if opc.lower() == 's': escrituraData(mone,rept)
        
        opc = Cap.capCade("Desea guardar la informacion en pantalla[S/N]: ",1)
        if opc.lower() == "s":
            ruta = generarCarpeta()
            escrituraArchivo(mone,rept,ruta,misResul)
        
        print("-"*50)
        afir = input("Desea repetir el proceso[S/N]: ")

main()

if __name__ == "main":
    main()