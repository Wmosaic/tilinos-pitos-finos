from typing import Self
from Moneda import *
from PythonCap import *
from PythonVal import *

Val = PythonVal()
Cap = PythonCap()

cuenta = 0
moneda = []
monedas = []
repeticionMoneda = []

def Navegabilidad():
        AFF = 'SI'
        while AFF == 'SI':
            meta()
            print("Seleccione una opción (Tradicional/Fichero): ")
            opcion = input().lower()
            if opcion == 'tradicional':
                CapturaManual()
            elif opcion == 'fichero':
                CapturaCSV()
            else:
                print('Seleccione una opción válida')
                continue
            
            Calculos()
            Salida()
            print("Capturar otros datos AFF: ")
            AFF = input().upper()

def meta():
        print("Capturar y desplegar una lista de monedas")
        print("Presentes dentro de un monedero totalizando")
        print("las monedas presentes dentro de cada divisa")
        print("Por captura de datos Centinelas o CSV")


def CapturaManual():
        global cuenta
        while cuenta < 100:
            nomDivisa = Cap.capNom("Captura el nombre de la divisa / fin: ")
            if nomDivisa.lower() == "fin":
                break

            valMoneda = Cap.capReal("Capture el valor de la moneda: ",0)

            nomPais = Cap.capNom("Capture el país de la moneda: ")

            añoMoneda = Cap.capInt("Capture el año de la Moneda: ",1900)

            nomEscudo = Cap.capNom("Capture el nombre del escudo: ")

            repeticionMoneda = Cap.capInt("¿Cuántas veces se repiten las características de esta Moneda? ",0)

            monedas.append(Moneda(nomDivisa, valMoneda, nomPais, añoMoneda, nomEscudo))
            repeticionMoneda.append(repeticionMoneda)
            cuenta += 1
        return cuenta
            

def CapturaCSV(): 
        global cuenta
        dir = Cap.capFile("Seleccione su archivo usando su número: ",
                            r'C:\Users\aguir\Desktop\Ejercicios 21-40\Ejercicio 23',
                            '.csv')
                
        
        archivo = open(dir)
        archivo.readline() 

        lineaCSV = archivo.readline().strip().split(",") 
        for fila in lineaCSV:
            nomDivisa, valMoneda, nomPais, añoMoneda, nomEscudo, repeticion = lineaCSV 
        
            moneda.append(Moneda(nomDivisa,valMoneda, nomPais, añoMoneda, nomEscudo))
            repeticionMoneda.append(repeticion)
            cuenta += 1
            lineaCSV = archivo.readline().strip().split(",")
        
        archivo.close()
        return moneda, cuenta, repeticionMoneda
    

def setDivisas():
        divisas_filtradas = set() 
        
        for moneda in monedas:
            divisas_filtradas.add(moneda.getDivisa())
        
        return list(divisas_filtradas)
    
def Calculos():
        nuevas_divisas = setDivisas() 
        cuenta_val = []

        for divisa in nuevas_divisas:
            dinero = 0
            for i in range(len(monedas)):
                if divisa == monedas[i].getDivisa():
                    dinero += repeticionMoneda[i] * monedas[i].getValor()
            cuenta_val.append(dinero)

        return cuenta_val
    
    
def Salida():
        new_divisas = setDivisas() 
        print("Su monedero: ")
        for i in range(len(monedas)):
            print(moneda[i].toString())
            print("-------------------")

        for j in range(len(new_divisas)):
            print(f"La divisa: {new_divisas[j]} tiene: {Calculos()[j]}")


class Main:
    Navegabilidad()
