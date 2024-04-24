from os import system

class Referencia:
    
    def __init__(self,x):
        self.xi = x
        
    def incremento(self):
        self.xi += 1
        return self

def meta():
    print("Traducir el ejercicio 24 de java a Python")

def calculos():
    r = Referencia(0)
    alias = Referencia(0)
    
    alias = r.incremento().incremento().incremento()
    alias.incremento().incremento()
    
    return r,alias

def salida(resulR,resulA):
    print("r = "+str(resulR.xi))
    print("alias = "+str(resulA.xi))

def main():
    system("cls")
    meta()
    rR,rA = calculos()
    salida(rR,rA)

main()