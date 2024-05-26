class Padre:
    def Manejar(self) -> None:
        print("El padre lleva su hijo a la escuela")

class Madre:
    def Cocinar(self) -> None:
        print("La madre ama cocinar a su hijo")

class Hijo(Padre,Madre): 
    def Amor(self):
        print("El hijo ama a sus padres")

def main(): 
    objetoTipoHijo = Hijo()
    print("-"*50)
    print("Llamando al metodo del padre: ")
    objetoTipoHijo.Manejar()
    print("-"*50)
    print("Llamando el metodo de la madre: ")
    objetoTipoHijo.Cocinar()
    print("-"*50)
    print("Llamando al metodo del hijo: ")
    objetoTipoHijo.Amor()

main()